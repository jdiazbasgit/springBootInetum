package curso.inetum.primerspringboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.inetum.primerspringboot.entidades.Empleado;
import curso.inetum.primerspringboot.repositorios.EmpleadoCrudRepository;
import lombok.Data;

@RestController
@Data
public class EmpleadosRestController {
	
	@Autowired
	private EmpleadoCrudRepository repository;
	
	@GetMapping("empleados")
	public Iterable<Empleado> empleados(){
		
		return getRepository().findAll();
		
	}

}
