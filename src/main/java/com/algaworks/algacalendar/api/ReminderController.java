package com.algaworks.algacalendar.api;

import com.algaworks.algacalendar.domain.Reminder;
import com.algaworks.algacalendar.domain.ReminderFilter;
import com.algaworks.algacalendar.domain.ReminderRepository;
import com.algaworks.algacalendar.domain.ReminderSpecs;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/reminders")
@AllArgsConstructor
public class ReminderController {
	
	private final ReminderRepository reminders;
	private final CurrentTenant currentTenant;
	
	@GetMapping
	public List<Reminder> getAll(@RequestParam YearMonth yearMonth) {
		return reminders.findAll(ReminderSpecs.usingFilter(new ReminderFilter(yearMonth, currentTenant.getTenantId())));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reminder create(@RequestBody @Valid ReminderInput input) {
		return reminders.save(input.toReminder(currentTenant.getTenantId()));
	}

	@GetMapping("{reminderId}")
	public Reminder getOne(@PathVariable Long reminderId) {
		return reminders.findByIdAndTenantId(reminderId, currentTenant.getTenantId())
				.orElseThrow(()-> new EntityNotFoundException("Não foi possível encontrar esse lembrete."));
	}

	@PutMapping("{reminderId}")
	public Reminder update(@RequestBody @Valid ReminderInput input, 
	                       @PathVariable Long reminderId) {
		var reminder = this.getOne(reminderId);
		reminder.setTitle(input.getTitle());
		reminder.setDescription(input.getDescription());
		reminder.setDate(input.getDate());
		return reminders.save(reminder);
	}

	@DeleteMapping("{reminderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long reminderId) {
		var reminder = this.getOne(reminderId);
		reminders.delete(reminder);
	}
}
