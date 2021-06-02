package curso.inetum.primerspringboot.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Table(name = "datos_personales")
@Data
public class DatoPersonal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	private String estadoCivil;
	@ManyToOne
	@JoinColumn(name = "hijos_id")
	@Fetch(FetchMode.JOIN)
	private Hijo hijo;
	

}
