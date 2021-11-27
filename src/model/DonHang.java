
package model;

import java.util.Date;


public class DonHang {
    private int id_khach, id_don, so_sp;
    private long tien, giam, tong;
    private Date ngay;

    public DonHang() {
    }

    public DonHang(int id_khach, int id_don, int so_sp, long tien, long giam, long tong, Date ngay) {
        this.id_khach = id_khach;
        this.id_don = id_don;
        this.so_sp = so_sp;
        this.tien = tien;
        this.giam = giam;
        this.tong = tong;
        this.ngay = ngay;
    }

    
    public int getId_khach() {
        return id_khach;
    }

    public void setId_khach(int id_khach) {
        this.id_khach = id_khach;
    }

    public int getId_don() {
        return id_don;
    }

    public void setId_don(int id_don) {
        this.id_don = id_don;
    }

    public int getSo_sp() {
        return so_sp;
    }

    public void setSo_sp(int so_sp) {
        this.so_sp = so_sp;
    }

    public long getTien() {
        return tien;
    }

    public void setTien(long tien) {
        this.tien = tien;
    }

    public long getGiam() {
        return giam;
    }

    public void setGiam(long giam) {
        this.giam = giam;
    }

    public long getTong() {
        return tong;
    }

    public void setTong(long tong) {
        this.tong = tong;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
    
}
