
package model;

import java.io.Serializable;


public class KhachHang implements Serializable{
    private int id_khach, nam_sinh, tuoi;
    private String ho, ten, dchi, hang;
    private long tong;

    public KhachHang(int id_khach, int nam_sinh, int tuoi, String ho, String ten, String dchi, String hang, long tong) {
        this.id_khach = id_khach;
        this.nam_sinh = nam_sinh;
        this.tuoi = tuoi;
        this.ho = ho;
        this.ten = ten;
        this.dchi = dchi;
        this.hang = hang;
        this.tong = tong;
    }

    public KhachHang() {
    }

    public int getId_khach() {
        return id_khach;
    }

    public void setId_khach(int id_khach) {
        this.id_khach = id_khach;
    }

    

    public int getNam_sinh() {
        return nam_sinh;
    }

    public void setNam_sinh(int nam_sinh) {
        this.nam_sinh = nam_sinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public long getTong() {
        return tong;
    }

    public void setTong(long tong) {
        this.tong = tong;
    }
    
    
}
