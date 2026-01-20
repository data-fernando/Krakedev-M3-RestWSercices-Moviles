package com.krakedev.entidades;

public class TipoDocumento {
	private String id_documento;
	private String descripcion_documento;
	public String getId_documento() {
		return id_documento;
	}
	public void setId_documento(String id_documento) {
		this.id_documento = id_documento;
	}
	public String getDescripcion_documento() {
		return descripcion_documento;
	}
	public void setDescripcion_documento(String descripcion_documento) {
		this.descripcion_documento = descripcion_documento;
	}
	@Override
	public String toString() {
		return "TipoDocumento [id_documento=" + id_documento + ", descripcion_documento=" + descripcion_documento + "]";
	}
	public TipoDocumento(String id_documento, String descripcion_documento) {
		super();
		this.id_documento = id_documento;
		this.descripcion_documento = descripcion_documento;
	}
	public TipoDocumento() {
		super();
	}
	
	
}
