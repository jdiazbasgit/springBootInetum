package concierto.teatros;

import java.util.ArrayList;

import concierto.instrumentos.Instrumento;
import concierto.musicos.HombreOrquesta;

public class ConciertoHombreOrquesta {

	public static void main(String[] args) {
		
		Instrumento tambor = new Instrumento("pom, pom, pom");
		Instrumento trompeta = new Instrumento("tuuu, tuuu, tuuu");
		Instrumento guitarrra = new Instrumento("tlan, taln tlan");
		HombreOrquesta hombreOrquesta= new HombreOrquesta();
		hombreOrquesta.setInstrumentos(new ArrayList<>());
		hombreOrquesta.getInstrumentos().add(tambor);
		hombreOrquesta.getInstrumentos().add(trompeta);
		hombreOrquesta.getInstrumentos().add(guitarrra);
		hombreOrquesta.tocar();

	}

}
