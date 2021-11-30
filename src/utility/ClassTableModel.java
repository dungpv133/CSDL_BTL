/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;

public class ClassTableModel {

    public DefaultTableModel setTableKhachHang(List<KhachHang> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return columnIndex == 9 ? Boolean.class : String.class;
//            }
            
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return Integer.class;
                    case 4:
                        return Integer.class;
                    case 6:
                        return Integer.class;
                    case 7:
                        return Integer.class;
                        
                    default:
                        return String.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        KhachHang khachHang = null;
        for (int i = 0; i < num; i++) {
            khachHang = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = khachHang.getId_khach();
            obj[2] = khachHang.getHo();
            obj[3] = khachHang.getTen();
            obj[4] = khachHang.getNam_sinh();
            obj[5] = khachHang.getDchi();
            obj[6] = khachHang.getTong();
            obj[7] = khachHang.getTuoi();
            obj[8] = khachHang.getHang();
            dtm.addRow(obj);
        }
        return dtm;
    }

}
