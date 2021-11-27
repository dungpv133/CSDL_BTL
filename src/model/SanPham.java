
package model;

public class SanPham {
    private int id_sp, id_lo;
    private String ten, don_vi, nganh;
    private long don_gia;

    public SanPham(int id_sp, int id_lo, String ten, String don_vi, String nganh, long don_gia) {
        this.id_sp = id_sp;
        this.id_lo = id_lo;
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

    public int getId_lo() {
        return id_lo;
    }

    public void setId_lo(int id_lo) {
        this.id_lo = id_lo;
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

    public long getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(long don_gia) {
        this.don_gia = don_gia;
    }
    
    
}
