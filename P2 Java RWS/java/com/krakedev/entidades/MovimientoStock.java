package com.krakedev.entidades;

import java.sql.DatabaseMetaData;

public class MovimientoStock {
	private int movimiento;
	private DatabaseMetaData fecha_hora;
	private PedidoC pedidoC_fk;
	private DetalleP pedidoD_fk;
	private Producto producto_fk;
	private int cantidad;
	public int getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	public DatabaseMetaData getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(DatabaseMetaData fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public PedidoC getPedidoC_fk() {
		return pedidoC_fk;
	}
	public void setPedidoC_fk(PedidoC pedidoC_fk) {
		this.pedidoC_fk = pedidoC_fk;
	}
	public DetalleP getPedidoD_fk() {
		return pedidoD_fk;
	}
	public void setPedidoD_fk(DetalleP pedidoD_fk) {
		this.pedidoD_fk = pedidoD_fk;
	}
	public Producto getProducto_fk() {
		return producto_fk;
	}
	public void setProducto_fk(Producto producto_fk) {
		this.producto_fk = producto_fk;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "MovimientoStock [movimiento=" + movimiento + ", fecha_hora=" + fecha_hora + ", pedidoC_fk=" + pedidoC_fk
				+ ", pedidoD_fk=" + pedidoD_fk + ", producto_fk=" + producto_fk + ", cantidad=" + cantidad + "]";
	}
	public MovimientoStock(int movimiento, DatabaseMetaData fecha_hora, PedidoC pedidoC_fk, DetalleP pedidoD_fk,
			Producto producto_fk, int cantidad) {
		super();
		this.movimiento = movimiento;
		this.fecha_hora = fecha_hora;
		this.pedidoC_fk = pedidoC_fk;
		this.pedidoD_fk = pedidoD_fk;
		this.producto_fk = producto_fk;
		this.cantidad = cantidad;
	}
	public MovimientoStock() {
		super();
	}
	
	
	
	

}
