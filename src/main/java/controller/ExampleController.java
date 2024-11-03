package controller;

import exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	@GetMapping("/example")
	public String exampleEndpoint() {
		// Some logic...
		/*if (someConditionFails) {
			throw new CustomException("Something went wrong!", 400); // Bad Request
		}*/
		return "Success!";
	}
}
