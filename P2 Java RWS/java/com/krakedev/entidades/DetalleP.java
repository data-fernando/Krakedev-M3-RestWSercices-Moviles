package com.krakedev.entidades;

public class DetalleP {
	private int id_detalleP;
	private int cantidad_solicitadaP;
	private int cantidad_recibidaP;
	private double subtotal;
	private Producto productoFk;
	private PedidoC pedidoFk;
	@Override
	public String toString() {
		return "DetalleP [id_detalleP=" + id_detalleP + ", cantidad_solicitadaP=" + cantidad_solicitadaP
				+ ", cantidad_recibidaP=" + cantidad_recibidaP + ", subtotal=" + subtotal + ", productoFk=" + productoFk
				+ ", pedidoFk=" + pedidoFk + "]";
	}
	public DetalleP(int id_detalleP, int cantidad_solicitadaP, int cantidad_recibidaP, double subtotal,
			Producto productoFk, PedidoC pedidoFk) {
		super();
		this.id_detalleP = id_detalleP;
		this.cantidad_solicitadaP = cantidad_solicitadaP;
		this.cantidad_recibidaP = cantidad_recibidaP;
		this.subtotal = subtotal;
		this.productoFk = productoFk;
		this.pedidoFk = pedidoFk;
	}
	public DetalleP() {
		super();
	}
	public int getId_detalleP() {
		return id_detalleP;
	}
	public void setId_detalleP(int id_detalleP) {
		this.id_detalleP = id_detalleP;
	}
	public int getCantidad_solicitadaP() {
		return cantidad_solicitadaP;
	}
	public void setCantidad_solicitadaP(int cantidad_solicitadaP) {
		this.cantidad_solicitadaP = cantidad_solicitadaP;
	}
	public int getCantidad_recibidaP() {
		return cantidad_recibidaP;
	}
	public void setCantidad_recibidaP(int cantidad_recibidaP) {
		this.cantidad_recibidaP = cantidad_recibidaP;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Producto getProductoFk() {
		return productoFk;
	}
	public void setProductoFk(Producto productoFk) {
		this.productoFk = productoFk;
	}
	public PedidoC getPedidoFk() {
		return pedidoFk;
	}
	public void setPedidoFk(PedidoC pedidoFk) {
		this.pedidoFk = pedidoFk;
	}
	
	
	
	
}
