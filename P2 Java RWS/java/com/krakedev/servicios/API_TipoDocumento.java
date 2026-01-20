package com.krakedev.servicios;

import java.util.ArrayList;

import com.krakedev.admin.TipoDocumentoAdmin;
import com.krakedev.entidades.TipoDocumento;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;



@Path("tipo_documento")
public class API_TipoDocumento {

	
	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
	    return " Tipo Documentos OK";
	}
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response tomarTodos() {
	
		ArrayList<TipoDocumento> documentos=new ArrayList<TipoDocumento>();
		TipoDocumentoAdmin consultaTiposDocumentos=new TipoDocumentoAdmin();
		
		
		try {
			documentos=consultaTiposDocumentos.recuperarAll();
			 System.out.println(" >>>>> resultado de consulta tipos de documentos: " + documentos);
			 return Response.ok(documentos).build();
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace(); // stacktrace completo en consola/log 
			System.err.println("Error"+ e.getClass().getName() + " - " + e.getMessage()); 
			return Response.serverError().build();
			
		}
	}
	


	
}
