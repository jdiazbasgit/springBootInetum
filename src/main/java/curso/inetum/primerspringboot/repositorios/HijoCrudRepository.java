package curso.inetum.primerspringboot.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import curso.inetum.primerspringboot.entidades.Hijo;

public interface HijoCrudRepository extends CrudRepository<Hijo,Integer> {

	@Query("from Hijo h where h.chicos<=:chicos")
	public List<Hijo> getChicos(int chicos);

	

}
