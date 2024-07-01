/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario validar (String user, String dni){
        Usuario us = new Usuario();
        String sql = "select * from usuarios where username=? and dni=?";
        
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setUser(rs.getString("username"));
                us.setDni(rs.getString("dni"));
                us.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return us;
    
    
    }
}
