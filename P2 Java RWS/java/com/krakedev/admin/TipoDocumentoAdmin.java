package com.krakedev.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.TipoDocumento;
import com.krakedev.utils.ConeccionBDD;

public class TipoDocumentoAdmin {
	
	private String columnaIdDocumento="id_documento";
	private String columnaDescripcionDocumento="descripcion_documento";

	
	public ArrayList<TipoDocumento> recuperarAll()throws Exception{
		
		Connection con = null; 
		ArrayList<TipoDocumento> documentos=new ArrayList<TipoDocumento>();
		
		try {
		    con = ConeccionBDD.obtenerConeccion();
		    PreparedStatement ps = con.prepareStatement("SELECT * FROM tipo_documento");
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		        TipoDocumento td = new TipoDocumento();
		        td.setId_documento(rs.getString(columnaIdDocumento));
		        td.setDescripcion_documento(rs.getString(columnaDescripcionDocumento));
		        documentos.add(td);
		    }
		    System.out.println(documentos.toString());
		} catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Error:"+e.getMessage());
		} finally {

		    if (con != null) try { con.close(); } catch (SQLException ignore) {}
		}
		return documentos;

	}
	
}
	


