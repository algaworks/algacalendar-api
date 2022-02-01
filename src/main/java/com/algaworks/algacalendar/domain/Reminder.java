package com.algaworks.algacalendar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@JsonIgnore
	private Long tenantId;

	public Reminder() {
		
	}

	public Reminder(String title, String description, LocalDate date, Long tenantId) {
		this.title = title;
		this.description = description;
		this.date = date;
		this.tenantId = tenantId;
	}

}
