package curso.inetum.primerspringboot.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import curso.inetum.primerspringboot.entidades.Authority;
import curso.inetum.primerspringboot.entidades.Usuario;
import curso.inetum.primerspringboot.repositorios.UsuarioCrudRepository;
import lombok.Data;

@Data
@Service
public class UserDeatilSErviceMio implements UserDetailsService {

	@Autowired
	private UsuarioCrudRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario= getRepository().findByUserName(username);
		
		List<GrantedAuthority> roles= new ArrayList<>();
		
		for (Authority authority : usuario.getAuthorities()) {
			GrantedAuthority auth= new SimpleGrantedAuthority(authority.getAuthority());
			roles.add(auth);
			
		}
		
		User user= new User(username, usuario.getPassword(), usuario.isEnabled(), true, true, true, roles);
		
		
		return user;
	}

}
