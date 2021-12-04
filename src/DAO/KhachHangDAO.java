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
import javax.crypto.spec.PSource;
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
                    + "dia_chi = VALUES(dia_chi); ";
            String sqlUpdate =  "update sieuthi.khach_hang, sieuthi.don_hang " +
                        "set sieuthi.khach_hang.tong_tien = (select sum(sieuthi.don_hang.tong_tien) " +
                        "from sieuthi.don_hang where sieuthi.don_hang.id_khach = sieuthi.khach_hang.id_khach);";
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
            String sql = "DELETE FROM sieuthi.khach_hang WHERE sieuthi.khach_hang.id_khach = ?; ";
            String sqlCount = "SELECT COUNT(*) FROM sieuthi.khach_hang; ";
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
