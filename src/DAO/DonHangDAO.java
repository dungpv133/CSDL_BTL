/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DonHang;
import model.KhachHang;
/**
 *
 * @author ADMIN
 */
public class DonHangDAO {
    public List<DonHang> getList() {
        Connection cons = (Connection) DBConnection.getConnection();
        String sql = "SELECT * FROM sieuthi.don_hang";
        String sqlUpdate1 = "update sieuthi.don_hang " +
            "set so_sp = (select count(id_don) from sieuthi.don_chi_tiet " +
            "where sieuthi.don_hang.id_don = sieuthi.don_chi_tiet.id_don); ";
            String sqlUpdate2 = "update sieuthi.don_hang, sieuthi.don_chi_tiet " +
            "set sieuthi.don_hang.tien = (select sum(sieuthi.don_chi_tiet.tong_tien) from sieuthi.don_chi_tiet " +
            "where sieuthi.don_hang.id_don = sieuthi.don_chi_tiet.id_don); ";
            String sqlUpdate3 = "update sieuthi.don_hang " +
            "set giam = (select (case when (select hang from sieuthi.khach_hang  " +
            "where don_hang.id_khach = khach_hang.id_khach) = 'VANG' then 20 " +
            "when (select hang from sieuthi.khach_hang " +
            "where don_hang.id_khach = khach_hang.id_khach) = 'BAC' then 10 " +
            "when (select hang from sieuthi.khach_hang  " +
            "where don_hang.id_khach = khach_hang.id_khach) = 'KHONG CO HANG' then 0 END) ); ";
        List<DonHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonHang donHang = new DonHang();
                donHang.setId_don(rs.getInt("id_don"));
                donHang.setId_khach(rs.getInt("id_khach"));
                donHang.setNgay(rs.getString("ngay_mua"));
                donHang.setSo_sp(rs.getInt("so_sp"));
                donHang.setTien(rs.getInt("tien"));
                donHang.setGiam(rs.getLong("giam"));
                donHang.setTong(rs.getLong("tong_tien"));
                list.add(donHang);
            }
            ps = cons.prepareStatement(sqlUpdate1);
            ps.execute();
            ps = cons.prepareStatement(sqlUpdate2);
            ps.execute(); ps = cons.prepareStatement(sqlUpdate3);
            ps.execute();
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int createOrUpdate(DonHang donHang) {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "INSERT INTO don_hang(id_don, id_khach, ngay_mua, so_sp, tien, giam)"
                    + " VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE "
                    + "id_khach = VALUES(id_khach), "
                    + "ngay_mua = VALUES(ngay_mua); ";
            String sqlUpdate1 = "update sieuthi.don_hang " +
            "set so_sp = (select count(id_don) from sieuthi.don_chi_tiet " +
            "where sieuthi.don_hang.id_don = sieuthi.don_chi_tiet.id_don); ";
            String sqlUpdate2 = "update sieuthi.don_hang, sieuthi.don_chi_tiet " +
            "set sieuthi.don_hang.tien = (select sum(sieuthi.don_chi_tiet.tong_tien) from sieuthi.don_chi_tiet " +
            "where sieuthi.don_hang.id_don = sieuthi.don_chi_tiet.id_don); ";
            String sqlUpdate3 = "update sieuthi.don_hang " +
            "set giam = (select (case when (select hang from sieuthi.khach_hang  " +
            "where don_hang.id_khach = khach_hang.id_khach) = 'VANG' then 20 " +
            "when (select hang from sieuthi.khach_hang " +
            "where don_hang.id_khach = khach_hang.id_khach) = 'BAC' then 10 " +
            "when (select hang from sieuthi.khach_hang  " +
            "where don_hang.id_khach = khach_hang.id_khach) = 'KHONG CO HANG' then 0 END) ); ";
                    
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, donHang.getId_don());
            ps.setInt(2, donHang.getId_khach());
            ps.setString(3, donHang.getNgay());
            ps.setInt(4, donHang.getSo_sp());
            ps.setLong(5, donHang.getTien());
            ps.setLong(6, donHang.getGiam());
//            ps.setLong(7, donHang.getTong());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps = cons.prepareStatement(sqlUpdate1);
            ps.execute();
            ps = cons.prepareStatement(sqlUpdate2);
            ps.execute(); ps = cons.prepareStatement(sqlUpdate3);
            ps.execute();
            ps.close();
            cons.close();
//            System.out.println(generatedKey);
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
            String sql = "DELETE FROM sieuthi.don_hang WHERE sieuthi.don_hang.id_don = ?; ";
            String sqlCount = "SELECT COUNT(*) FROM sieuthi.don_hang; ";
            int before = 0, after = 0;
            PreparedStatement ps = cons.prepareStatement(sqlCount);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                before = rs.getInt("COUNT(*)");
            }
            
            ps = cons.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
//            ResultSet rs = ps.getGeneratedKeys();

            ps = cons.prepareStatement(sqlCount);
            rs = ps.executeQuery();
            while(rs.next())
            {
                after = rs.getInt("COUNT(*)");
            }
            ps.close();
            cons.close();
            if(before == after)
                return 0;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
