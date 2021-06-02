package curso.inetum.primerspringboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.inetum.primerspringboot.entidades.DatoPersonal;

public interface DatoPersonalCrudRepository extends CrudRepository<DatoPersonal, Integer> {

}
