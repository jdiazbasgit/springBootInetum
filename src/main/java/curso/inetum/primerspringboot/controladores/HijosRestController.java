package curso.inetum.primerspringboot.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.inetum.primerspringboot.entidades.Empleado;
import curso.inetum.primerspringboot.entidades.Hijo;
import curso.inetum.primerspringboot.repositorios.HijoCrudRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class HijosRestController {
	
	@Autowired
	private HijoCrudRepository repository;
	
	@GetMapping("/getChicos/{chicos}")
	public List<Hijo> getChicos(@PathVariable int chicos){
		
		return getRepository().getChicos(chicos);
		
	}
	
	

}
