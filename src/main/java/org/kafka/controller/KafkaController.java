package org.kafka.controller;

import org.kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

	private KafkaTemplate<String, Message> kafkaTemplate;
	
	public final String TOPIC = "topic1";
	
	@Autowired
	public KafkaController(KafkaTemplate<String, Message> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	@PostMapping("/produce")
	public void produce(@RequestBody Message message)
	{
		kafkaTemplate.send(TOPIC, message);
	}
}
