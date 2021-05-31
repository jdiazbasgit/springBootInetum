package concierto.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concierto.musicos.HombreOrquesta;

public class ConciertoHombreOrquestaSpring {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		HombreOrquesta hombreOrquesta= (HombreOrquesta) ctx.getBean("hombreOrquesta");
		hombreOrquesta.tocar();
	}

}
