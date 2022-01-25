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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reminders")
@AllArgsConstructor
public class ReminderController {
	
	private final ReminderRepository reminders;
	
	@GetMapping
	public List<Reminder> getAll(ReminderFilter filter) {
		return reminders.findAll(ReminderSpecs.usingFilter(filter));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reminder create(@RequestBody @Valid ReminderInput input) {
		return reminders.save(input.toReminder());
	}

	@GetMapping("{reminderId}")
	public Reminder getOne(@PathVariable Long reminderId) {
		return reminders.findById(reminderId)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Não foi possível encontrar esse lembrete."));
	}

	@PutMapping("{reminderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody @Valid ReminderInput input, @PathVariable Long reminderId) {
		var reminder = this.getOne(reminderId);
		reminder.setTitle(input.getTitle());
		reminder.setDescription(input.getDescription());
		reminder.setDate(input.getDate());
		reminders.save(reminder);
	}

	@DeleteMapping("{reminderId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long reminderId) {
		var reminder = this.getOne(reminderId);
		reminders.delete(reminder);
	}
}
