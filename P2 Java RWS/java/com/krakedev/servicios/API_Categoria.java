package com.krakedev.servicios;

import java.util.ArrayList;

import com.krakedev.admin.Adm_Categorias;
import com.krakedev.entidades.Categoria;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categorias")
public class API_Categoria {
	


	@GET
	@Path("ping")
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
	    return " Categorias OK";
	}
	
	


	    // Recuperar todas las categorías
	    @GET
	    @Path("listar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response listarCategorias() {
	        Adm_Categorias adm = new Adm_Categorias();
	        try {
	            ArrayList<Categoria> categorias = adm.obtenerTodasCategorias();
	            return Response.ok(categorias).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Response.serverError().entity("Error al listar categorías").build();
	        }
	    }

	    // Crear una nueva categoría
	    @POST
	    @Path("crear")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response crearCategoria(Categoria categoria) {
	        Adm_Categorias adm = new Adm_Categorias();
	        try {
	            adm.insertarCategoria(categoria);
	            return Response.ok(categoria).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Response.serverError().entity("Error al crear categoría").build();
	        }
	    }

	    // Actualizar una categoría existente
	    @PUT
	    @Path("actualizar")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response actualizarCategoria(Categoria categoria) {
	        Adm_Categorias adm = new Adm_Categorias();
	        try {
	            adm.actualizarCategoria(categoria);
	            return Response.ok(categoria).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Response.serverError().entity("Error al actualizar categoría").build();
	        }
	    
	}

	
	
	
}
