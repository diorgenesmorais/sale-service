package com.dms.sale.application.core.usecase;

import com.dms.sale.application.core.domain.Sale;
import com.dms.sale.application.core.domain.enums.SaleEvent;
import com.dms.sale.application.core.domain.enums.SaleStatus;
import com.dms.sale.application.ports.out.SaveSaleOutputPort;
import com.dms.sale.application.ports.out.SendCreateSaleOutputPort;

public class CreateSaleUseCase {

	private final SaveSaleOutputPort saveSaleOutputPort;
	private final SendCreateSaleOutputPort sendCreateSaleOutputPort;

	public CreateSaleUseCase(SaveSaleOutputPort saveSaleOutputPort, SendCreateSaleOutputPort sendCreateSaleOutputPort) {
		this.saveSaleOutputPort = saveSaleOutputPort;
		this.sendCreateSaleOutputPort = sendCreateSaleOutputPort;
	}

	public void create(Sale sale) {
		sale.setStatus(SaleStatus.PENDING);
		var saleResponse = saveSaleOutputPort.save(sale);
		sendCreateSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
	}
}
