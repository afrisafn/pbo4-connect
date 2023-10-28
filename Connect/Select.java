/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author fauziah
 */
public class Select {

    public static void main(String[] args) {
        String query = "select * from menu_makanan;";
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Makanan", "postgres", "");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                String kode_makanan= String.valueOf(rs.getObject(1));
                String nama_makanan= String.valueOf(rs.getObject(2));
                String harga = String.valueOf(rs.getObject(3));
                
                System.out.println("kode_makanan: " + kode_makanan);
                System.out.println("nama_makanan: " + nama_makanan);
                System.out.println("harga: " + harga);
                System.out.println("____________________");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}

