package concierto.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concierto.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		Solista solista=(Solista) ctx.getBean("solista");
		solista.tocar();

	}

}
