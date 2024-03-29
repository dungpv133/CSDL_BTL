/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.KhachHangNewController;
import model.KhachHang;

/**
 *
 * @author ADMIN
 */
public class KhachHangFrame extends javax.swing.JFrame {

    /**
     * Creates new form KhachHangFrame
     */
    public KhachHangFrame(KhachHang khachHang) {
        initComponents();
        setTitle("Thông tin khách hàng");
        KhachHangNewController khachHangNewController = 
                new KhachHangNewController(BtSave, LblId, TxtHo, TxtTen, TxtNam,
                        TxtDchi, jlbTongTien, jlbTuoi, jlbMsg);
        khachHangNewController.setView(khachHang);
//        khachHangNewController.setEvent();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }

    private KhachHangFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtSave = new javax.swing.JButton();
        LabelInfo = new javax.swing.JLabel();
        LblHo = new javax.swing.JLabel();
        LbTen = new javax.swing.JLabel();
        LbNam = new javax.swing.JLabel();
        LbDChi = new javax.swing.JLabel();
        LbTongTien = new javax.swing.JLabel();
        jlbId = new javax.swing.JLabel();
        TxtHo = new javax.swing.JTextField();
        TxtTen = new javax.swing.JTextField();
        TxtNam = new javax.swing.JTextField();
        TxtDchi = new javax.swing.JTextField();
        jlbMsg = new javax.swing.JLabel();
        jlbTuoi = new javax.swing.JLabel();
        jlbId2 = new javax.swing.JLabel();
        LblId = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        btnSample = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtSave.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        BtSave.setText("LƯU THÔNG TIN");
        BtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveActionPerformed(evt);
            }
        });

        LabelInfo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        LabelInfo.setText("Thông tin khách hàng");

        LblHo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        LblHo.setText("Họ:");

        LbTen.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        LbTen.setText("Tên:");

        LbNam.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        LbNam.setText("Năm sinh:");

        LbDChi.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        LbDChi.setText("Địa chỉ: ");

        LbTongTien.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        LbTongTien.setText("Tổng tiền chi tiêu");

        jlbId.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jlbId.setText("ID: ");

        TxtHo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        TxtHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtHoActionPerformed(evt);
            }
        });

        TxtTen.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        TxtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTenActionPerformed(evt);
            }
        });

        TxtNam.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        TxtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNamActionPerformed(evt);
            }
        });

        TxtDchi.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        TxtDchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDchiActionPerformed(evt);
            }
        });

        jlbMsg.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jlbTuoi.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jlbId2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jlbId2.setText("Tuổi: ");

        LblId.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        LblId.setToolTipText("");

        jlbTongTien.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        btnSample.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        btnSample.setText("Mẫu thông tin khách hàng");
        btnSample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSampleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 271, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(BtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LblHo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LbTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LbNam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LbDChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(TxtDchi, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSample, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TxtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LbTongTien)
                                    .addComponent(jlbId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbId2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlbTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(LblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblHo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbId2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LbDChi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtDchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSample, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtHoActionPerformed

    private void TxtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTenActionPerformed

    private void TxtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNamActionPerformed

    private void TxtDchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDchiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDchiActionPerformed

    private void BtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BtSaveActionPerformed

    private void btnSampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSampleActionPerformed
        // TODO add your handling code here:
        new KhachHangSample().setVisible(true);
    }//GEN-LAST:event_btnSampleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtSave;
    private javax.swing.JLabel LabelInfo;
    private javax.swing.JLabel LbDChi;
    private javax.swing.JLabel LbNam;
    private javax.swing.JLabel LbTen;
    private javax.swing.JLabel LbTongTien;
    private javax.swing.JLabel LblHo;
    private javax.swing.JLabel LblId;
    private javax.swing.JTextField TxtDchi;
    private javax.swing.JTextField TxtHo;
    private javax.swing.JTextField TxtNam;
    private javax.swing.JTextField TxtTen;
    private javax.swing.JButton btnSample;
    private javax.swing.JLabel jlbId;
    private javax.swing.JLabel jlbId2;
    private javax.swing.JLabel jlbMsg;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JLabel jlbTuoi;
    // End of variables declaration//GEN-END:variables
}
