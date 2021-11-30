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
    
    public int createOrUpdate(KhachHang khachHang) {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "INSERT INTO khach_hang(id_khach, ho, ten, nam_sinh, dia_chi, tong_tien)"
                    + " VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ho = VALUES(ho), ten = VALUES(ten), nam_sinh = VALUES(nam_sinh), "
                    + "dia_chi = VALUES(dia_chi), tong_tien = VALUES(tong_tien);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khachHang.getId_khach());
            ps.setString(2, khachHang.getHo());
            ps.setString(3, khachHang.getTen());
            ps.setInt(4, khachHang.getNam_sinh());
            ps.setString(5, khachHang.getDchi());
            ps.setLong(6, khachHang.getTong());
//            ps.setString(6, khachHang.getHang());
//            ps.setInt(7, khachHang.getTuoi());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }


}
