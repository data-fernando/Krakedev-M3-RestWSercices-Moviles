package com.krakedev.entidades;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class VentaC {
	

	private int id_venta;
	private DatabaseMetaData fecha;
	private double total_sin_iva;
	private double iva;
	private double total;
	private ArrayList<DetalleV> detallesVenta=new ArrayList<DetalleV>();
	@Override
	public String toString() {
		return "VentaC [id_venta=" + id_venta + ", fecha=" + fecha + ", total_sin_iva=" + total_sin_iva + ", iva=" + iva
				+ ", total=" + total + ", detallesVenta=" + detallesVenta + "]";
	}
	public VentaC(int id_venta, DatabaseMetaData fecha, double total_sin_iva, double iva, double total,
			ArrayList<DetalleV> detallesVenta) {
		super();
		this.id_venta = id_venta;
		this.fecha = fecha;
		this.total_sin_iva = total_sin_iva;
		this.iva = iva;
		this.total = total;
		this.detallesVenta = detallesVenta;
	}
	public VentaC() {
		super();
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public DatabaseMetaData getFecha() {
		return fecha;
	}
	public void setFecha(DatabaseMetaData fecha) {
		this.fecha = fecha;
	}
	public double getTotal_sin_iva() {
		return total_sin_iva;
	}
	public void setTotal_sin_iva(double total_sin_iva) {
		this.total_sin_iva = total_sin_iva;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<DetalleV> getDetallesVenta() {
		return detallesVenta;
	}
	public void setDetallesVenta(ArrayList<DetalleV> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}

	
	
}
