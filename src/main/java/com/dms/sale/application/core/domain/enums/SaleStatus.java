package com.dms.sale.application.core.domain.enums;

import java.util.Arrays;

public enum SaleStatus {
	PENDING(1),
	FINALIZED(2),
	CANCELED(3);
	
	private final Integer statusId;
	
	SaleStatus(Integer id) {
		statusId = id;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public static SaleStatus toEnum(Integer id) {
		if (id == null) return null;
		return Arrays.stream(SaleStatus.values())
				.filter(status -> id.equals(status.getStatusId()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format(
						"ID %s com status inválido", id)));
	}
}
