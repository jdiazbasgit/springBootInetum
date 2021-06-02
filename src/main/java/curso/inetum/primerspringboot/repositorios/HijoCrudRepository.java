package curso.inetum.primerspringboot.repositorios;

import org.springframework.data.repository.CrudRepository;

import curso.inetum.primerspringboot.entidades.Hijo;

public interface HijoCrudRepository extends CrudRepository<Hijo,Integer> {

}
