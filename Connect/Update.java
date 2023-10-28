/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;
import static Connect.Insert.Insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 *
 * @author fauziah
 */
public class Update {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/Makanan";
    static final String PASS = "";
    static final String update = "UPDATE menu_makanan SET kode_makanan=?, nama_makanan=?, harga=? WHERE kode_makanan =?";
    static final String USER = "postgres";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            PreparedStatement preparedStatement = conn.prepareStatement(update);
            
            System.out.println("Masukkan kode yang Diubah :");
            int kodeMakananSebelumnya = input.nextInt();
            
            System.out.print("kode_makanan: ");
            int update_kode_makanan = input.nextInt();
            input.nextLine();
            System.out.print("nama_makanan: ");
            String update_nama_makanan = input.nextLine();

            System.out.print("harga: ");
            int update_harga = input.nextInt();

            preparedStatement.setInt(1, update_kode_makanan);
            preparedStatement.setString(2, update_nama_makanan);
            preparedStatement.setInt(3, update_harga);
            preparedStatement.setInt(4, kodeMakananSebelumnya);
            int result = preparedStatement.executeUpdate(); 
           if (result > 0) {
                System.out.println("Berhasil mengubah data");
            } else {
                System.out.println("gagal mengubah data");
            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
