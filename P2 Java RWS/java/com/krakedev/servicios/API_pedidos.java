package com.krakedev.servicios;

import java.util.ArrayList;

import com.krakedev.admin.Adm_PedidoC;
import com.krakedev.entidades.PedidoC;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("pedido")
public class API_pedidos {

	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return " Pedido OK";
	}

	@POST
	@Path("insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertarPedidoApi(PedidoC pedido) {

		Adm_PedidoC pedido_insersercion = new Adm_PedidoC();

		try {
			pedido_insersercion.insertarPedido(pedido);
			System.out.println(">>> insercion pedido exitosa" + pedido);
			return Response.ok(pedido).build();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error" + e.getClass().getName() + " - " + e.getMessage());
			return Response.serverError().build();

		}
	}

	@PUT
	@Path("actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarPedidoDetalleApi(PedidoC pedido) {

		Adm_PedidoC pedido_insersercion = new Adm_PedidoC();

		try {
			pedido_insersercion.actualizarPedidoDetalle(pedido);
			System.out.println(">>> ACTUALIZACION pedido exitosa" + pedido);
			return Response.ok(pedido).build();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error" + e.getClass().getName() + " - " + e.getMessage());
			return Response.serverError().build();

		}

	}
	
	@GET
	@Path("porProveedor/{idProveedor}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPedidosPorProveedor(@PathParam("idProveedor") String idProveedor) {
	    Adm_PedidoC adm = new Adm_PedidoC();
	    try {
	        ArrayList<PedidoC> pedidos = adm.buscarPedidosPorProveedor(idProveedor);
	        return Response.ok(pedidos).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.serverError().entity("Error al buscar pedidos por proveedor").build();
	    }
	}


}
