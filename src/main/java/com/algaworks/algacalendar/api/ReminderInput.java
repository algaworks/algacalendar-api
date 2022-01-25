package com.algaworks.algacalendar.api;

import com.algaworks.algacalendar.domain.Reminder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ReminderInput {

	@NotBlank
	private String title;
	@NotBlank
	private String description;
	@NotNull
	private LocalDate date;

	public Reminder toReminder() {
		return new Reminder(this.title, 
				this.description, 
				this.date);
	}
}
