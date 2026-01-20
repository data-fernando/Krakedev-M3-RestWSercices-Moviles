package com.krakedev.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.krakedev.entidades.Proveedor;
import com.krakedev.entidades.TipoDocumento;
import com.krakedev.utils.ConeccionBDD;
import com.krakedev.utils.KrakedevException;

public class ProveedoresAdmin {
	
	private String columnaIdDocumento="id_documento";
//	private String columnaTipoDocumento="tipo_documento_fk"; //no se usa por la composicion
	private String columnaNombreProveedor="nombre_prov";
	private String columnaTelefonoProveedor="telefono";
	private String columnaCorreoProveedor="correo";
	private String columnaDireccionProveedor="direccion";
	
	///composicion
	///
	private String columnaTipoDocumentoComposicion="id_documento";
	private String columnaDescripcionDocComposicion="descripcion_documento";


	//buscar un proveedor
	public Proveedor recuperarPorCedula(String cedula) throws KrakedevException, SQLException {
		Connection con = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		Proveedor proveedorEncontrado = null;

	    try {
	        con = ConeccionBDD.obtenerConeccion();
	        System.out.println("\nconectado para buscar por cédula\n");

	        ps = con.prepareStatement(
	            "SELECT * FROM proveedores prov, tipo_documento ti_doc "
	            + " WHERE prov.tipo_documento_fk = ti_doc.id_documento "
	            + " AND prov.id_documento = ?;"
	        );
	        
	        ps.setString(1, cedula);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            proveedorEncontrado = new Proveedor();
	            
	            //de la composicion
	            TipoDocumento tipoDoc=new TipoDocumento(rs.getString(columnaTipoDocumentoComposicion),rs.getString(columnaDescripcionDocComposicion));
	            
	            proveedorEncontrado.setId_proveedor(rs.getString(columnaIdDocumento));
	            proveedorEncontrado.setTipo_documento(tipoDoc);//de la composicion
	            proveedorEncontrado.setNombre_proveedor(rs.getString(columnaNombreProveedor));
	            proveedorEncontrado.setTelefono(rs.getString(columnaTelefonoProveedor));
	            proveedorEncontrado.setCorreo(rs.getString(columnaCorreoProveedor));
	            proveedorEncontrado.setDireccion(rs.getString(columnaDireccionProveedor));
	            
	        }

	        if (proveedorEncontrado != null) {
	            System.out.println("Proveedor encontrado: " + proveedorEncontrado);
	        } else {
	            System.out.println("No existe proveedor con cédula: " + cedula);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	        throw new KrakedevException("Error al recuperar proveedor por cédula: "+e.getMessage());
	    } finally {
	    	try { 
	    		if (rs != null) rs.close();
	    		if (ps != null) ps.close();
	    		if (con != null) con.close(); 
	    	} catch (SQLException e) { 
	    		e.printStackTrace(); 
	    	}
	    }

	    return proveedorEncontrado;
	}
	
	
	
	public void insertarProveedor(Proveedor proveedor) throws KrakedevException, SQLException {
		Connection con = null; 
		PreparedStatement ps = null; 
		
	    try {
	    	con = ConeccionBDD.obtenerConeccion(); 
	    	System.out.println("\nConectado para insertar proveedor\n"); 
	    	ps = con.prepareStatement( "INSERT INTO proveedores (id_documento, tipo_documento_fk, nombre_prov, telefono, correo, direccion) " + 
	    	"VALUES (?, ?, ?, ?, ?, ?)" );
	        
	        ps.setString(1, proveedor.getId_proveedor());
	        ps.setString(2, proveedor.getTipo_documento().getId_documento());
	        ps.setString(3, proveedor.getNombre_proveedor());
	        ps.setString(4, proveedor.getTelefono());
	        ps.setString(5, proveedor.getCorreo());
	        ps.setString(6, proveedor.getDireccion());

	        ps.executeUpdate();
	        
	        System.out.println("Proveedor insertado correctamente"+ proveedor.toString());

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        throw new KrakedevException("Error al recuperar proveedor por cédula: "+e.getMessage());
	    } finally {
	    	try { 

	    		if (ps != null) ps.close();
	    		if (con != null) con.close(); 
	    	} catch (SQLException e) { 
	    		e.printStackTrace(); 
	    	}
	    }

	}
	
}
