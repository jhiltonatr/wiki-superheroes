package co.com.wiki.superheroes.dto;

import java.util.List;

public class Superheroe {
	
	private int identificacion;
	private String nombre;
	private String descripcion;
	private List<Superpoder> superpoderes;
	
	public Superheroe(int identificacion, String nombre, String descripcion, List<Superpoder> superpoderes){
		this.setIdentificacion(identificacion);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setSuperpoderes(superpoderes);
	}
	
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setSuperpoderes(List<Superpoder> superpoderes) {
		this.superpoderes = superpoderes;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public int getIdentificacion() {
		return this.identificacion;
	}
}
