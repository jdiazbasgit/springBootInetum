package curso.inetum.primerspringboot;

import java.util.Set;

import curso.inetum.primerspringboot.entidades.Authority;
import lombok.Data;

@Data
public class UserDto {

	private String user;
	
	private String token;
	
	private Set<Authority> rol;



}

