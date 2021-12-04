
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
import model.DonHang;
import model.SanPham;
import service.DonHangService;
import service.SanPhamService;
//import com.toedter.calendar.JDateChooser;
public class DonHangNewController {
    private JButton btnSubmit;
    private JLabel jlblIdDon;
    private JTextField jtfIdKhach;
    private JTextField jtfNgay;
    private JLabel jlbSoSP;
    private JLabel jlblTien;
    private JLabel jlblGiam;
    private JLabel jlblTong;

//    private JTextArea jtaDiaChi;
    private JLabel jlbMsg;

    private DonHang donHang = null;

    private DonHangService donHangService = null;

    public DonHangNewController(JButton btnSubmit, JLabel jlblIdDon, JTextField jtfIdKhach, 
            JTextField jtfNgay, JLabel jlbSoSP, JLabel jlblTien, 
            JLabel jlblGiam, JLabel jlblTong, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jlblIdDon = jlblIdDon;
        this.jtfIdKhach = jtfIdKhach;
        this.jtfNgay = jtfNgay;
        this.jlbSoSP = jlbSoSP;
        this.jlblTien = jlblTien;
        this.jlblGiam = jlblGiam;
        this.jlblTong = jlblTong;
        this.jlbMsg = jlbMsg;
        
        this.donHangService = new DonHangService();
    }

    

    
    
    

    public void setView(DonHang donHang) {
        this.donHang = donHang;
        // set data
        jlblIdDon.setText(Integer.toString(donHang.getId_don()));
        jtfIdKhach.setText(Integer.toString(donHang.getId_khach()));
//        if(donHang.getNgay() == null)
//        {
//            donHang.setNgay((java.sql.Date) new Date());
//        }
        jtfNgay.setText(donHang.getNgay());
        jlbSoSP.setText(Integer.toString(donHang.getSo_sp()));
        jlblTien.setText(Long.toString(donHang.getTien()));
        jlblGiam.setText(Long.toString(donHang.getGiam()));
        jlblTong.setText(Long.toString(donHang.getTong()));
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
                        donHang.setId_don(Integer.parseInt(jlblIdDon.getText()));
                        donHang.setId_khach(Integer.parseInt(jtfIdKhach.getText()));
                        donHang.setNgay(jtfNgay.getText());
                        donHang.setSo_sp(Integer.parseInt(jlbSoSP.getText()));
                        donHang.setTien(Long.parseLong(jlblTien.getText()));
                        donHang.setGiam(Long.parseLong(jlblGiam.getText()));
                        donHang.setTong(Long.parseLong(jlblTong.getText()));
//                        System.out.println(sanPham.getId_sp());
                        if (showDialog()) {
                            int lastId = donHangService.createOrUpdate(donHang);
                            if (lastId != 0) {
                                donHang.setId_don(lastId);
                                jlblIdDon.setText(String.valueOf(donHang.getId_don()));
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
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
        return jtfIdKhach.getText() != null && !jlblIdDon.getText().equalsIgnoreCase("");
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
