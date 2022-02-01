package com.algaworks.algacalendar.api;

public class UnauthorizedTenantHeaderException extends RuntimeException {

	public UnauthorizedTenantHeaderException() {
		super("Inclua um header X-Authorization válido.");
	}
}
