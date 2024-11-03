package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import security.JwtUtil;
import service.KafkaProducerService;
import service.UserService;

@RestController
public class AuthController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody User user) {
		// Authenticate user
		// For demonstration, directly generate a token
		return jwtUtil.generateToken(user.getUsername());
	}
	
	@PostMapping("/sendMessage")
	public String sendMessage(@RequestParam String message) {
		kafkaProducerService.sendMessage(message);
		return "Message sent to Kafka: " + message;
	}
}
