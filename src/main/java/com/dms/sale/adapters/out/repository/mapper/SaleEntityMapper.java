package com.dms.sale.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.dms.sale.adapters.out.repository.entity.SaleEntity;
import com.dms.sale.application.core.domain.Sale;
import com.dms.sale.application.core.domain.enums.SaleStatus;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

	@Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
	SaleEntity toSaleEntity(Sale sale);
	
	@Named("setStatusId")
	default Integer setStatusId(SaleStatus saleStatus) {
		return saleStatus.getStatusId();
	}
	
	@Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
	Sale toSale(SaleEntity saleEntity);
	
	@Named("setStatus")
	default SaleStatus setStatus(Integer statusId) {
		return SaleStatus.toEnum(statusId);
	}
}
