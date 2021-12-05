/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author ADMIN
 */

import DAO.DienThoaiDAO;
import java.util.List;
import model.DienThoai;

public class DienThoaiService {

    private DienThoaiDAO dienThoaiDAO = null;

    public DienThoaiService() {
        this.dienThoaiDAO = new DienThoaiDAO();
    }

    public List<DienThoai> getList() {
        return dienThoaiDAO.getList();
    }

     public int createOrUpdate(DienThoai dienThoai) {
        return dienThoaiDAO.createOrUpdate(dienThoai);
    }
    
     public int deleteById(int id)
     {
         return dienThoaiDAO.DeleteById(id);
     }

     public int deleteBySDT(String sdt)
     {
         return dienThoaiDAO.DeleteBySDT(sdt);
     }
}
