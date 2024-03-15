package com.dms.sale.config.kafka;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.dms.sale.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSerializer implements Serializer<SaleMessage> {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public byte[] serialize(String topic, SaleMessage saleMessage) {
		try {
			if(saleMessage == null) {
				return null;
			}
			return objectMapper.writeValueAsBytes(saleMessage);
		} catch (Exception e) {
			throw new SerializationException("Error when serializing to byte[]");
		}
	}

}
