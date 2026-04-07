package com.itm.proyectotransporte.dao;

import com.itm.proyectotransporte.model.Viaje;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ViajeDAO {

    private final String URL = "jdbc:mysql://localhost:3306/itm_ride";
    private final String USER = "root";
    private final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Viaje> listarTodos() {
        List<Viaje> viajes = new ArrayList<>();
        String sql = "SELECT * FROM viajes";
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Viaje v = new Viaje();
                v.setId(rs.getInt("id"));
                v.setOrigen(rs.getString("origen"));
                v.setDestino(rs.getString("destino"));
                v.setFecha(rs.getString("fecha"));
                v.setHora(rs.getString("hora"));
                v.setCupos(rs.getInt("cupos"));
                v.setConductorId(rs.getInt("conductor_id"));
                viajes.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viajes;
    }

    public Viaje buscarPorId(int id) {
        String sql = "SELECT * FROM viajes WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Viaje v = new Viaje();
                v.setId(rs.getInt("id"));
                v.setOrigen(rs.getString("origen"));
                v.setDestino(rs.getString("destino"));
                v.setFecha(rs.getString("fecha"));
                v.setHora(rs.getString("hora"));
                v.setCupos(rs.getInt("cupos"));
                v.setConductorId(rs.getInt("conductor_id"));
                return v;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertar(Viaje v) {
        String sql = "INSERT INTO viajes (origen, destino, fecha, hora, cupos, conductor_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getOrigen());
            ps.setString(2, v.getDestino());
            ps.setString(3, v.getFecha());
            ps.setString(4, v.getHora());
            ps.setInt(5, v.getCupos());
            ps.setInt(6, v.getConductorId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Viaje v) {
        String sql = "UPDATE viajes SET origen=?, destino=?, fecha=?, hora=?, cupos=?, conductor_id=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getOrigen());
            ps.setString(2, v.getDestino());
            ps.setString(3, v.getFecha());
            ps.setString(4, v.getHora());
            ps.setInt(5, v.getCupos());
            ps.setInt(6, v.getConductorId());
            ps.setInt(7, v.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM viajes WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}