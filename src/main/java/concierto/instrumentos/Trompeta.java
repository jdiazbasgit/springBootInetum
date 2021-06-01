package concierto.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tocameAMi")
public class Trompeta extends Instrumento{
	
	

	@Override
	@Value("tuuu, tuuu, tuu en anotaciones")
	public void setSonido(String sonido) {
		super.setSonido(sonido);
	}

}
