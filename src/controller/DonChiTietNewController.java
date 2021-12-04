
package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.DonChiTiet;
import model.DonHang;
import model.SanPham;
import service.DonChiTietService;
import service.DonHangService;
import service.SanPhamService;
//import com.toedter.calendar.JDateChooser;
public class DonChiTietNewController {
    private JButton btnSubmit;
    private JTextField jtfIdDon;
    private JTextField jtfIdSanPham;
    private JTextField jtfSoLuong;
    private JLabel jlbTongTien;

    private JLabel jlbMsg;

    private DonChiTiet donChiTiet = null;

    private DonChiTietService donChiTietService = null;

    public DonChiTietNewController(JButton btnSubmit, JTextField jtfIdDon, JTextField jtfIdSanPham, JTextField jtfSoLuong, JLabel jlbTongTien, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfIdDon = jtfIdDon;
        this.jtfIdSanPham = jtfIdSanPham;
        this.jtfSoLuong = jtfSoLuong;
        this.jlbTongTien = jlbTongTien;
        this.jlbMsg = jlbMsg;
        
       this.donChiTietService = new DonChiTietService();
    }

   

    

    
    
    

    public void setView(DonChiTiet donChiTiet) {
        this.donChiTiet = donChiTiet;
        // set data
        jtfIdDon.setText(Integer.toString(donChiTiet.getId_don()));
        jtfIdSanPham.setText(Integer.toString(donChiTiet.getId_sp()));
        jtfSoLuong.setText(Integer.toString(donChiTiet.getSo_luong()));
        jlbTongTien.setText(Long.toString(donChiTiet.getTong_tien()));
        // set event
        setEvent();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        donChiTiet.setId_don(Integer.parseInt(jtfIdDon.getText()));
                        donChiTiet.setId_sp(Integer.parseInt(jtfIdSanPham.getText()));
                        donChiTiet.setSo_luong(Integer.parseInt(jtfSoLuong.getText()));
                        donChiTiet.setTong_tien(Long.parseLong(jlbTongTien.getText()));
                        if (showDialog()) {
                            int lastId = donChiTietService.createOrUpdate(donChiTiet);
//                            if (lastId != 0) {
////                                donChiTiet.setId_don(lastId);
////                                jtfIdDon.setText(String.valueOf(donChiTiet.getId_don()));
//                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
//                            } else {
//                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
//                            }
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
    }

    private boolean checkNotNull() {
        return jtfIdDon.getText() != null && !jtfIdDon.getText().equalsIgnoreCase("");
    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
    
    public java.sql.Date covertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}
