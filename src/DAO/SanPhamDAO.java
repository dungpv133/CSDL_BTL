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
import model.SanPham;
/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {
    public List<SanPham> getList() {
        Connection cons = (Connection) DBConnection.getConnection();
        String sql = "SELECT * FROM sieuthi.san_pham";
        List<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setId_sp(rs.getInt("id_sp"));
                sanPham.setTen(rs.getString("ten_sp"));
                sanPham.setDon_vi(rs.getString("don_vi"));
                sanPham.setDon_gia(rs.getInt("don_gia"));
                sanPham.setNganh(rs.getString("nganh"));
                list.add(sanPham);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int createOrUpdate(SanPham sanPham) {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "INSERT INTO sieuthi.san_pham(id_sp, ten_sp, don_vi, don_gia, nganh)"
                    + " VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ten_sp = VALUES(ten_sp), don_vi = VALUES(don_vi), "
                    + "don_gia = VALUES(don_gia), "
                    + "nganh = VALUES(nganh);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sanPham.getId_sp());
            ps.setString(2, sanPham.getTen());
            ps.setString(3, sanPham.getDon_vi());
            ps.setInt(4, sanPham.getDon_gia());
            ps.setString(5, sanPham.getNganh());

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
