package co.com.wiki.superheroes;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import co.com.wiki.superheroes.dto.Superheroe;
import co.com.wiki.superheroes.dto.Superpoder;
import co.com.wiki.superheroes.service.rest.ConsultaSupeheroes;

public class ConsultaSuperheroesTest {

	@Test
	public void probarInformacionSuperman() {
		Superheroe superman = new Superheroe (1, "Superman", "El hombre de acero", new ArrayList<Superpoder>());
		
		ConsultaSupeheroes consultaSuperheroe = new ConsultaSupeheroes ();
		Superheroe superHeroe = consultaSuperheroe.consultarSuperheroe (1);
		
		Assert.assertEquals(superman.getIdentificacion(), superHeroe.getIdentificacion());
		Assert.assertEquals(superman.getNombre(), superHeroe.getNombre());
		Assert.assertEquals(superman.getDescripcion(), superHeroe.getDescripcion());
	}
	
	@Test
	public void probarConfiguracionServicio() {
		Path annotation = ConsultaSupeheroes.class.getAnnotation(Path.class);
		Assert.assertNotNull(annotation);
		Assert.assertEquals("consultas", annotation.value());
	}
	
	@Test
	public void probarInformacionBatman(){
		Superheroe batman = new Superheroe (2, "Batman", "El caballero de la noche", new ArrayList<Superpoder>());
		
		ConsultaSupeheroes consultaSuperheroe = new ConsultaSupeheroes ();
		Superheroe superHeroe = consultaSuperheroe.consultarSuperheroe (2);
		
		Assert.assertEquals(batman.getIdentificacion(), superHeroe.getIdentificacion());
		Assert.assertEquals(batman.getNombre(), superHeroe.getNombre());
		Assert.assertEquals(batman.getDescripcion(), superHeroe.getDescripcion());
	}
	
	@Test
	public void probarConfiguracionServicioConsultaSuperheroe() throws NoSuchMethodException, SecurityException {
		Method metodoConsulta = ConsultaSupeheroes.class.getDeclaredMethod("consultarSuperheroe", int.class);
		Path annotationPath = metodoConsulta.getAnnotation(Path.class);
		Assert.assertNotNull(annotationPath);
		Assert.assertEquals("superheroe/id", annotationPath.value());
		
		GET annotationMetodoHttp = metodoConsulta.getAnnotation(GET.class);
		Assert.assertNotNull(annotationMetodoHttp);
		
		Produces annotationRetorno = metodoConsulta.getAnnotation(Produces.class);
		Assert.assertNotNull(annotationRetorno);
		Assert.assertEquals(MediaType.APPLICATION_JSON, annotationRetorno.value()[0]);
		
	}
}
