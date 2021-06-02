package curso.inetum.primerspringboot.entidades;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;

@Entity
@Table(name = "empleados")
@RestResource(path = "/empleados", rel = "empleado")
@Data
//@AllArgsConstructor

public class Empleado {
	



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
	//@SequenceGenerator(sequenceName = "SYSTEM_SEQUENCE_C58D429E_B5B8_45DD_9600_531D0B4CBF2A", name = "secuenciacargo")
	private int id;

	private String nombre;

	private String telefono;

	private String dni;

	private GregorianCalendar fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "datos_laborales_id")
	@Fetch(FetchMode.JOIN)
	private DatoLaboral datoLaboral;

	
	@ManyToOne
	@JoinColumn(name = "datos_personales_id")
	@Fetch(FetchMode.JOIN)
	private DatoPersonal datoPersonal;


	

}
