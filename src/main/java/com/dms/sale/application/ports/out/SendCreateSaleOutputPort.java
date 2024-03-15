package com.dms.sale.application.ports.out;

import com.dms.sale.application.core.domain.Sale;
import com.dms.sale.application.core.domain.enums.SaleEvent;

public interface SendCreateSaleOutputPort {

	void send(Sale sale, SaleEvent event);
}
