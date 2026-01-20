package com.krakedev.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.krakedev.entidades.DetalleV;
import com.krakedev.entidades.VentaC;
import com.krakedev.utils.ConeccionBDD;
import com.krakedev.utils.KrakedevException;

public class Adm_VentaC {

    public void insertarVenta(VentaC venta) throws Exception {
        Connection con = null;
        PreparedStatement psCabecera = null;
        PreparedStatement psDetalle = null;
        PreparedStatement psMovimiento = null;
        ResultSet rs = null;

        try {
            con = ConeccionBDD.obtenerConeccion();

            // 1️ Insertar cabecera de venta con totales iniciales en 0
            psCabecera = con.prepareStatement(
                "INSERT INTO cabecera_venta (fecha, total_sin_iva, iva, total) VALUES (CURRENT_DATE, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            psCabecera.setDouble(1, 0);
            psCabecera.setDouble(2, 0);
            psCabecera.setDouble(3, 0);
            psCabecera.executeUpdate();

            rs = psCabecera.getGeneratedKeys();
            int idGenerado = -1;
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
            venta.setId_venta(idGenerado);

            double acumuladoSinIva = 0;
            double acumuladoIva = 0;
            double acumuladoTotal = 0;

            // 2️⃣ Insertar detalles de la venta
            ArrayList<DetalleV> detalles = venta.getDetallesVenta();
            if (detalles != null) {
                for (DetalleV detalle : detalles) {
                    double subtotal = detalle.getCantidad() * detalle.getProducto_fk().getPrecio_venta();
                    double subtotalIva = 0;

                    if (detalle.getProducto_fk().isTieneIVA()) {
                        subtotalIva = subtotal * 0.15; // IVA 15%
                    }

                    double subtotalConIva = subtotal + subtotalIva;

                    detalle.setSubtotal(subtotal);
                    detalle.setSubtotal_iva(subtotalIva);

                    acumuladoSinIva += subtotal;
                    acumuladoIva += subtotalIva;
                    acumuladoTotal += subtotalConIva;

                    psDetalle = con.prepareStatement(
                        "INSERT INTO detalle_venta (cantidad, precio_venta, subtotal, subtotal_iva, cabecera_fk, producto_fk) VALUES (?, ?, ?, ?, ?, ?)"
                    );
                    psDetalle.setInt(1, detalle.getCantidad());
                    psDetalle.setDouble(2, detalle.getProducto_fk().getPrecio_venta());
                    psDetalle.setDouble(3, subtotal);
                    psDetalle.setDouble(4, subtotalIva);
                    psDetalle.setInt(5, idGenerado);
                    psDetalle.setInt(6, detalle.getProducto_fk().getProducto_pk());
                    psDetalle.executeUpdate();
                    psDetalle.close();

                    // 3️ Insertar movimiento en stock (salida)
                    psMovimiento = con.prepareStatement(
                        "INSERT INTO movimiento_stock (referencia_venta_fk, producto_fk, cantidad) VALUES (?, ?, ?)"
                    );
                    psMovimiento.setInt(1, idGenerado);
                    psMovimiento.setInt(2, detalle.getProducto_fk().getProducto_pk());
                    psMovimiento.setInt(3, -detalle.getCantidad()); // salida de stock
                    psMovimiento.executeUpdate();
                    psMovimiento.close();
                }
            }

            // 4️ Actualizar totales en cabecera
            PreparedStatement psUpdateCab = con.prepareStatement(
                "UPDATE cabecera_venta SET total_sin_iva = ?, iva = ?, total = ? WHERE id_venta_cabe = ?"
            );
            psUpdateCab.setDouble(1, acumuladoSinIva);
            psUpdateCab.setDouble(2, acumuladoIva);
            psUpdateCab.setDouble(3, acumuladoTotal);
            psUpdateCab.setInt(4, idGenerado);
            psUpdateCab.executeUpdate();
            psUpdateCab.close();

            System.out.println("Venta registrada correctamente con ID: " + idGenerado);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrakedevException("Error al insertar venta: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (psCabecera != null) psCabecera.close();
            if (psDetalle != null) psDetalle.close();
            if (psMovimiento != null) psMovimiento.close();
            if (con != null) con.close();
            System.out.println("Conexión cerrada");
        }
    }
}
