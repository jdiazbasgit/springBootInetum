package concierto.musicos;

import concierto.excepciones.InstrumentoRotoException;

public interface MusicoInterface {
	
	public void tocar() throws InstrumentoRotoException;

}
