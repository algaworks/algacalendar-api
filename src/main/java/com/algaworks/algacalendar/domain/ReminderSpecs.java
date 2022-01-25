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

			if (filter.getYear() != null) {
				Expression<LocalDate> expression = builder.function("FORMATDATETIME", 
						LocalDate.class , root.get("date"), builder.literal("yyyy"));

				predicates.add(builder.equal(expression, filter.getYear()));
			}

			if (filter.getMonth() != null) {
				Expression<LocalDate> expression = builder.function("FORMATDATETIME",
						LocalDate.class , root.get("date"), builder.literal("MM"));

				predicates.add(builder.equal(expression, filter.getMonth()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
	
}
