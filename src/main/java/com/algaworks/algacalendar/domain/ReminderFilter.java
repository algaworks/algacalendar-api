package com.algaworks.algacalendar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.YearMonth;

@Data
@AllArgsConstructor
public class ReminderFilter {

	private YearMonth yearMonth;
	private Long tenantId;

}
