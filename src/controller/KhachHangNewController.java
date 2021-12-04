
package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.KhachHang;
import service.KhachHangService;
//import com.toedter.calendar.JDateChooser;
public class KhachHangNewController {
    private JButton btnSubmit;
    private JTextField jtfHo;
    private JTextField jtfTen;
    private JTextField jtfNamSinh;
    private JTextField jtfDiaChi;
    private JLabel jlbTong;
    private JLabel jlbId;
    private JLabel jlbTuoi;
//    private JTextArea jtaDiaChi;
    private JLabel jlbMsg;

    private KhachHang khachHang = null;

    private KhachHangService khachHangService = null;

    public KhachHangNewController(JButton btnSubmit,JLabel jlbId, JTextField jtfHo, 
            JTextField jtfTen, JTextField jtfNamSinh, JTextField jtfDiaChi, 
            JLabel jlbTong, JLabel jlbTuoi, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfHo = jtfHo;
        this.jtfTen = jtfTen;
        this.jtfNamSinh = jtfNamSinh;
        this.jtfDiaChi = jtfDiaChi;
        this.jlbTong = jlbTong;
        this.jlbMsg = jlbMsg;
        this.jlbId = jlbId;
        this.jlbTuoi = jlbTuoi;
        this.khachHangService = new KhachHangService();
        
    }
    
    

    public void setView(KhachHang khachHang) {
        this.khachHang = khachHang;
        // set data
        jtfHo.setText(khachHang.getHo());
        jtfTen.setText(khachHang.getTen());
        jtfNamSinh.setText(Integer.toString(khachHang.getNam_sinh()));
        jtfDiaChi.setText(khachHang.getDchi());
        jlbTong.setText(Long.toString(khachHang.getTong()));
        jlbId.setText(Integer.toString(khachHang.getId_khach()));
        jlbTuoi.setText(Integer.toString(khachHang.getTuoi()));
//        System.out.println(khachHang.getTuoi());
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
                    }
                    else if(!checkTuoi())
                    {
                        jlbMsg.setText("Năm sinh không hợp lệ! ");
                    }
                    else {
                        khachHang.setHo(jtfHo.getText().trim());
                        khachHang.setTen(jtfTen.getText());
                        khachHang.setNam_sinh(Integer.parseInt(jtfNamSinh.getText()));
                        khachHang.setDchi(jtfDiaChi.getText());
                        khachHang.setTong(Long.parseLong(jlbTong.getText()));
                        khachHang.setId_khach(Integer.parseInt(jlbId.getText()));
//                        System.out.println(khachHang.getId_khach());
                        if (showDialog()) {
                            int lastId = khachHangService.createOrUpdate(khachHang);
                            if (lastId != 0) {
                                khachHang.setId_khach(lastId);
                                jlbId.setText(String.valueOf(khachHang.getId_khach()));
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
        return jtfHo.getText() != null && !jtfHo.getText().equalsIgnoreCase("");
    }
    private boolean checkTuoi()
    {
        int namSinh = Integer.parseInt(jtfNamSinh.getText());
        if(namSinh < 1000 || namSinh > 2021)
            return false;
        return true;
        
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
