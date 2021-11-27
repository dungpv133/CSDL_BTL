/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;
/**
 *
 * @author ADMIN
 */
public class KhachHangDAO {
    public List<KhachHang> getList() {
        Connection cons = (Connection) DBConnection.getConnection();
        String sql = "SELECT * FROM sieuthi.khach_hang";
        List<KhachHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId_khach(rs.getInt("id_khach"));
                khachHang.setHo(rs.getString("ho"));
                khachHang.setTen(rs.getString("ten"));
                khachHang.setDchi(rs.getString("dia_chi"));
                khachHang.setNam_sinh(rs.getInt("nam_sinh"));
                khachHang.setTong(rs.getLong("tong_tien"));
                khachHang.setTuoi(rs.getInt("tuoi"));
                khachHang.setHang(rs.getString("hang"));
                list.add(khachHang);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
