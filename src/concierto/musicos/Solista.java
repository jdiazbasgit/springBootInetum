package concierto.musicos;

public class Solista extends Musico {

	@Override
	public void tocar() {
		System.out.println(getInstrumento().sonar());

	}
	
	

}
