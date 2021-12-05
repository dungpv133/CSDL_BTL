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
import model.DienThoai;
/**
 *
 * @author ADMIN
 */
public class DienThoaiDAO {
    public List<DienThoai> getList() {
        Connection cons = (Connection) DBConnection.getConnection();
        String sql = "SELECT * FROM sieuthi.dien_thoai";
        List<DienThoai> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DienThoai dienThoai = new DienThoai();
                dienThoai.setId_khach(rs.getInt("id_khach"));
                dienThoai.setSdt(rs.getString("sdt"));
                list.add(dienThoai);
            }
            ps.close();
            cons.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int createOrUpdate(DienThoai dienThoai) {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "INSERT INTO dien_thoai(id_khach, sdt)"
                    + " VALUES(?, ?) ON DUPLICATE KEY UPDATE id_khach = VALUES(id_khach), "
                    + "sdt = VALUES(sdt); ";
            
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dienThoai.getId_khach());
            ps.setString(2, dienThoai.getSdt());
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

    public  int DeleteById(int id)
    {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "DELETE FROM sieuthi.dien_thoai WHERE sieuthi.dien_thoai.id_khach = ?; ";
            String sqlCount = "SELECT COUNT(*) FROM sieuthi.dien_thoai; ";
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

    public  int DeleteBySDT(String sdt)
    {
        try {
            Connection cons = DBConnection.getConnection();
            String sql = "DELETE FROM sieuthi.dien_thoai WHERE sieuthi.dien_thoai.sdt = ?; ";
            String sqlCount = "SELECT COUNT(*) FROM sieuthi.dien_thoai; ";
            int before = 0, after = 0;
            PreparedStatement ps = cons.prepareStatement(sqlCount);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                before = rs.getInt("COUNT(*)");
            }
            
            ps = cons.prepareStatement(sql);
            ps.setString(1, sdt);
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
