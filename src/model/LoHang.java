
package model;

import java.util.Date;


public class LoHang {
    private int id_lo, nhap, ban, con;
    private String ncc;
    private Date ngay;

    public LoHang(int id_lo, int nhap, int ban, int con, String ncc, Date ngay) {
        this.id_lo = id_lo;
        this.nhap = nhap;
        this.ban = ban;
        this.con = con;
        this.ncc = ncc;
        this.ngay = ngay;
    }

    public LoHang() {
    }

    public int getId_lo() {
        return id_lo;
    }

    public void setId_lo(int id_lo) {
        this.id_lo = id_lo;
    }

        public int getNhap() {
        return nhap;
    }

    public void setNhap(int nhap) {
        this.nhap = nhap;
    }

    public int getBan() {
        return ban;
    }

    public void setBan(int ban) {
        this.ban = ban;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public String getNcc() {
        return ncc;
    }

    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
}
