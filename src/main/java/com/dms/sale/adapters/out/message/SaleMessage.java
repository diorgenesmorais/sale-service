package com.dms.sale.adapters.out.message;

import com.dms.sale.application.core.domain.Sale;
import com.dms.sale.application.core.domain.enums.SaleEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

	private Sale sale;
	private SaleEvent event;

}
