package exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/*
Why Is This Important?
Equality: If you have a class that extends another class (like Child extends Parent),
you want to ensure that when you compare two Child objects, the comparison also
considers the properties of Parent. If you don’t do this, two Child objects could be
considered equal even if their parent properties are different.

Hash Code: The hashCode() method is important for storing objects in collections like
HashMap. If two objects are considered equal (via equals()), they must return the same
hash code. This helps with efficient data retrieval.
*/

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException {
	private String message;
	private int statusCode;
	
	public CustomException(String message, int statusCode) {
		super(message);
		this.message = message;
		this.statusCode = statusCode;
	}
	
}
