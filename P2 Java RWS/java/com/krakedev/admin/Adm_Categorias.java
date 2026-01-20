package com.krakedev.admin;

import com.krakedev.entidades.Categoria;
import com.krakedev.utils.ConeccionBDD;
import com.krakedev.utils.KrakedevException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Adm_Categorias {

    // Crear una nueva categoría
    public void insertarCategoria(Categoria categoria) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConeccionBDD.obtenerConeccion();
            ps = con.prepareStatement(
                "INSERT INTO categorias (nombre_categ, cate_padre) VALUES (?, ?)"
            );

            ps.setString(1, categoria.getNombre_categoria());

            if (categoria.getCategoria_padre() != null) {
                ps.setInt(2, categoria.getCategoria_padre().getId_categoria());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();
            System.out.println("Categoría insertada correctamente: " + categoria.getNombre_categoria());
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }

    // Actualizar una categoría por ID
    public void actualizarCategoria(Categoria categoria) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConeccionBDD.obtenerConeccion();
            ps = con.prepareStatement(
                "UPDATE categorias SET nombre_categ = ?, cate_padre = ? WHERE id_categoria = ?"
            );

            ps.setString(1, categoria.getNombre_categoria());

            if (categoria.getCategoria_padre() != null) {
                ps.setInt(2, categoria.getCategoria_padre().getId_categoria());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }

            ps.setInt(3, categoria.getId_categoria());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Categoría actualizada correctamente: " + categoria.getNombre_categoria());
            } else {
                System.out.println("No se encontró la categoría con ID: " + categoria.getId_categoria());
            }
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }

    // Recuperar todas las categorias usando ArrayList
    public ArrayList<Categoria> obtenerTodasCategorias() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            con = ConeccionBDD.obtenerConeccion();
            ps = con.prepareStatement(
                "SELECT id_categoria, nombre_categ, cate_padre FROM categorias"
            );

            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre_categoria(rs.getString("nombre_categ"));

                int padreId = rs.getInt("cate_padre");
                if (!rs.wasNull()) {
                    Categoria padre = new Categoria();
                    padre.setId_categoria(padreId);
                    categoria.setCategoria_padre(padre);
                }

                categorias.add(categoria);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }

        return categorias;
    }

}
