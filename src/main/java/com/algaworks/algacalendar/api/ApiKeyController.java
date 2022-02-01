package com.algaworks.algacalendar.api;

import com.algaworks.algacalendar.domain.Tenant;
import com.algaworks.algacalendar.domain.TenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-key")
@AllArgsConstructor
public class ApiKeyController {
	
	private final TenantRepository tenantRepository;
	
	@GetMapping
	public Tenant tenant() {
		return tenantRepository.save(new Tenant());
	}
	
}
