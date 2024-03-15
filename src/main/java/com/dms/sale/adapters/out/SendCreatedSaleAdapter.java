package com.dms.sale.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.dms.sale.adapters.out.message.SaleMessage;
import com.dms.sale.application.core.domain.Sale;
import com.dms.sale.application.core.domain.enums.SaleEvent;
import com.dms.sale.application.ports.out.SendCreateSaleOutputPort;

@Component
public class SendCreatedSaleAdapter implements SendCreateSaleOutputPort {

	@Autowired
	private KafkaTemplate<String, SaleMessage> kafkaTemplate;
	
	@Override
	public void send(Sale sale, SaleEvent event) {
		SaleMessage saleMessage = new SaleMessage(sale, event);
		kafkaTemplate.send("tp-saga-sale", saleMessage);
	}

}
