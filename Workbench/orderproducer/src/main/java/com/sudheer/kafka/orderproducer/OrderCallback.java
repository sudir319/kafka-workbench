package com.sudheer.kafka.orderproducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderCallback implements Callback {

	public void onCompletion(RecordMetadata metadata, Exception exception) {
		if (exception != null) {
			exception.printStackTrace();
		} else {
			System.out.println("Partition : " + metadata.partition());
			System.out.println("Offset : " + metadata.offset());
			System.out.println("Message sent successfully");
		}
	}
}
