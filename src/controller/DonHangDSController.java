
package controller;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.DonHang;
import service.DonHangService;
import utility.ClassTableModelDonHang;
import view.DonHangFrame;


public class DonHangDSController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnUpdate;

    private ClassTableModelDonHang classTableModelDonHang = null;

    private final String[] COLUMNS = {"STT", "Mã đơn", "Mã khách", "Ngày mua", 
        "Số sản phẩm", "Tiền", "Giảm", "Tổng tiền"};

    private DonHangService donHangService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public DonHangDSController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnUpdate) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnUpdate = btnUpdate;
        this.classTableModelDonHang = new ClassTableModelDonHang();

        this.donHangService = new DonHangService();
    }

    public void setDataToTable() {
//        donHangService.createOrUpdate(donHang);
        List<DonHang> listItem = donHangService.getList();
        DefaultTableModel model = classTableModelDonHang.setTableDonHang(listItem, COLUMNS);
        JTable table = new JTable(model);
        DefaultTableCellRenderer lefRenderer = new DefaultTableCellRenderer();
        lefRenderer.setHorizontalAlignment(JLabel.LEFT);
        for(int i = 0; i < 8; i++)
        {
           table.getColumnModel().getColumn(i).setCellRenderer(lefRenderer);
        }
//        table.getColumnModel().getColumn(1).setCellRenderer(lefRenderer);
//        table.getColumnModel().getColumn(4).setCellRenderer(lefRenderer);
//        table.getColumnModel().getColumn(6).setCellRenderer(lefRenderer);
//        table.getColumnModel().getColumn(7).setCellRenderer(lefRenderer);

//        table.setAutoCreateRowSorter(true);


        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

      table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
             if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    DonHang donHang = new DonHang();
                    donHang.setId_don((int) model.getValueAt(selectedRowIndex, 1));
                    donHang.setId_khach((int) model.getValueAt(selectedRowIndex, 2));
                    donHang.setNgay(model.getValueAt(selectedRowIndex, 3).toString());
//                 try {
//                     donHang.setNgay((java.sql.Date) new SimpleDateFormat("dd/MM/yyyy")
//                             .parse(model.getValueAt(selectedRowIndex, 3).toString()));
//                 } catch (ParseException ex) {
//                     Logger.getLogger(DonHangDSController.class.getName()).log(Level.SEVERE, null, ex);
//                 }
                    donHang.setSo_sp((int) model.getValueAt(selectedRowIndex, 4));
                    donHang.setTien((long) model.getValueAt(selectedRowIndex, 5));
                    donHang.setGiam((long) model.getValueAt(selectedRowIndex, 6));
                    donHang.setTong((long) model.getValueAt(selectedRowIndex, 7));

                    DonHangFrame frame = new DonHangFrame(donHang);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("Thông tin đơn hàng");
                    frame.setVisible(true);
             }
      }

});
        
        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
//        jpnView.setAlignmentX(0);
    }

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e) {
                new DonHangFrame(new DonHang()).setVisible(true);
//                  KhachHangFrame khachHangFrame = new KhachHangFrame(new KhachHang());
//                  khachHangFrame.setVisible(true);
//                  khachHangFrame.set
            }
            
            @Override
            public void mouseEntered(MouseEvent e)
            {
                btnAdd.setBackground(new Color(0, 200, 83));
            }
            
            @Override
            public void mouseExited(MouseEvent e)
            {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
    }
    public void setEventUpdate() {
        btnUpdate.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e) {
                setDataToTable();
            }
            
            @Override
            public void mouseEntered(MouseEvent e)
            {
                btnUpdate.setBackground(new Color(0, 200, 83));
            }
            
            @Override
            public void mouseExited(MouseEvent e)
            {
                btnUpdate.setBackground(new Color(100, 221, 23));
            }
        });
    }

}
