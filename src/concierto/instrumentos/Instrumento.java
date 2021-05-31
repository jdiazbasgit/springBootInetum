package concierto.instrumentos;

public class Instrumento implements InstrumentoInterface {

	private String sonido;
	
	
	
	public Instrumento(String sonido) {
		this.sonido = sonido;
	}
	

	@Override
	public String sonar() {
		return getSonido();
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
