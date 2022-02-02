package com.algaworks.algacalendar.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Data
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String apiKey = UUID.randomUUID().toString();
	
	@CreationTimestamp
	private OffsetDateTime createdAt;
	
}
