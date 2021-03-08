package org.kafka.controller;

import org.kafka.model.Item;
import org.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

	private KafkaTemplate<String, String> kafkaTemplate;
	private Gson jsonConverter;
	
	public final String TOPIC = "topic1";
	public final String TOPIC2 = "topic2";
	
	@Autowired
	public KafkaController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
		this.kafkaTemplate = kafkaTemplate;
		this.jsonConverter = jsonConverter;
	}
	
	@PostMapping("/produce")
	public void produce(@RequestBody Message message)
	{
		kafkaTemplate.send(TOPIC, jsonConverter.toJson(message));
	}
	
	@PostMapping("/produce/item")
	public void produce(@RequestBody Item item)
	{
		kafkaTemplate.send(TOPIC2, jsonConverter.toJson(item));
	}
}
