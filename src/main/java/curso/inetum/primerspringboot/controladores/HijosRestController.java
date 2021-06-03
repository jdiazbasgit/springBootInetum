package curso.inetum.primerspringboot.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
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
	public Resources<Hijo> hijos(){
		
		Iterable<Hijo> hijos=getRepository().findAll();
		for (Hijo hijo : hijos) {
			hijo.add(linkTo(methodOn(HijosRestController.class).getHijoById(hijo.getIdHijo())).withSelfRel());
		}
		
		
		return new Resources<Hijo>(hijos);
	}
	
	
	
	
	@GetMapping("/hijoMio/{id}")
	public Resource<Hijo> getHijoById(@PathVariable int id){
		
		Hijo hijo= getRepository().findById(id).get();
		
		hijo.add(linkTo(methodOn(HijosRestController.class).getHijoById(id)).withSelfRel());
		
		return new Resource<Hijo>(hijo);
	}
	
	@GetMapping("/getChicos/{chicos}")
	public List<Hijo> getChicos(@PathVariable int chicos){
		
		return getRepository().getChicos(chicos);
		
	}
	
	
	

}
