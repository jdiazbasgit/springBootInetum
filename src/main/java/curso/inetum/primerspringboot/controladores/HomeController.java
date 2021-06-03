package curso.inetum.primerspringboot.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                                           
public class HomeController {
	
	
	@GetMapping(value = {"/","login"})
	public String home() {
		return "login";
	}
	
	@GetMapping("acceso")
	public String acceso() {
		return "acceso";
	}
	
	//@GetMapping("logout")
	public String logout() {
		return "login";
	}

}
