package com.krakedev.entidades;

public class DetalleV {
	
	private int id_detalleV;
	private int cantidad;
	private double precio_venta;
	private double subtotal;
	private double subtotal_iva;
	private  VentaC ventaC_fk;
	private Producto producto_fk;
	@Override
	public String toString() {
		return "DetalleV [id_detalleV=" + id_detalleV + ", cantidad=" + cantidad + ", precio_venta=" + precio_venta
				+ ", subtotal=" + subtotal + ", subtotal_iva=" + subtotal_iva + ", ventaC_fk=" + ventaC_fk
				+ ", producto_fk=" + producto_fk + "]";
	}
	public int getId_detalleV() {
		return id_detalleV;
	}
	public void setId_detalleV(int id_detalleV) {
		this.id_detalleV = id_detalleV;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getSubtotal_iva() {
		return subtotal_iva;
	}
	public void setSubtotal_iva(double subtotal_iva) {
		this.subtotal_iva = subtotal_iva;
	}
	public VentaC getVentaC_fk() {
		return ventaC_fk;
	}
	public void setVentaC_fk(VentaC ventaC_fk) {
		this.ventaC_fk = ventaC_fk;
	}
	public Producto getProducto_fk() {
		return producto_fk;
	}
	public void setProducto_fk(Producto producto_fk) {
		this.producto_fk = producto_fk;
	}
	public DetalleV(int id_detalleV, int cantidad, double precio_venta, double subtotal, double subtotal_iva,
			VentaC ventaC_fk, Producto producto_fk) {
		super();
		this.id_detalleV = id_detalleV;
		this.cantidad = cantidad;
		this.precio_venta = precio_venta;
		this.subtotal = subtotal;
		this.subtotal_iva = subtotal_iva;
		this.ventaC_fk = ventaC_fk;
		this.producto_fk = producto_fk;
	}
	public DetalleV() {
		super();
	}
	
	

}
