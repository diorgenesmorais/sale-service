package com.dms.sale.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dms.sale.adapters.out.SendCreatedSaleAdapter;
import com.dms.sale.adapters.out.repository.SaveSaleAdapter;
import com.dms.sale.application.core.usecase.CreateSaleUseCase;

@Configuration
public class CreateSaleConfig {

	@Bean
	CreateSaleUseCase createSaleUseCase(SaveSaleAdapter saveSaleAdapter, SendCreatedSaleAdapter sendCreatedSaleAdapter) {
		return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
	}
}
