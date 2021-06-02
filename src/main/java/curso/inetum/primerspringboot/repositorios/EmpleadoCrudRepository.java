package curso.inetum.primerspringboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.inetum.primerspringboot.entidades.Empleado;

public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

}
