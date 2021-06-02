package curso.inetum.primerspringboot.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
//@AllArgsConstructor

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	//@GeneratedValue(strategy = GenerationType.SEQUENCE )
	//@SequenceGenerator(sequenceName = "SYSTEM_SEQUENCE_C58D429E_B5B8_45DD_9600_531D0B4CBF2A", name = "secuenciacargo")
	private int id;
	
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "usuarios_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private List<Authority> authorities;

}
