package com.technocrat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/kafka")
@RestController
public class KafkaController {
	
	private List<String> messages;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${app.topic}")
	private String topic;
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public void send(@RequestBody String data) {
		kafkaTemplate.send(topic, data);
	}
	
	@KafkaListener(topics="topic-technocrat", groupId="technocrat")
	public void listen(String message) {
		messages.add(message);
	}
	
	@RequestMapping(value="/receive", method=RequestMethod.GET)
	public List<String> recieve() {
		return messages;
	}

}
