package com.krakedev.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class ConeccionBDD {
	
	public static Connection obtenerConeccion() throws KrakedevException  {
		
		Context ctx=null;
		DataSource ds=null;
		Connection con=null;
			try {
				ctx = new InitialContext();
				//asi me daba error interno por la / en :java:/comp/env
				
				ds = (DataSource) ctx.lookup("java:comp/env/rws/inventarios");
				con = ds.getConnection();

			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new KrakedevException("error en la coneccion o su definicion"); 
			}
			//nunca cerrar la conexion
			
			return con;	
			
	}

}
