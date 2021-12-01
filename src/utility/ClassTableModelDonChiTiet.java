/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DonChiTiet;

public class ClassTableModelDonChiTiet {

    public DefaultTableModel setTableDonChiTiet(List<DonChiTiet> listItem, String[] listColumn) {
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
                   
                    case 4:
                        return Long.class;
                   
                        
                    default:
                        return Integer.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        DonChiTiet donChiTiet = null;
        for (int i = 0; i < num; i++) {
            donChiTiet = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = donChiTiet.getId_don();
            obj[2] = donChiTiet.getId_sp();
            obj[3] = donChiTiet.getSo_luong();
            obj[4] = donChiTiet.getTong_tien();
            
            dtm.addRow(obj);
        }
        return dtm;
    }

}
