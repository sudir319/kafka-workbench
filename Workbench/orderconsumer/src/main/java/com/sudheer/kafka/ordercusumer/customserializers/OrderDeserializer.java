package com.sudheer.kafka.ordercusumer.customserializers;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderDeserializer implements Deserializer<Order> {

	public Order deserialize(String topic, byte[] data) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(data, Order.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
