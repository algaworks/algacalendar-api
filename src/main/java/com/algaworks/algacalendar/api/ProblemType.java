package com.algaworks.algacalendar.api;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;

public enum ProblemType {

	INVALID_DATA("/invalid-data", "Dados inválidos", HttpStatus.BAD_REQUEST),
	UNAUTHORIZED("/unauthorized", "Não autenticado", HttpStatus.UNAUTHORIZED),
	FORBIDDEN("/forbidden", "Acesso negado", HttpStatus.FORBIDDEN),
	SYSTEM_ERROR("/system-error", "Erro de sistema", HttpStatus.INTERNAL_SERVER_ERROR),
	INVALID_PARAMETER("/invalid-parameter", "Parâmetro inválido", HttpStatus.BAD_REQUEST),
	INCOMPREHENSIBLE_MESSAGE("/incomprehensible-message", "Mensagem incompreensível", HttpStatus.BAD_REQUEST),
	RESOURCE_NOT_FOUND("/resource-not-found", "Recurso não encontrado", HttpStatus.NOT_FOUND),
	ENTITY_IN_USE("/entity-in-use", "Entidade em uso", HttpStatus.BAD_REQUEST),
	BUSINESS_ERROR("/business-error", "Violação de regra de negócio", HttpStatus.BAD_REQUEST);

	private final String title;
	private final String uri;
	private final HttpStatus status;

	ProblemType(String path, String title, HttpStatus status) {
		this.uri = "https://algaworks.com.br" + path;
		this.title = title;
		this.status = status;
	}

	public static Optional<ProblemType> of(HttpStatus status) {
		return Arrays.stream(ProblemType.values()).filter(type -> type.status.equals(status)).findFirst();
	}

	public String getTitle() {
		return title;
	}

	public String getUri() {
		return uri;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
