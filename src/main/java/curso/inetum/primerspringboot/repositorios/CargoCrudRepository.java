package curso.inetum.primerspringboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.inetum.primerspringboot.entidades.Cargo;

public interface CargoCrudRepository extends CrudRepository<Cargo, Integer> {

}
