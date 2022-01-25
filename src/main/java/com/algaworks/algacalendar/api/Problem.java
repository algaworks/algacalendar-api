package com.algaworks.algacalendar.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@JsonInclude(Include.NON_NULL)
@Data
public class Problem {

	private Integer status;
	private OffsetDateTime timestamp;
	private String type;
	private String title;
	private String detail;
	private String userMessage;
	private List<Object> objects;

	@Builder
	@Data
	public static class Object {
		private String name;
		private String userMessage;
	}
	
}
