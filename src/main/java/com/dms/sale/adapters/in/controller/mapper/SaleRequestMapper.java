package com.dms.sale.adapters.in.controller.mapper;

import org.mapstruct.Mapper;

import com.dms.sale.adapters.in.controller.request.SaleRequest;
import com.dms.sale.application.core.domain.Sale;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

	Sale toSale(SaleRequest saleRequest);
}
