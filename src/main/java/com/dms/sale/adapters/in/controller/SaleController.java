package com.dms.sale.adapters.in.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dms.sale.adapters.in.controller.mapper.SaleRequestMapper;
import com.dms.sale.adapters.in.controller.request.SaleRequest;
import com.dms.sale.application.core.domain.Sale;
import com.dms.sale.application.ports.in.CreateSaleInputPort;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

	@Autowired
	private CreateSaleInputPort createSaleInputPort;
	
	@Autowired
	private SaleRequestMapper saleRequestMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createSale(@Valid @RequestBody SaleRequest saleRequest) {
		log.info("Criando a venda...");
		Sale sale = saleRequestMapper.toSale(saleRequest);
		createSaleInputPort.create(sale);
		log.info("Venda criada com sucesso!");
	}
}
