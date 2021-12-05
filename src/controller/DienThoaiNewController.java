
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
import model.DienThoai;
import service.DienThoaiService;
//import com.toedter.calendar.JDateChooser;
public class DienThoaiNewController {
    private JButton btnSubmit;
    private JTextField jtfIdKhach;
    private JTextField jtfSDT;
    
    private JLabel jlbMsg;

    private DienThoai dienThoai = null;

    private DienThoaiService dienThoaiService = null;

    public DienThoaiNewController(JButton btnSubmit, JTextField jtfIdKhach, JTextField jtfSDT, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfIdKhach = jtfIdKhach;
        this.jtfSDT = jtfSDT;
        this.jlbMsg = jlbMsg;
        
        this.dienThoaiService = new DienThoaiService();
    }

    
    
    

    public void setView(DienThoai dienThoai) {
        this.dienThoai = dienThoai;
        // set data
        jtfIdKhach.setText(Integer.toString(dienThoai.getId_khach()));
        jtfSDT.setText(dienThoai.getSdt());
        
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
                    else if(!checkSDT())
                    {
                        jlbMsg.setText("Số điện thoại không hợp lệ! ");
                    }
                    else {
                        dienThoai.setId_khach(Integer.parseInt(jtfIdKhach.getText()));
                        dienThoai.setSdt(jtfSDT.getText());
                        int lastId = dienThoaiService.createOrUpdate(dienThoai);
                        jlbMsg.setText("Cập nhật dữ liệu thành công!");
                       
//                        if (showDialog()) {
//                            int lastId = dienThoaiService.createOrUpdate(dienThoai);
//                            if (lastId != 0) {
//                                dienThoai.setId_khach(lastId);
//                                
//                            } else {
//                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
//                            }
//                        }
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
        return jtfIdKhach.getText() != null && !jtfSDT.getText().equalsIgnoreCase("");
    }
    private boolean checkSDT()
    {
        if(!jtfSDT.getText().matches("\\d+"))
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
