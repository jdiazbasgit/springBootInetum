package concierto.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concierto.confuguracion.Configuracion;
import concierto.excepciones.InstrumentoRotoException;
import concierto.musicos.HombreOrquesta;
import concierto.musicos.MusicoInterface;

public class ConciertoHombreOrquestaSpring {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(Configuracion.class);
		MusicoInterface hombreOrquesta= (MusicoInterface) ctx.getBean("hombreOrquesta");
		try {
			hombreOrquesta.tocar();
		} catch (InstrumentoRotoException e) {
			
		}
	}

}
