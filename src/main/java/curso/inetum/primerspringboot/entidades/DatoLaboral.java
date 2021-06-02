package curso.inetum.primerspringboot.entidades;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "datos_laborales")
//@RestResource(path = "/datosLaborales", rel = "datoLaboral")
@Data
//@AllArgsConstructor

public class DatoLaboral
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
	//@SequenceGenerator(sequenceName = "SYSTEM_SEQUENCE_C58D429E_B5B8_45DD_9600_531D0B4CBF2A", name = "secuenciacargo")
	private int id;
	
	private GregorianCalendar fechaAlta;
	
	private int salario;
	
	@ManyToOne
	@JoinColumn(name = "cargos_id")
	@Fetch(FetchMode.JOIN)
	private Cargo cargo;

	
}
