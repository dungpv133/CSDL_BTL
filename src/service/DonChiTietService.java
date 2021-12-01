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

import DAO.DonChiTietDAO;
import DAO.DonHangDAO;
import java.util.List;
import model.DonChiTiet;

public class DonChiTietService {

    private DonChiTietDAO donChiTietDAO = null;

    public DonChiTietService() {
        this.donChiTietDAO = new DonChiTietDAO();
    }

    public List<DonChiTiet> getList() {
        return donChiTietDAO.getList();
    }

     public int createOrUpdate(DonChiTiet donChiTiet) {
        return donChiTietDAO.createOrUpdate(donChiTiet);
    }
    
     public int deleteById(int id)
     {
         return donChiTietDAO.DeleteById(id);
     }
}
