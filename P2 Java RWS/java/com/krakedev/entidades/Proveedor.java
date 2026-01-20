package com.krakedev.entidades;

public class Proveedor {
	private String id_proveedor;
	private TipoDocumento tipo_documento;
	private String nombre_proveedor;
	private String telefono;
	private String correo;
	private String direccion;
	public String getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(String id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", tipo_documento=" + tipo_documento + ", nombre_proveedor="
				+ nombre_proveedor + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + "]";
	}
	public Proveedor(String id_proveedor, TipoDocumento tipo_documento, String nombre_proveedor, String telefono,
			String correo, String direccion) {
		super();
		this.id_proveedor = id_proveedor;
		this.tipo_documento = tipo_documento;
		this.nombre_proveedor = nombre_proveedor;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}
	public Proveedor() {
		super();
	}
	
	

	
	
	
	


	
}
