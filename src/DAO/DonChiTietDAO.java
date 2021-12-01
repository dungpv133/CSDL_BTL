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
import model.DonChiTiet;
/**
 *
 * @author ADMIN
 */
public class DonChiTietDAO {
    public List<DonChiTiet> getList() {
        Connection cons = (Connection) DBConnection.getConnection();
        String sql = "SELECT * FROM sieuthi.don_chi_tiet";
        List<DonChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonChiTiet donChiTiet = new DonChiTiet();
                donChiTiet.setId_don(rs.getInt("id_don"));
                donChiTiet.setId_sp(rs.getInt("id_sp"));
                donChiTiet.setSo_luong(rs.getInt("so_luong"));
                donChiTiet.setTong_tien(rs.getLong("tong_tien"));
                
                list.add(donChiTiet);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int createOrUpdate(DonChiTiet donChiTiet) {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "INSERT INTO don_chi_tiet(id_don, id_sp, so_luong, tong_tien)"
                    + " VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE id_don = VALUES(id_don), "
                    + "id_sp = VALUES(id_sp), so_luong = VALUES(so_luong), tong_tien = VALUES(tong_tien); ";
            String sqlUpdate =  "update sieuthi.don_chi_tiet " +
                                "set tong_tien = (select(don_gia) from sieuthi.san_pham " +
                                "where sieuthi.don_chi_tiet.id_sp = sieuthi.san_pham.id_sp) " +
                                "* so_luong; ";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, donChiTiet.getId_don());
            ps.setInt(2, donChiTiet.getId_sp());
            ps.setInt(3, donChiTiet.getSo_luong());
            ps.setLong(4, donChiTiet.getTong_tien());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps = cons.prepareStatement(sqlUpdate);
            ps.execute();
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public  int DeleteById(int id)
    {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "DELETE FROM TABLE sieuthi.khach_hang WHERE id_khach = ?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            ps.close();
            cons.close();
            return  rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}