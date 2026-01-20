package com.krakedev.admin;
import com.krakedev.entidades.Categoria;
import com.krakedev.entidades.Producto;
import com.krakedev.entidades.UnidadMedia;
import com.krakedev.utils.ConeccionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Adm_Productos {
	
	public ArrayList<Producto> buscarPorNombre(String nombre) throws Exception {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<Producto> productos = new ArrayList<>();

	    try {
	        con = ConeccionBDD.obtenerConeccion();
	        ps = con.prepareStatement( "SELECT pr.codigo_producto,pr.nombre_pr,pr.precio_venta_pr,pr.coste_pr,pr.tiene_iva,pr.stock,pr.udm_fk,ca.nombre_categ " +
	        "FROM productos pr,categorias ca  " +
	        "WHERE pr.nombre_pr ILIKE ? and pr.categoria_fk=ca.id_categoria" );
	        
	        	//ilike no distingue entre mayusculas y minusculas
	        
	        	ps.setString(1, "%" + nombre + "%");


	        rs = ps.executeQuery();
	        while (rs.next()) {

	        	Producto producto = new Producto();
	        	producto.setProducto_pk(rs.getInt("codigo_producto"));
	        	producto.setNombre(rs.getString("nombre_pr"));
	        	producto.setPrecio_venta(rs.getDouble("precio_venta_pr"));
	        	producto.setCosto_producto(rs.getDouble("coste_pr"));
	        	producto.setTieneIVA(rs.getBoolean("tiene_iva"));
	        	producto.setStock(rs.getInt("stock"));

	        	// aquí solo guardas las FK, no las entidades completas
	        	UnidadMedia unidad = new UnidadMedia();
	        	unidad.setSimbolo_pk(rs.getString("udm_fk"));
	        	producto.setUnidad_medidaPr(unidad);

	        	Categoria categoria = new Categoria();
	        	categoria.setNombre_categoria(rs.getString("nombre_categ"));
	        	producto.setCategoria_pr(categoria);


	            productos.add(producto);
	        }
	    } finally {
	        if (rs != null) rs.close();
	        if (ps != null) ps.close();
	        if (con != null) con.close();
	    }

	    return productos;
	}

	public void insertarProducto(Producto producto) throws Exception {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        con = ConeccionBDD.obtenerConeccion();
	        ps = con.prepareStatement(
	            "INSERT INTO productos (nombre_pr, precio_venta_pr, coste_pr, tiene_iva, stock, udm_fk, categoria_fk) " +
	            "VALUES (?, ?, ?, ?, ?, ?, ?)"
	        );

	        ps.setString(1, producto.getNombre());
	        ps.setDouble(2, producto.getPrecio_venta());
	        ps.setDouble(3, producto.getCosto_producto());
	        ps.setBoolean(4, producto.isTieneIVA());
	        ps.setInt(5, producto.getStock());
	        ps.setString(6, producto.getUnidad_medidaPr().getSimbolo_pk());
	        ps.setInt(7, producto.getCategoria_pr().getId_categoria());

	        ps.executeUpdate();
	        System.out.println("Producto insertado correctamente: " + producto.getNombre());
	    } finally {
	        if (ps != null) ps.close();
	        if (con != null) con.close();
	    }
	}

	
	public void actualizarProductoPorId(Producto producto) throws Exception {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        con = ConeccionBDD.obtenerConeccion();
	        ps = con.prepareStatement(
	            "UPDATE productos " +
	            "SET nombre_pr = ?, precio_venta_pr = ?, coste_pr = ?, tiene_iva = ?, stock = ?, udm_fk = ?, categoria_fk = ? " +
	            "WHERE codigo_producto = ?"
	        );

	        ps.setString(1, producto.getNombre());
	        ps.setDouble(2, producto.getPrecio_venta());
	        ps.setDouble(3, producto.getCosto_producto());
	        ps.setBoolean(4, producto.isTieneIVA());
	        ps.setInt(5, producto.getStock());
	        ps.setString(6, producto.getUnidad_medidaPr().getSimbolo_pk());
	        ps.setInt(7, producto.getCategoria_pr().getId_categoria());
	        ps.setInt(8, producto.getProducto_pk()); // ID del producto a actualizar

	        int filasAfectadas = ps.executeUpdate();
	        if (filasAfectadas > 0) {
	            System.out.println("Producto actualizado correctamente: " + producto.getNombre());
	        } else {
	            System.out.println("No se encontró el producto con ID: " + producto.getProducto_pk());
	        }
	    } finally {
	        if (ps != null) ps.close();
	        if (con != null) con.close();
	    }
	}
	
	public Producto buscarPorId(int idProducto) throws Exception {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Producto producto = null;

	    try {
	        con = ConeccionBDD.obtenerConeccion();
	        ps = con.prepareStatement(
	            "SELECT pr.codigo_producto, pr.nombre_pr, pr.precio_venta_pr, pr.coste_pr, pr.tiene_iva, pr.stock, pr.udm_fk, ca.nombre_categ " +
	            "FROM productos pr, categorias ca " +
	            "WHERE pr.codigo_producto = ? AND pr.categoria_fk = ca.id_categoria"
	        );

	        ps.setInt(1, idProducto);

	        rs = ps.executeQuery();
	        if (rs.next()) {
	            producto = new Producto();
	            producto.setProducto_pk(rs.getInt("codigo_producto"));
	            producto.setNombre(rs.getString("nombre_pr"));
	            producto.setPrecio_venta(rs.getDouble("precio_venta_pr"));
	            producto.setCosto_producto(rs.getDouble("coste_pr"));
	            producto.setTieneIVA(rs.getBoolean("tiene_iva"));
	            producto.setStock(rs.getInt("stock"));

	            UnidadMedia unidad = new UnidadMedia();
	            unidad.setSimbolo_pk(rs.getString("udm_fk"));
	            producto.setUnidad_medidaPr(unidad);

	            Categoria categoria = new Categoria();
	            categoria.setNombre_categoria(rs.getString("nombre_categ"));
	            producto.setCategoria_pr(categoria);
	        }
	    } finally {
	        if (rs != null) rs.close();
	        if (ps != null) ps.close();
	        if (con != null) con.close();
	    }

	    return producto;
	}



}
