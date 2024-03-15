package com.dms.sale.application.ports.out;

import com.dms.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

	Sale save(Sale sale);
}
