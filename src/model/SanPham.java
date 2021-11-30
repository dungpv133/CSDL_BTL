
package model;

public class SanPham {
    private int id_sp;
    private String ten, don_vi, nganh;
    private int don_gia;

    public SanPham(int id_sp, String ten, String don_vi, String nganh, int don_gia) {
        this.id_sp = id_sp;
        this.ten = ten;
        this.don_vi = don_vi;
        this.nganh = nganh;
        this.don_gia = don_gia;
    }

    public SanPham() {
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDon_vi() {
        return don_vi;
    }

    public void setDon_vi(String don_vi) {
        this.don_vi = don_vi;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(int don_gia) {
        this.don_gia = don_gia;
    }
    
    
}
