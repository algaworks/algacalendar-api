package com.algaworks.algacalendar.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Reminder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private LocalDate date;

	public Reminder() {
		
	}

	public Reminder(String title, String description, LocalDate date) {
		this.title = title;
		this.description = description;
		this.date = date;
	}

}
