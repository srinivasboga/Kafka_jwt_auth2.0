package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private final String TOPIC = "user-activity";
	
	public void sendMessage(String message) {
		kafkaTemplate.send(TOPIC, message);
	}
}
