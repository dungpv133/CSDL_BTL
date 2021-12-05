
package model;

import java.io.Serializable;


public class DienThoai implements Serializable{
    private int id_khach;
    private String sdt;

    public DienThoai() {
    }

    public DienThoai(int id_khach, String sdt) {
        this.id_khach = id_khach;
        this.sdt = sdt;
    }

    public int getId_khach() {
        return id_khach;
    }

    public void setId_khach(int id_khach) {
        this.id_khach = id_khach;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
