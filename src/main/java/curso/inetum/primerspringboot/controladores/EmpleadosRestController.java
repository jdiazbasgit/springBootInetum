package curso.inetum.primerspringboot.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Iterable<Empleado> empleados(){
		
		return getRepository().findAll();
		
	}
	
	@GetMapping("/empleadosByName/{name}")
	public List<Empleado> getEmpleadosByyName(@PathVariable String name){
		
		return getRepository().getEmpleadosByName(name);
	}

}
