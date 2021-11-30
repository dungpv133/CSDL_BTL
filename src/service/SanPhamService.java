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

import DAO.SanPhamDAO;
import java.util.List;
import model.SanPham;

public class SanPhamService {

    private SanPhamDAO sanPhamDAO = null;

    public SanPhamService() {
        this.sanPhamDAO = new SanPhamDAO();
    }

    public List<SanPham> getList() {
        return sanPhamDAO.getList();
    }

     public int createOrUpdate(SanPham sanPham) {
        return sanPhamDAO.createOrUpdate(sanPham);
    }
}
