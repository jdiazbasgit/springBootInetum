package curso.inetum.primerspringboot.controladores;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.inetum.primerspringboot.entidades.DatoPersonal;
import curso.inetum.primerspringboot.repositorios.DatoPersonalCrudRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class DatosPersonalesRestController {
	
	@Autowired
	private DatoPersonalCrudRepository repository;
	
	@GetMapping("datosPersonalesMio")
	public Resources<DatoPersonal> datosPersonales(){
		
		Iterable<DatoPersonal> datosPersonales=getRepository().findAll();
		for (DatoPersonal datoPersonal : datosPersonales) {
			datoPersonal.add(linkTo(methodOn(HijosRestController.class).getHijoById(datoPersonal.getHijo().getId())).withRel("hijo"));
			datoPersonal.add(linkTo(methodOn(DatosPersonalesRestController.class).getDatoPersonalById(datoPersonal.getIdDatoPersonal())).withSelfRel());

		}
		
		return new Resources<DatoPersonal>(datosPersonales,linkTo(methodOn(HijosRestController.class)).withSelfRel()); 
		
	}
	
	@GetMapping("/datoPersonalMio/{id}")
	public Resource<DatoPersonal> getDatoPersonalById(@PathVariable int id){
		
		DatoPersonal datoPersonal= getRepository().findById(id).get();
		datoPersonal.add(linkTo(methodOn(HijosRestController.class).getHijoById(datoPersonal.getHijo().getId())).withRel("hijo"));
		
		return new Resource<DatoPersonal>(datoPersonal);
	}

}
