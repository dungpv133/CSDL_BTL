/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class DonChiTiet {
    private int id_don, id_sp, so_luong;
    private long tong_tien;

    public DonChiTiet(int id_don, int id_sp, int so_luong, long tong_tien) {
        this.id_don = id_don;
        this.id_sp = id_sp;
        this.so_luong = so_luong;
        this.tong_tien = tong_tien;
    }

    public DonChiTiet() {
    }

    public int getId_don() {
        return id_don;
    }

    public void setId_don(int id_don) {
        this.id_don = id_don;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public long getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(long tong_tien) {
        this.tong_tien = tong_tien;
    }
    
    
}
