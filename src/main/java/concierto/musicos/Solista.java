package concierto.musicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import concierto.instrumentos.Instrumento;

@Component
public class Solista implements MusicoInterface {

	@Autowired
	@Qualifier("guitarra")
	private Instrumento instrumento;
	
	
	@Override
	public void tocar() {
		System.out.println(getInstrumento().sonar());
	}


	public Instrumento getInstrumento() {
		return instrumento;
	}


	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
	

}
