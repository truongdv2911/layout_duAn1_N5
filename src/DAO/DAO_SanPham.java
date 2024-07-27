/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

public class DAO_SanPham {
    private static Connection conn;
    public List<SanPham> arrSP(){
        List<SanPham> arrSP = new ArrayList<>();
        try {
            conn = ConnectDB.ConnectDB.getConN();
            String sql = ("select idSanPham, TenSP, TenNhanHang, Size, color, SoLuong, Gia,TheLoai, sanPham.MoTa  from sanPham join sizeSP on sanPham.idSize = sizeSP.Id join colorSP on sanPham.idMau = colorSP.Id join NhanHang on sanPham.IdNhanHang = NhanHang.idNhanHang");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs  =ps.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setIdSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setNhanHang(rs.getString(3));
                sp.setSize(rs.getString(4));
                sp.setColor(rs.getString(5));
                sp.setSoLuong(rs.getInt(6));
                sp.setGia(rs.getFloat(7));
                sp.setTheLoai(rs.getString(8));
                sp.setMoTa(rs.getString(9));
                arrSP.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return arrSP;
    }
}
