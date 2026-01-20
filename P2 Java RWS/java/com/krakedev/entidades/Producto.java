package com.krakedev.entidades;

public class Producto {
	private int producto_pk;
	private String nombre;
	private double precio_venta;
	private double costo_producto;
	private boolean tieneIVA;
	private int stock;
	private UnidadMedia unidad_medidaPr;
	private Categoria categoria_pr;
	
	
	@Override
	public String toString() {
		return "Producto [producto_pk=" + producto_pk + ", nombre=" + nombre + ", precio_venta=" + precio_venta
				+ ", costo_producto=" + costo_producto + ", tieneIVA=" + tieneIVA + ", Stock=" + stock
				+ ", unidad_medidaPr=" + unidad_medidaPr + ", categoria_pr=" + categoria_pr + "]";
	}


	public Producto(int producto_pk, String nombre, double precio_venta, double costo_producto, boolean tieneIVA,
			int stock, UnidadMedia unidad_medidaPr, Categoria categoria_pr) {
		super();
		this.producto_pk = producto_pk;
		this.nombre = nombre;
		this.precio_venta = precio_venta;
		this.costo_producto = costo_producto;
		this.tieneIVA = tieneIVA;
		this.stock = stock;
		this.unidad_medidaPr = unidad_medidaPr;
		this.categoria_pr = categoria_pr;
	}


	public Producto() {
		super();
	}


	public int getProducto_pk() {
		return producto_pk;
	}


	public void setProducto_pk(int producto_pk) {
		this.producto_pk = producto_pk;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio_venta() {
		return precio_venta;
	}


	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}


	public double getCosto_producto() {
		return costo_producto;
	}


	public void setCosto_producto(double costo_producto) {
		this.costo_producto = costo_producto;
	}


	public boolean isTieneIVA() {
		return tieneIVA;
	}


	public void setTieneIVA(boolean tieneIVA) {
		this.tieneIVA = tieneIVA;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public UnidadMedia getUnidad_medidaPr() {
		return unidad_medidaPr;
	}


	public void setUnidad_medidaPr(UnidadMedia unidad_medidaPr) {
		this.unidad_medidaPr = unidad_medidaPr;
	}


	public Categoria getCategoria_pr() {
		return categoria_pr;
	}


	public void setCategoria_pr(Categoria categoria_pr) {
		this.categoria_pr = categoria_pr;
	}
	
	
	
	
	
}
