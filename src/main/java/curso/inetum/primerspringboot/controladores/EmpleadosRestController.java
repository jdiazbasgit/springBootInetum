package curso.inetum.primerspringboot.controladores;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.inetum.primerspringboot.entidades.Empleado;
import curso.inetum.primerspringboot.repositorios.EmpleadoCrudRepository;
import lombok.Data;

@RestController
@Data
@RequestMapping("/api")
public class EmpleadosRestController {
	
	@Autowired
	private EmpleadoCrudRepository repository;
	
	@GetMapping("empleadosMio")
	public Resources<Empleado> empleados(){
		
		Iterable<Empleado> empleados=getRepository().findAll();
		for (Empleado empleado : empleados) {
			empleado.add(linkTo(methodOn(DatosLaboralesRestController.class).
					getDatoLaboralById(empleado.getDatoLaboral().getIdDatoLaboral())).withRel("datoLaboral"));
			empleado.add(linkTo(methodOn(DatosPersonalesRestController.class).
					getDatoPersonalById(empleado.getDatoPersonal().getIdDatoPersonal())).withRel("datoPersonal"));
			empleado.add(linkTo(methodOn(EmpleadosRestController.class).getEmpleadosByyId(empleado.getIdEmpleado())).withSelfRel());
		}
		return new Resources<Empleado>(empleados,linkTo(methodOn(EmpleadosRestController.class).empleados()).withSelfRel());
		
	}
	
	
	@GetMapping("empleadosMioPaginadoHateoas/{numero}/{cantidad}")
	public Resources<Empleado> empleadosPaginado(@PathVariable int numero,@PathVariable  int cantidad){
		
		
		Iterable<Empleado> empleados=getRepository().findAll();
		for (Empleado empleado : empleados) {
			empleado.add(linkTo(methodOn(DatosLaboralesRestController.class).
					getDatoLaboralById(empleado.getDatoLaboral().getIdDatoLaboral())).withRel("datoLaboral"));
			empleado.add(linkTo(methodOn(DatosPersonalesRestController.class).
					getDatoPersonalById(empleado.getDatoPersonal().getIdDatoPersonal())).withRel("datoPersonal"));
			empleado.add(linkTo(methodOn(EmpleadosRestController.class).getEmpleadosByyId(empleado.getIdEmpleado())).withSelfRel());
		}
		return new Resources<Empleado>(empleados,linkTo(methodOn(EmpleadosRestController.class).empleados()).withSelfRel());
		
	}
	@GetMapping("empleadosMioPaginados/{pagina}/{cantidad}")
	public Resource<Page<Empleado>> getEmpleadosPaginados(@PathVariable  int pagina, @PathVariable  int cantidad){
		Page<Empleado> empleados=getRepository().findAll(PageRequest.of(pagina, cantidad));
		for (Empleado empleado : empleados.getContent()) {
			empleado.add(linkTo(methodOn(DatosLaboralesRestController.class).
					getDatoLaboralById(empleado.getDatoLaboral().getIdDatoLaboral())).withRel("datoLaboral"));
			empleado.add(linkTo(methodOn(DatosPersonalesRestController.class).
					getDatoPersonalById(empleado.getDatoPersonal().getIdDatoPersonal())).withRel("datoPersonal"));
			empleado.add(linkTo(methodOn(EmpleadosRestController.class).getEmpleadosByyId(empleado.getIdEmpleado())).withSelfRel());
		}
		
		
		return new Resource<Page<Empleado>>(empleados);
	}
	
	
	
	@GetMapping("/empleadosByName/{name}")
	public List<Empleado> getEmpleadosByyName(@PathVariable String name){
		
		return getRepository().getEmpleadosByName(name);
	}
	@GetMapping("/empleadosMio/{id}")
	public Resource<Empleado> getEmpleadosByyId(@PathVariable int id){
		Empleado empleado=getRepository().findById(id).get();
		empleado.add(linkTo(methodOn(DatosLaboralesRestController.class).
				getDatoLaboralById(empleado.getDatoLaboral().getIdDatoLaboral())).withRel("datoLaboral"));
		empleado.add(linkTo(methodOn(DatosPersonalesRestController.class).
				getDatoPersonalById(empleado.getDatoPersonal().getIdDatoPersonal())).withRel("datoPersonal"));
		empleado.add(linkTo(methodOn(EmpleadosRestController.class).getEmpleadosByyId(empleado.getIdEmpleado())).withSelfRel());
		
		return new Resource<Empleado>(empleado);
	}
	
	

}
