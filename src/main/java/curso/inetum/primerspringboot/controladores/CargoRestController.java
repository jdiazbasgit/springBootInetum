package curso.inetum.primerspringboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
	public Resources<Cargo> cargosMio(){
		
		Iterable<Cargo> cargos=getRepository().findAll();
		for (Cargo cargo : cargos) {
			
			cargo.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CargoRestController.class).geCargoById(cargo.getIdCargo())).withSelfRel());
			
		}
		
		return new Resources<Cargo>(cargos);
	}
	
	@GetMapping("/cargoMio/{id}")
	public Resource<Cargo> geCargoById(@PathVariable int id){
		
		Cargo cargo= getRepository().findById(id).get();
		
		cargo.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(CargoRestController.class).geCargoById(id)).withSelfRel());
		
		return new Resource<Cargo>(cargo);
	}
	
	

}
