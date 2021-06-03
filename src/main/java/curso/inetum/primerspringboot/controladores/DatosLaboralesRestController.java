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

import curso.inetum.primerspringboot.entidades.DatoLaboral;
import curso.inetum.primerspringboot.repositorios.DatoLaboralCrudRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class DatosLaboralesRestController {
	
	@Autowired
	private DatoLaboralCrudRepository repository;
	
	@GetMapping("datosLaboralesMio")
	public Resources<DatoLaboral> datosLaborales(){
		
		Iterable<DatoLaboral> datosLaborales=getRepository().findAll();
		for (DatoLaboral datoLaboral : datosLaborales) {
			datoLaboral.add(linkTo(methodOn(CargoRestController.class).geCargoById(datoLaboral.getCargo().getIdCargo())).withRel("cargo"));
			datoLaboral.add(linkTo(methodOn(DatosLaboralesRestController.class).getDatoLaboralById(datoLaboral.getIdDatoLaboral())).withSelfRel());
		}
		
		return new Resources<DatoLaboral>(datosLaborales);
		
	}
	
	@GetMapping("/datoLaboralMio/{id}")
	public Resource<DatoLaboral> getDatoLaboralById(@PathVariable int id){
		DatoLaboral datoLaboral=getRepository().findById(id).get();
		datoLaboral.add(linkTo(methodOn(CargoRestController.class).geCargoById(datoLaboral.getCargo().getIdCargo())).withRel("cargo"));
		datoLaboral.add(linkTo(methodOn(DatosLaboralesRestController.class).getDatoLaboralById(id)).withSelfRel());

		return new Resource<DatoLaboral>(datoLaboral);
	}
	

}
