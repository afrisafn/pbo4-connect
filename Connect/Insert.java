/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
/**
 *
 * @author fauziah
 */
public class Insert {
     static final String DB_URL = "jdbc:postgresql://localhost:5432/Makanan";
    static final String USER = "postgres";
    static final String PASS = "";
    static final String Insert = "INSERT INTO menu_makanan(kode_makanan, nama_makanan, harga) VALUES (?, ?, ?)";

    public static void main(String[] args) {
          Scanner input = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = conn.prepareStatement(Insert);
            
            System.out.print("kode_makanan: ");
            int insert_kode_makanan = input.nextInt();
            input.nextLine();
            System.out.print("nama_makanan: ");
            String insert_nama_makanan = input.nextLine();
            
            System.out.print("harga: ");
            int insert_harga = input.nextInt();
            
            preparedStatement.setInt(1, insert_kode_makanan);
            preparedStatement.setString(2, insert_nama_makanan );
            preparedStatement.setInt(3, insert_harga);
     
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Berhasil ditambahkan");
            } else {
                System.out.println("Gagal ditambahkan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}
