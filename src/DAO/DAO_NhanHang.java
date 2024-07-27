/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanHang;
public class DAO_NhanHang {
    private static Connection conn;
    public List<NhanHang> ListNhanHang(){
        List<NhanHang> arrNH = new ArrayList<>();
        try {
            String sql = ("select * from nhanHang");
            conn = ConnectDB.ConnectDB.getConN();
            PreparedStatement ps  = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanHang nH = new NhanHang();
                nH.setIdNhanHang(rs.getInt(1));
                nH.setTenNhanHang(rs.getString(2).trim());
                nH.setMoTa(rs.getString(3));
                arrNH.add(nH);
            }
        } catch (SQLException e) {
            System.out.println("Loi"+e);
        }
        return arrNH;
    }
    public ArrayList<Integer> idNH(){
        ArrayList<Integer> idNH = new ArrayList<>();
        for (NhanHang ListNhanHang : ListNhanHang()) {
            int id = ListNhanHang.getIdNhanHang();
            idNH.add(id);
        }
        System.out.println(idNH);
        return idNH;
    }
}
