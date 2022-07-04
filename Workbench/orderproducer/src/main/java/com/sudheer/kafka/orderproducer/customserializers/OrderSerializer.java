package com.sudheer.kafka.orderproducer.customserializers;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderSerializer implements Serializer<Order> {

	public byte[] serialize(String topic, Order order) {
		byte[] response = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			response = objectMapper.writeValueAsBytes(order);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

}
