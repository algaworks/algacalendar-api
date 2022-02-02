package com.algaworks.algacalendar.api;

import com.algaworks.algacalendar.domain.Tenant;
import com.algaworks.algacalendar.domain.TenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-key")
@AllArgsConstructor
public class ApiKeyController {
	
	private final TenantRepository tenantRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Token tenant() {
		final Tenant tenant = tenantRepository.save(new Tenant());
		return new Token(tenant.getApiKey());
	}
	
}
