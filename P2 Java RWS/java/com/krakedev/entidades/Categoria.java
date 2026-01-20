package com.krakedev.entidades;

public class Categoria {
	
	private int id_categoria;
	private String nombre_categoria;
	private Categoria categoria_padre;
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	public Categoria getCategoria_padre() {
		return categoria_padre;
	}
	public void setCategoria_padre(Categoria categoria_padre) {
		this.categoria_padre = categoria_padre;
	}
	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nombre_categoria=" + nombre_categoria
				+ ", categoria_padre=" + categoria_padre + "]";
	}
	public Categoria(int id_categoria, String nombre_categoria, Categoria categoria_padre) {
		super();
		this.id_categoria = id_categoria;
		this.nombre_categoria = nombre_categoria;
		this.categoria_padre = categoria_padre;
	}
	public Categoria() {
		super();
	}
	
	
}
