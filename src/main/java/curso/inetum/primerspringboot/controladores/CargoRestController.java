package curso.inetum.primerspringboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.inetum.primerspringboot.entidades.Cargo;
import curso.inetum.primerspringboot.repositorios.CargoCrudRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class CargoRestController {
	
	@Autowired
	private CargoCrudRepository repository;
	
	@GetMapping("cargosMio")
	public Iterable<Cargo> cargosMio(){
		return getRepository().findAll();
	}
	
	@GetMapping("/cargoMio/{id}")
	public Cargo geCargoById(@PathVariable int id){
		
		return getRepository().findById(id).get();
	}
	
	

}
