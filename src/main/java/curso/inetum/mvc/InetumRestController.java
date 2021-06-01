package curso.inetum.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InetumRestController {

	//@RequestMapping(value = "/loginRest",method = RequestMethod.POST)
	@GetMapping("loginRest")
	public List<Login> login() {
		Login login = new Login();
		login.setUsuario("pepe");
		login.setClave("1234");
		List<Login> objetos = new ArrayList<Login>();
		objetos.add(login);
		objetos.add(login);
		objetos.add(login);
		objetos.add(login);
		objetos.add(login);
		return objetos;
	}

}
