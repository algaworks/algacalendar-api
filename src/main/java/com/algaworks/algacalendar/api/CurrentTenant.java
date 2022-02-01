package com.algaworks.algacalendar.api;

import com.algaworks.algacalendar.domain.TenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
@AllArgsConstructor
@RequestScope
public class CurrentTenant {
	
	private final HttpServletRequest request;
	private final TenantRepository tenants;
	
	public Long getTenantId() {
		var apiKey = Optional.ofNullable(request.getHeader("X-Authorization"))
				.orElseThrow(UnauthorizedTenantHeaderException::new);
		var tenant = tenants.findByApiKey(apiKey)
				.orElseThrow(UnauthorizedTenantHeaderException::new);
		return tenant.getId();
	}
}
