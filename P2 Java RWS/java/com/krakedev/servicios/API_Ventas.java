package com.krakedev.servicios;


import com.krakedev.admin.Adm_VentaC;
import com.krakedev.entidades.VentaC;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("ventas")
public class API_Ventas {

	
	
	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
	    return " Ventas OK";
	}
	
	
	
	@POST
	@Path("insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertarVentaApi(VentaC venta) {

		Adm_VentaC venta_insersercion = new Adm_VentaC();

		try {
			venta_insersercion.insertarVenta(venta);
			System.out.println(">>> insercion venta exitosa" + venta);
			return Response.ok(venta).build();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error" + e.getClass().getName() + " - " + e.getMessage());
			return Response.serverError().build();

		}
	}

	
	
}
