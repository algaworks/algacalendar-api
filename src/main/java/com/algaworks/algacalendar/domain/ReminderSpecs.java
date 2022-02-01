package com.algaworks.algacalendar.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReminderSpecs {

	private ReminderSpecs() {
		
	}

	public static Specification<Reminder> usingFilter(ReminderFilter filter) {
		return (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (filter.getYearMonth() != null) {
				Expression<Integer> year = builder.function("year",
						Integer.class , root.get("date"));

				predicates.add(builder.equal(year, filter.getYearMonth().getYear()));

				Expression<Integer> expression = builder.function("month",
						Integer.class , root.get("date"));

				predicates.add(builder.equal(expression, filter.getYearMonth().getMonthValue()));
			}

			if (filter.getTenantId() != null) {
				predicates.add(builder.equal(root.get("tenantId"), filter.getTenantId()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
	
}
