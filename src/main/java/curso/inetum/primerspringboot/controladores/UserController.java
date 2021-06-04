package curso.inetum.primerspringboot.controladores;


import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.inetum.primerspringboot.UserDto;
import curso.inetum.primerspringboot.entidades.Authority;
import curso.inetum.primerspringboot.entidades.Usuario;
import curso.inetum.primerspringboot.repositorios.UsuarioCrudRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

@RestController
@Data
public class UserController {

	
	@Autowired
	private UsuarioCrudRepository repository;
	
	
	

	@PostMapping("/user")
	public UserDto getToken(@RequestParam String usuario, @RequestParam String clave) {

		UserDto salida = null;
		Usuario user = getRepository().findByUserName(usuario);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		if (user.getUsername().equals(usuario) && encoder.matches(clave, user.getPassword())) {

			String token = getJWTToken(user.getUsername(), user.getAuthorities());
			salida = new UserDto();
			salida.setUser(usuario);
			salida.setToken(token);
			salida.setRol(user.getAuthorities());
		}

		return salida;

	}

	private String getJWTToken(String username, Set<Authority> roles) {
		String secretKey = "inetum";
		

		String token = Jwts.builder().setId("inetum").setSubject(username).claim("authorities", roles)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}