package concierto.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import concierto.excepciones.InstrumentoRotoException;
import concierto.instrumentos.Instrumento;
import concierto.musicos.HombreOrquesta;
import concierto.musicos.Solista;

@Component
@Aspect
public class MecanicoDeInstrumentos {
	
	@Pointcut("execution(@concierto.anotaciones.Vigilante * *.*(..))")
	public void sujetador() {
		
	}
	
	@Around("sujetador()")
	public Object arreglarInstrumento(ProceedingJoinPoint joinPoint) throws InstrumentoRotoException
	{
		Object salida= null;
		Object musico=joinPoint.getTarget();
		
		try {
			//Before
			salida=joinPoint.proceed();
			//AfterReturning
		} catch (Throwable e) {
			//AfterThrowing
			System.out.println("SEÑORES HAY UNA AVERIA, ENSEGUIDA LO ARREGLAMOS");
			if(musico.getClass().isInstance(new Solista()))
			{
				Solista solista=(Solista) musico;
				solista.getInstrumento().setSonido("sonido arreglado de "+solista.getInstrumento().getClass().getSimpleName());
				System.out.println("SEÑORES HEMOS ARREGLADO EL PROBLEMA, CONTINUAMOS EL CONCIERTO");
				solista.tocar();
			}
			else {
				HombreOrquesta hombreOrquesta=(HombreOrquesta) musico;
				
				for (Instrumento instrumento : hombreOrquesta.getInstrumentos()) {
					if(instrumento.getSonido().equals("nada"))
						instrumento.setSonido("sonido arreglado de "+instrumento.getClass().getSimpleName());
					
				}
				System.out.println("SEÑORES HEMOS ARREGLADO EL PROBLEMA, CONTINUAMOS EL CONCIERTO");
				hombreOrquesta.tocar();
				
			}
		}
		finally {
			//After
		}
		
		
		return salida;
	}

}
