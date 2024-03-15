package com.dms.sale.application.ports.in;

import com.dms.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {

	void create(Sale sale);
}
