package concierto.musicos;

import concierto.instrumentos.Instrumento;

public class HombreOrquesta extends Musico {

	@Override
	public void tocar() {
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}

	}

}
