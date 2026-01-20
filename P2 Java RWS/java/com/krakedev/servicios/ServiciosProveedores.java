package com.krakedev.servicios;

import com.krakedev.admin.ProveedoresAdmin;
import com.krakedev.entidades.Proveedor;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;




@Path("proveedores")
public class ServiciosProveedores {
	
	
	
	@Path("buscarcedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCedulaPK(@PathParam("cedulaParam") String cedula) {
	
		Proveedor proveedor_encontrado=null;
		ProveedoresAdmin adminproveedors=new ProveedoresAdmin();
		
		try {
			proveedor_encontrado=adminproveedors.recuperarPorCedula(cedula);
			 System.out.println(" >>>>> resultado de consulta por parametro: " + proveedor_encontrado);
			 return Response.ok(proveedor_encontrado).build();
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace(); // stacktrace completo en consola/log 
			System.err.println("Error"+ e.getClass().getName() + " - " + e.getMessage()); 
			return Response.serverError().build();
			
		}
	}
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) // añade esto para que devuelva JSON
	public Response crearProveedor(Proveedor proveedorApi) {
	
		ProveedoresAdmin adminproveedors=new ProveedoresAdmin();
		
		try {
			 adminproveedors.insertarProveedor(proveedorApi);
			 System.out.println(" >>>>> resultado de consulta por parametro: " + proveedorApi);
			 return Response.ok(proveedorApi).build();
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace(); // stacktrace completo en consola/log 
			System.err.println("Error"+ e.getClass().getName() + " - " + e.getMessage()); 
			return Response.serverError().build();
			
		}
	}
	
	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
	    return "proveedores OK";
	}

	
}
