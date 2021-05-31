package concierto.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class AvisadorDeAudiencia {
	
	@Pointcut("execution(@concierto.anotaciones.Vigilante * *.*(..))")
	public void sujetador() {
		
	}
	
	@Before("sujetador()")
	public void apagarMoviles() {
		System.out.println("señores apaguuen los moviles que va a empezar el concierto");
	}
	
	@AfterReturning("sujetador()")
	public void encenderMoviles() {
		System.out.println("ya pueden encender los moviles que el concierto ha terminado");
	}

}
