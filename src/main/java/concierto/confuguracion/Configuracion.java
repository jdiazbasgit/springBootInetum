package concierto.confuguracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import concierto.musicos.Solista;

@Configuration
@ComponentScan(value={"concierto"})
@EnableAspectJAutoProxy
public class Configuracion {
	
	

}
