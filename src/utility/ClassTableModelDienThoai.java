/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.DienThoai;

public class ClassTableModelDienThoai {

    public DefaultTableModel setTableDienThoai(List<DienThoai> listItem, String[] listColumn) {
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
                   
                    default:
                        return String.class;
                }
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        DienThoai dienThoai = null;
        for (int i = 0; i < num; i++) {
            dienThoai = listItem.get(i);
            obj = new Object[columns];
            obj[0] = (i + 1);
            obj[1] = dienThoai.getId_khach();
            obj[2] = dienThoai.getSdt();
            
            dtm.addRow(obj);
        }
        return dtm;
    }

}
