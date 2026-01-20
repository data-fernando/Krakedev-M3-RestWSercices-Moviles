package com.krakedev.servicios;

import java.util.ArrayList;

import com.krakedev.admin.Adm_Productos;
import com.krakedev.entidades.Producto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("productos")
public class API_Productos {
	
	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
	    return " productos OK";
	}
	
	
	@GET 
	@Path("buscar/{nombreParam}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNombreApi(@PathParam("nombreParam") String nombre) {

		ArrayList<Producto> productosEncontrados = new ArrayList<>();
		Adm_Productos adminProductos = new Adm_Productos();

		try {
			productosEncontrados = adminProductos.buscarPorNombre(nombre);
			System.out.println(" >>>>> resultado de consulta productos: " + productosEncontrados);
			return Response.ok(productosEncontrados).build();
		} catch (Exception e) {
			e.printStackTrace(); // stacktrace completo en consola/log
			System.err.println("Error " + e.getClass().getName() + " - " + e.getMessage());
			return Response.serverError().build();
		}
	}
	
	
	
	@POST 
	@Path("insertar") 
	@Consumes(MediaType.APPLICATION_JSON)
	
	//siempre agregar el produces ,ya que inserta sin  dar el OK si no se coloca
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertarProductoApi( Producto productoApi) {

		Adm_Productos adminProductos = new Adm_Productos();

		try {
			adminProductos.insertarProducto(productoApi);
			System.out.println(" >>>>> resultado de consulta productos: " + productoApi);
			return Response.ok(productoApi).build();
		} catch (Exception e) {
			e.printStackTrace(); // stacktrace completo en consola/log
			System.err.println("Error " + e.getClass().getName() + " - " + e.getMessage());
			return Response.serverError().build();
		}
	}
	
	@PUT
	@Path("actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarProdutoAPI(Producto producto) {
		
		Adm_Productos actualizarPr=new Adm_Productos();
		
		try {
			actualizarPr.actualizarProductoPorId(producto);
			System.out.println("producto con id "+producto.getProducto_pk()+" y nombre: "+producto.getNombre()+" >> Actualizado");
			return Response.ok(producto).build();
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			System.err.println("Error "+e.getClass()+" - "+e.getMessage());
			return Response.serverError().build();
			
		}
		
		
		
		
	}
	
	@GET
	@Path("buscarPorId/{idProducto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorIdApi(@PathParam("idProducto") int idProducto) {
	    Adm_Productos adminProductos = new Adm_Productos();

	    try {
	        Producto producto = adminProductos.buscarPorId(idProducto);
	        if (producto != null) {
	            return Response.ok(producto).build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND)
	                           .entity("No se encontró producto con ID: " + idProducto)
	                           .build();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.serverError().entity("Error al buscar producto por ID").build();
	    }
	}

	
	
	
	
}


	

