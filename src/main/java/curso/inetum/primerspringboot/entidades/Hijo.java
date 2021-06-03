package curso.inetum.primerspringboot.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Entity
@Table(name = "hijos")
@Data
@RestResource(path = "/hijos", rel = "hijo")
public class Hijo  extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int idHijo;
	
	private int chicos;
	
	private int chicas;

}
