package concierto.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Guitarra extends Instrumento{
	
	

	@Override
	@Value("tlan tlan tlan en anotaciones")
	public void setSonido(String sonido) {
		super.setSonido(sonido);
	}

}
