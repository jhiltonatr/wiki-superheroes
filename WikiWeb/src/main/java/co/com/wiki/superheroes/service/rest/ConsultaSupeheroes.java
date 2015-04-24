package co.com.wiki.superheroes.service.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.wiki.superheroes.dto.Superheroe;
import co.com.wiki.superheroes.dto.Superpoder;

@Path("consultas")
public class ConsultaSupeheroes {
	
	public final static Map<Integer, Superheroe> mapaSuperheroes = new HashMap<Integer, Superheroe>();
	
	static {
		mapaSuperheroes.put (1, new Superheroe(1, "Superman", "El hombre de acero", new ArrayList<Superpoder>()));
		mapaSuperheroes.put (2, new Superheroe (2, "Batman", "El caballero de la noche", new ArrayList<Superpoder>()));		
	}
	
	@Path("superheroe/id")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Superheroe consultarSuperheroe (int id) {
		return mapaSuperheroes.get (id);
	}
}
