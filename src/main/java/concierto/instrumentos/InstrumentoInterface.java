package concierto.instrumentos;

import concierto.excepciones.InstrumentoRotoException;

public interface InstrumentoInterface {
	
	public String sonar() throws InstrumentoRotoException; 

}
