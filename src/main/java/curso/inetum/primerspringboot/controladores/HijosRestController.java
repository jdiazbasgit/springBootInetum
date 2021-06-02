package curso.inetum.primerspringboot.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.inetum.primerspringboot.entidades.Hijo;
import curso.inetum.primerspringboot.repositorios.HijoCrudRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class HijosRestController {
	
	@Autowired
	private HijoCrudRepository repository;
	
	@GetMapping("/hijosMio")
	public Iterable<Hijo> hijos(){
		return getRepository().findAll();
	}
	
	@GetMapping("/hijo/{id}")
	public Hijo getHijoById(@PathVariable int id){
		
		return getRepository().findById(id).get();
	}
	
	@GetMapping("/getChicos/{chicos}")
	public List<Hijo> getChicos(@PathVariable int chicos){
		
		return getRepository().getChicos(chicos);
		
	}
	
	
	

}
