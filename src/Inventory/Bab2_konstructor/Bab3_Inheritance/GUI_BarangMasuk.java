/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance;

import javax.swing.JOptionPane;

/**
 *
 * @author icornermalang
 */
public class GUI_BarangMasuk extends javax.swing.JFrame {

    /**
     * Creates new form GUI_TambahBarang
     */
    public GUI_BarangMasuk() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Search = new javax.swing.JTextField();
        txt_NmBarang = new javax.swing.JTextField();
        txt_Suplayer = new javax.swing.JTextField();
        btn_Cek = new javax.swing.JButton();
        txt_HargaJual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_satuan = new javax.swing.JComboBox<>();
        txt_Jumlah = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memo = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txt_HargaSuplayer = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BarangMasuk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ID_Barang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Barang Masuk");

        jLabel2.setText("Cari ID/ Nama");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Suplayer");

        jLabel6.setText("Harga Jual");

        btn_Cek.setText("Cek");
        btn_Cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CekActionPerformed(evt);
            }
        });

        jLabel7.setText("Satuan");

        jLabel9.setText("Rp.");

        cmb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Satuan--", "Unit", "Kardus", "kodi" }));

        jLabel10.setText("Jumlah");

        memo.setColumns(20);
        memo.setRows(5);
        jScrollPane1.setViewportView(memo);

        jLabel12.setText("Harga Suplayer");

        jLabel13.setText("Rp.");

        BarangMasuk.setText("Barang Masuk");
        BarangMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarangMasukActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Barang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(btn_Cek, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_NmBarang)
                            .addComponent(txt_Suplayer)
                            .addComponent(txt_HargaSuplayer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_HargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_Barang))))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BarangMasuk)
                        .addGap(206, 206, 206))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Cek)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ID_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txt_NmBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txt_Suplayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_HargaSuplayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_HargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BarangMasuk)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BarangMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarangMasukActionPerformed
        // TODO add your handling code here:
        int berhasil=0;
        BarangMasuk brgMasuk = new BarangMasuk();
        brgMasuk.harga_jual = Integer.parseInt(txt_HargaJual .getText());
        brgMasuk.harga_suplayer = Integer.parseInt(txt_HargaSuplayer .getText());
        int jum = Integer.parseInt(txt_Jumlah.getText());
        memo.append("Kode Barang :"+Integer.toString(brgMasuk.kdBarang)+"\n");
        memo.append("Nama Barang :"+brgMasuk.NmBarang+"\n");
        memo.append("Nama Suplayer :"+brgMasuk.Suplayer+"\n");
        memo.append("Harga Suplayer :"+brgMasuk.harga_suplayer+"\n");
        memo.append("Harga Jual :"+brgMasuk.harga_jual+"\n");
        switch (cmb_satuan.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, "Masukkan Satuan Barang");
                break;
            case 1:
                memo.append("Jumlah Barang : "+Integer.toString(brgMasuk.Jumlah(1, jum)));
                berhasil = 1;
                break;
            case 2:
                 memo.append("Jumlah Barang : "+Integer.toString(brgMasuk.Jumlah(2, jum)));
                 berhasil = 1;
                 break;
            case 3:
                berhasil = 1;
                 memo.append("Jumlah Barang : "+Integer.toString(brgMasuk.Jumlah(3, jum)));
            default:
                break;
        }
        if(berhasil == 1){
            JOptionPane.showMessageDialog(null, "Barang berhasil dimasukkan");
        }
       
        
    }//GEN-LAST:event_BarangMasukActionPerformed

    private void btn_CekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CekActionPerformed
        // TODO add your handling code here:
        BarangMasuk brgMasuk = new BarangMasuk();
        if( txt_Search.getText().equalsIgnoreCase("12345")|| txt_Search.getText().equalsIgnoreCase("Kampas rem ysp")){
            JOptionPane.showMessageDialog(null, "Barang Ditemukan");
            ID_Barang.setText(Integer.toString(brgMasuk.kdBarang));
            txt_NmBarang.setText(brgMasuk.NmBarang);
            txt_Suplayer.setText(brgMasuk.Suplayer);
        }else{
            JOptionPane.showMessageDialog(null, "Barang belum di tambahkan!!!!");
        }
        
    }//GEN-LAST:event_btn_CekActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_BarangMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_BarangMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BarangMasuk;
    private javax.swing.JTextField ID_Barang;
    private javax.swing.JButton btn_Cek;
    private javax.swing.JComboBox<String> cmb_satuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea memo;
    private javax.swing.JTextField txt_HargaJual;
    private javax.swing.JTextField txt_HargaSuplayer;
    private javax.swing.JTextField txt_Jumlah;
    private javax.swing.JTextField txt_NmBarang;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_Suplayer;
    // End of variables declaration//GEN-END:variables
}
