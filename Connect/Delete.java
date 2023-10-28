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
public class Delete {
    public static void main(String[] args) {
        String delete = "DELETE FROM menu_makanan WHERE kode_makanan=?";
        try {
            //Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Makanan", "postgres","");
            PreparedStatement pstmt = conn.prepareStatement(delete);
            System.out.print("Masukkan kode yang akan dihapus: ");
            Scanner in = new Scanner(System.in);
            int hapus = in.nextInt();
            pstmt.setInt(1, hapus);
            int k = pstmt.executeUpdate();
            if (k > 0) {
                System.out.println("Hapus kode_makanan " + hapus + " BERHASIL ");
            } else {
                System.out.println("Hapus kode_makanan" + hapus + "GAGAL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
    
        }

    }
}
