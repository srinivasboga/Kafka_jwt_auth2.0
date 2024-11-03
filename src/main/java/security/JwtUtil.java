package security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
	private String secretKey = "secret"; // Use a stronger key in production
	private long validityInMilliseconds = 3600000; // 1 hour
	
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	public Boolean validateToken(String token, String username) {
		final String extractedUsername = extractUsername(token);
		return (extractedUsername.equals(username) && !isTokenExpired(token));
	}
	
	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractAllClaims(token).getExpiration().before(new Date());
	}
}
