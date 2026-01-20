package com.krakedev.admin;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import com.krakedev.entidades.DetalleP;
import com.krakedev.entidades.EstadoPedido;
import com.krakedev.entidades.PedidoC;
import com.krakedev.entidades.Proveedor;
import com.krakedev.utils.ConeccionBDD;
import com.krakedev.utils.KrakedevException;

public class Adm_PedidoC {

	public void insertarPedido(PedidoC pedido) throws Exception {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    PreparedStatement detalleStatement=null;
	    java.sql.Date fechaSQL=new java.sql.Date(System.currentTimeMillis());

	    try {
	        con = ConeccionBDD.obtenerConeccion();
	        ps = con.prepareStatement(
	            "INSERT INTO cabecera_pedido (fecha, proveedor_fk, estado_fk) VALUES (?, ?, ?)",
	            Statement.RETURN_GENERATED_KEYS
	        );

	        // Fecha: si el objeto PedidoC trae fecha, úsala; si no, usa la fecha actual del sistema
	        
	        
	        if (pedido.getFecha() != null) {
	            fechaSQL = new java.sql.Date(pedido.getFecha().getTime());
	        }
	        
	        ps.setDate(1, fechaSQL);

	        // proveedor_fk: FK hacia proveedores(id_documento)
	        ps.setString(2, pedido.getProveedor_pe().getId_proveedor());

	        // estado_fk: FK hacia estado_pedido(id_estado)
	        ps.setString(3, pedido.getEstado_pe().getId_estado());

	        ps.executeUpdate();

	        // Recuperar el id autogenerado
	        rs = ps.getGeneratedKeys();
	        int idGenerado = -1;
	        if (rs.next()) {
	            idGenerado = rs.getInt(1);
	        }

	        // Asignar valores al objeto PedidoC
	        pedido.setId_pedido(idGenerado);
	        pedido.setFecha(fechaSQL);

	        System.out.println("Pedido insertado correctamente con ID: "+ idGenerado + " y fecha: " + fechaSQL);
	        
	        
	        ArrayList<DetalleP> detalles = pedido.getDetalles(); 
	        if (detalles != null) { 
	        	for (DetalleP detalleAux : detalles) { 
	        		detalleStatement = con.prepareStatement( "INSERT INTO detalle_pedido " + 
	        	"(cantidad_solicitada, cantidad_recibida, subtotal, producto_fk, pedido_fk) " + 
	        				"VALUES (?, ?, ?, ?, ?)" ); 
	        		detalleStatement.setInt(1, detalleAux.getCantidad_solicitadaP()); // cantidad solicitada 
	        		detalleStatement.setInt(2, 0); // cantidad recibida por defecto 
	        		double subtotal = detalleAux.getCantidad_recibidaP() * detalleAux.getProductoFk().getCosto_producto(); 
	        		detalleStatement.setDouble(3, subtotal); detalleStatement.setInt(4, detalleAux.getProductoFk().getProducto_pk());// id producto 
	        		detalleStatement.setInt(5, idGenerado); // id cabecera 
	        		
	        		detalleStatement.executeUpdate(); 
	        		detalleStatement.close();
	        	} 
	        }

	    } catch(KrakedevException e) {
	    	e.printStackTrace();
	    	throw e;
	    }catch (SQLException e2) {
			// TODO: handle exception
	    	e2.printStackTrace();
	    	
	    }finally {
	        if (rs != null) rs.close();
	        if (ps != null) ps.close();
	        if (detalleStatement != null) detalleStatement.close();
	        if (con != null) con.close();
	        System.out.println("Conecion cerrada");
	    }
	}

	

	public void actualizarPedidoDetalle(PedidoC pedido) throws Exception {
	    Connection con = null;
	    PreparedStatement psCabecera = null;
	    PreparedStatement psDetalle = null;
	    PreparedStatement psMovimiento = null;

	    try {
	        con = ConeccionBDD.obtenerConeccion();

	        // 1️ Actualizar estado del pedido en cabecera
	        psCabecera = con.prepareStatement(
	            "UPDATE cabecera_pedido SET estado_fk = ? WHERE id_cabecera_pe = ?"
	        );
	        psCabecera.setString(1, pedido.getEstado_pe().getId_estado());
	        psCabecera.setInt(2, pedido.getId_pedido());
	        int filasCab = psCabecera.executeUpdate();

	        if (filasCab == 0) {
	            throw new KrakedevException("No se encontró pedido con ID: " + pedido.getId_pedido());
	        }

	        // 2️ Actualizar cada detalle del pedido
	        if (pedido.getDetalles() != null) {
	            for (DetalleP detalle : pedido.getDetalles()) {
	                // Actualizar detalle
	                psDetalle = con.prepareStatement(
	                    "UPDATE detalle_pedido SET cantidad_recibida = ?, subtotal = ? WHERE id_detalle = ?"
	                );

	                psDetalle.setInt(1, detalle.getCantidad_recibidaP());

	                double nuevoSubtotal = detalle.getCantidad_recibidaP()
	                        * detalle.getProductoFk().getCosto_producto();
	                psDetalle.setDouble(2, nuevoSubtotal);

	                psDetalle.setInt(3, detalle.getId_detalleP());

	                psDetalle.executeUpdate();
	                psDetalle.close();

	                // 3 Insertar movimiento en stock
	                psMovimiento = con.prepareStatement(
	                    "INSERT INTO movimiento_stock (referencia_pedido_fk, producto_fk, cantidad) VALUES (?, ?, ?)"
	                );
	                psMovimiento.setInt(1, pedido.getId_pedido()); // referencia al pedido
	                psMovimiento.setInt(2, detalle.getProductoFk().getProducto_pk()); // producto
	                psMovimiento.setInt(3, detalle.getCantidad_recibidaP()); // cantidad recibida
	                psMovimiento.executeUpdate();
	                psMovimiento.close();
	            }
	        }

	        System.out.println("Pedido y movimientos de stock actualizados correctamente con ID: " + pedido.getId_pedido());

	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new KrakedevException("Error al actualizar pedido: " + e.getMessage());
	    } finally {
	        if (psCabecera != null) psCabecera.close();
	        if (psDetalle != null) psDetalle.close();
	        if (psMovimiento != null) psMovimiento.close();
	        if (con != null) con.close();
	        System.out.println("Conexión cerrada");
	    }
	}
	
	public ArrayList<PedidoC> buscarPedidosPorProveedor(String idProveedor) throws Exception {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<PedidoC> pedidos = new ArrayList<>();

	    try {
	        con = ConeccionBDD.obtenerConeccion();
	        ps = con.prepareStatement(
	            "SELECT id_cabecera_pe, fecha, proveedor_fk, estado_fk " +
	            "FROM cabecera_pedido " +
	            "WHERE proveedor_fk = ?"
	        );
	        ps.setString(1, idProveedor);

	        rs = ps.executeQuery();
	        while (rs.next()) {
	            PedidoC pedido = new PedidoC();
	            pedido.setId_pedido(rs.getInt("id_cabecera_pe"));
	            pedido.setFecha(rs.getDate("fecha"));

	            // Proveedor solo con id (lo indispensable)
	            Proveedor proveedor = new Proveedor();
	            proveedor.setId_proveedor(rs.getString("proveedor_fk"));
	            pedido.setProveedor_pe(proveedor);

	            // Estado del pedido (solo id)
	            EstadoPedido estado = new EstadoPedido();
	            estado.setId_estado(rs.getString("estado_fk"));
	            pedido.setEstado_pe(estado);

	            pedidos.add(pedido);
	        }
	    } finally {
	        if (rs != null) rs.close();
	        if (ps != null) ps.close();
	        if (con != null) con.close();
	    }

	    return pedidos;
	}



	
}
