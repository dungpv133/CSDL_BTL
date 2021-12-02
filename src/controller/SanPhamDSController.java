
package controller;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
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
import model.SanPham;
import service.SanPhamService;
import utility.ClassTableModel;
import utility.ClassTableModelSanPham;
import view.KhachHangFrame;
import view.SanPhamFrame;

public class SanPhamDSController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnUpdate;

    private ClassTableModelSanPham classTableModelSanPham = null;

    private final String[] COLUMNS = {"STT", "Mã Sản phẩm", "Tên", "Đơn vị", "Đơn giá",
    "Ngành"};

    private SanPhamService sanPhamService = null;

    private TableRowSorter<TableModel> rowSorter = null;

    public SanPhamDSController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnUpdate) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnUpdate = btnUpdate;
        this.classTableModelSanPham = new ClassTableModelSanPham();

        this.sanPhamService = new SanPhamService();
    }

    public void setDataToTable() {
        List<SanPham> listItem = sanPhamService.getList();
        DefaultTableModel model = classTableModelSanPham.setTableSanPham(listItem, COLUMNS);
        JTable table = new JTable(model);
        DefaultTableCellRenderer lefRenderer = new DefaultTableCellRenderer();
        lefRenderer.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(0).setCellRenderer(lefRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(lefRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(lefRenderer);

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

                    SanPham sanPham = new SanPham();
                    sanPham.setId_sp((int) model.getValueAt(selectedRowIndex, 1));
                    sanPham.setTen(model.getValueAt(selectedRowIndex, 2).toString());
                    sanPham.setDon_vi(model.getValueAt(selectedRowIndex, 3).toString());
                    sanPham.setDon_gia(Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString()));
                    sanPham.setNganh(model.getValueAt(selectedRowIndex, 5).toString());

                    SanPhamFrame frame = new SanPhamFrame(sanPham);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("Thông tin sản phẩm");
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
                new SanPhamFrame(new SanPham()).setVisible(true);
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
