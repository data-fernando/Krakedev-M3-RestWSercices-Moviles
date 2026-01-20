package com.krakedev.entidades;

import java.sql.Date;
import java.util.ArrayList;

public class PedidoC {
	
	
	private int id_pedido;
	private Date fecha;
	private Proveedor proveedor_pe;
	private EstadoPedido estado_pe;
	private ArrayList<DetalleP> detalles=new ArrayList<DetalleP>();
	
	
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Proveedor getProveedor_pe() {
		return proveedor_pe;
	}
	public void setProveedor_pe(Proveedor proveedor_pe) {
		this.proveedor_pe = proveedor_pe;
	}
	public EstadoPedido getEstado_pe() {
		return estado_pe;
	}
	public void setEstado_pe(EstadoPedido estado_pe) {
		this.estado_pe = estado_pe;
	}
	
	
	public ArrayList<DetalleP> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetalleP> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "PedidoC [id_pedido=" + id_pedido + ", fecha=" + fecha + ", proveedor_pe=" + proveedor_pe
				+ ", estado_pe=" + estado_pe + "]";
	}
	public PedidoC(int id_pedido, Date fecha, Proveedor proveedor_pe, EstadoPedido estado_pe) {
		super();
		this.id_pedido = id_pedido;
		this.fecha = fecha;
		this.proveedor_pe = proveedor_pe;
		this.estado_pe = estado_pe;
	}
	public PedidoC() {
		super();
	}
	
	
	
}
