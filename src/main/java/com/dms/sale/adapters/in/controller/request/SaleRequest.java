package com.dms.sale.adapters.in.controller.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {

	@NotNull
	private Integer userId;
	@NotNull
	private Integer productId;
	@NotNull
	private Integer quantity;
	@PositiveOrZero
	private BigDecimal value;
	
}
