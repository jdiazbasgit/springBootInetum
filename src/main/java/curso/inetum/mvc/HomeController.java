package curso.inetum.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.FRENCH);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("login")
	public ModelAndView login() {
		
		ModelAndView modelAndView= new ModelAndView();
		
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "verLogin", method = RequestMethod.POST)
	public ModelAndView verLogin(@RequestParam String usuario, @RequestParam String clave) {
		ModelAndView modelAndView= new ModelAndView("login");
		if (usuario.equals("pepe") && clave.equals("1234"))
			modelAndView.addObject("OK", "usuario logado correctamente");
		else
			modelAndView.addObject("KO", "usuario o clave no son correctos");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "verLogin/{usuario}/{clave}")
	public ModelAndView verLoginFendly(@PathVariable String usuario, @PathVariable String clave) {
		ModelAndView modelAndView= new ModelAndView("login");
		if (usuario.equals("pepe") && clave.equals("1234"))
			modelAndView.addObject("OK", "usuario logado correctamente");
		else
			modelAndView.addObject("KO", "usuario o clave no son correctos");
		
		return modelAndView;
	}
	
	@RequestMapping("loginObjeto")
	public ModelAndView loginObjeto() {
		ModelAndView modelAndView= new ModelAndView();
		Login login= new Login();
		login.setUsuario("este es mi usuario");
		modelAndView.addObject("login", login);
		return modelAndView;
	}
	
	@RequestMapping(value="verLoginObjeto",method = RequestMethod.POST)
	public ModelAndView verLoginObjeto(Login login) {
		
		ModelAndView modelAndView= new ModelAndView("loginObjeto");
		
		if(login.getUsuario().equals("pepe") && login.getClave().equals("1234"))
			modelAndView.addObject("OK", "usuario logado correctamente");
		else
			modelAndView.addObject("KO", "usuario o clave no son correctos");
		
		
		return modelAndView;
	}
	
	
}
