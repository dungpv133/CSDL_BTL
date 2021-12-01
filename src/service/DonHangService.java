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

import DAO.DonHangDAO;
import java.util.List;
import model.DonHang;
import model.KhachHang;

public class DonHangService {

    private DonHangDAO donHangDAO = null;

    public DonHangService() {
        this.donHangDAO = new DonHangDAO();
    }

    public List<DonHang> getList() {
        return donHangDAO.getList();
    }

     public int createOrUpdate(DonHang donHang) {
        return donHangDAO.createOrUpdate(donHang);
    }
    
     public int deleteById(int id)
     {
         return donHangDAO.DeleteById(id);
     }
}
