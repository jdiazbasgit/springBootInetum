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
@Table(name="cargos")
@RestResource(path = "/cargos", rel = "cargo")
@Data
//@AllArgsConstructor

public class Cargo extends ResourceSupport{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
	//@SequenceGenerator(sequenceName = "SYSTEM_SEQUENCE_C58D429E_B5B8_45DD_9600_531D0B4CBF2A", name = "secuenciacargo")
	private int idCargo;
	
	private String descripcion;

	

}
