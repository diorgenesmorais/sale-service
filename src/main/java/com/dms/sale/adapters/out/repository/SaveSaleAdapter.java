package com.dms.sale.adapters.out.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.dms.sale.adapters.out.repository.entity.SaleEntity;
import com.dms.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.dms.sale.application.core.domain.Sale;
import com.dms.sale.application.ports.out.SaveSaleOutputPort;

public class SaveSaleAdapter implements SaveSaleOutputPort {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private SaleEntityMapper saleEntityMapper;
	
	@Override
	public Sale save(Sale sale) {
		SaleEntity saleEntity = saleEntityMapper.toSaleEntity(sale);
		var saleSaved = saleRepository.save(saleEntity);
		return saleEntityMapper.toSale(saleSaved);
	}

}
