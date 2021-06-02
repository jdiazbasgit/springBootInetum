package curso.inetum.primerspringboot.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import curso.inetum.primerspringboot.entidades.Empleado;


public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {
	
	@Query("from Empleado e where e.nombre=:name")
	//@Query(value = "select * from empleados where nombre=:name", nativeQuery = true)
	public List<Empleado> getEmpleadosByName(String name);

}
