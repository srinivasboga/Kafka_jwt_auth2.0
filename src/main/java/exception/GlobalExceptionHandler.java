package exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatusCode()));
	}
	
	// Other exception handlers can go here (e.g., for RuntimeException, etc.)
	
	// Example ErrorResponse class
	@Getter
	public static class ErrorResponse {
		private final int statusCode;
		private final String message;
		
		public ErrorResponse(int statusCode, String message) {
			this.statusCode = statusCode;
			this.message = message;
		}
		
	}
}
