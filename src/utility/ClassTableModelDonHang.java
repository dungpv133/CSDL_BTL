/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DonHang;

public class ClassTableModelDonHang {

    public DefaultTableModel setTableDonHang(List<DonHang> listItem, String[] listColumn) {
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
                    case 3:
                        return String.class;
                    case 5:
                        return Long.class;
                    case 6:
                        return Long.class;
                    case 7:
                        return Long.class;
                    
                        
                    default:
                        return Integer.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        DonHang donHang = null;
        for (int i = 0; i < num; i++) {
            donHang = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = donHang.getId_don();
            obj[2] = donHang.getId_khach();
            obj[3] = donHang.getNgay();
            obj[4] = donHang.getSo_sp();
            obj[5] = donHang.getTien();
            obj[6] = donHang.getGiam();
            obj[7] = donHang.getTong();
            
            dtm.addRow(obj);
        }
        return dtm;
    }

}
