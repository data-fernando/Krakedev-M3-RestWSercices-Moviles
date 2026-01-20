package com.krakedev.entidades;

public class UnidadMedia {
	private String simbolo_pk;
	private String nombre;
	private MagnitudMedida objeto_medida_fk;
	
	public UnidadMedia(String simbolo_pk, String nombre, MagnitudMedida objeto_medida_fk) {
		super();
		this.simbolo_pk = simbolo_pk;
		this.nombre = nombre;
		this.objeto_medida_fk = objeto_medida_fk;
	}
	public UnidadMedia() {
		super();
	}
	public String getSimbolo_pk() {
		return simbolo_pk;
	}
	public void setSimbolo_pk(String simbolo_pk) {
		this.simbolo_pk = simbolo_pk;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public MagnitudMedida getObjeto_medida_fk() {
		return objeto_medida_fk;
	}
	public void setObjeto_medida_fk(MagnitudMedida objeto_medida_fk) {
		this.objeto_medida_fk = objeto_medida_fk;
	}
	@Override
	public String toString() {
		return "UnidadMedia [simbolo_pk=" + simbolo_pk + ", nombre=" + nombre + ", objeto_medida_fk=" + objeto_medida_fk
				+ "]";
	}
	
	
	

}
