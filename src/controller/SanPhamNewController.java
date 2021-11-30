
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
import model.SanPham;
import service.SanPhamService;
//import com.toedter.calendar.JDateChooser;
public class SanPhamNewController {
    private JButton btnSubmit;
    private JTextField jtfTen;
    private JTextField jtfDonVi;
    private JTextField jtfDonGia;
    private JTextField jtfNganh;
    private JTextField jtfId;
//    private JTextArea jtaDiaChi;
    private JLabel jlbMsg;

    private SanPham sanPham = null;

    private SanPhamService sanPhamService = null;

    public SanPhamNewController(JButton btnSubmit, JTextField jtfTen, JTextField jtfDonVi, JTextField jtfDonGia, JTextField jtfNganh, JTextField jtfId, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfTen = jtfTen;
        this.jtfDonVi = jtfDonVi;
        this.jtfDonGia = jtfDonGia;
        this.jtfNganh = jtfNganh;
        this.jtfId = jtfId;
        this.jlbMsg = jlbMsg;
        
        this.sanPhamService = new SanPhamService();
    }

    
    
    

    public void setView(SanPham sanPham) {
        this.sanPham = sanPham;
        // set data
        jtfTen.setText(sanPham.getTen());
        jtfDonGia.setText(Integer.toString(sanPham.getDon_gia()));
        jtfDonVi.setText(sanPham.getDon_vi());
        jtfNganh.setText(sanPham.getNganh());
        jtfId.setText(Integer.toString(sanPham.getId_sp()));
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
                        sanPham.setTen(jtfTen.getText().trim());
                        sanPham.setDon_gia(Integer.parseInt(jtfDonGia.getText()));
                        sanPham.setDon_vi(jtfDonVi.getText());
                        sanPham.setNganh(jtfNganh.getText());
                        sanPham.setId_sp(Integer.parseInt(jtfId.getText()));
//                        System.out.println(sanPham.getId_sp());
                        if (showDialog()) {
                            int lastId = sanPhamService.createOrUpdate(sanPham);
                            if (lastId != 0) {
                                sanPham.setId_sp(lastId);
                                jtfId.setText(String.valueOf(sanPham.getId_sp()));
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
        return jtfTen.getText() != null && !jtfTen.getText().equalsIgnoreCase("");
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
