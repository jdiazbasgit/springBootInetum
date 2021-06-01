package concierto.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concierto.excepciones.InstrumentoRotoException;
import concierto.musicos.HombreOrquesta;
import concierto.musicos.MusicoInterface;
import concierto.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		MusicoInterface solista = (MusicoInterface) ctx.getBean("solista");

		try {
			solista.tocar();
			/*
			 * System.out.println("------ cambio sonido -----");
			 * solista.getInstrumento().setSonido("sonido cabiado");
			 * System.out.println("--- hombre orquesta---"); hombreOrqesta.tocar();
			 * System.out.println("---- solista ---"); solista.tocar();
			 */
		} catch (InstrumentoRotoException e) {

		}

	}

}
