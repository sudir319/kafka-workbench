package com.sudheer.kafka.ordercusumer.customserializers;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class OrderConsumer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.deserializer", StringDeserializer.class.getName());
		props.setProperty("value.deserializer", OrderDeserializer.class.getName());
		props.setProperty("group.id", "OrderGroup");
		
		KafkaConsumer<String, Order> consumer = new KafkaConsumer<String, Order>(props);
		consumer.subscribe(Collections.singletonList("OrderCSTopic"));
		ConsumerRecords<String, Order> orders = consumer.poll(Duration.ofSeconds(30));
		
		for(ConsumerRecord<String, Order> order: orders) {
			System.out.println("Product Name : " + order.key());
			System.out.println("Order Details : " + order.value());
		}
		
		consumer.close();
	}
}