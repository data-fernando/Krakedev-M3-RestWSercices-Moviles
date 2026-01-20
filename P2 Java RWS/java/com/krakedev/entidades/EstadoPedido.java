package com.krakedev.entidades;

public class EstadoPedido {
	
	private String id_estado;
	private String descripcion_estado;
	public String getId_estado() {
		return id_estado;
	}
	public void setId_estado(String id_estado) {
		this.id_estado = id_estado;
	}
	public String getDescripcion_estado() {
		return descripcion_estado;
	}
	public void setDescripcion_estado(String descripcion_estado) {
		this.descripcion_estado = descripcion_estado;
	}
	public EstadoPedido(String id_estado, String descripcion_estado) {
		super();
		this.id_estado = id_estado;
		this.descripcion_estado = descripcion_estado;
	}
	public EstadoPedido() {
		super();
	}
	@Override
	public String toString() {
		return "EstadoPedido [id_estado=" + id_estado + ", descripcion_estado=" + descripcion_estado + "]";
	}
	
	

}
