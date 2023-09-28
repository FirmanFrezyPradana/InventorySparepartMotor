/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi;
import javax.swing.JOptionPane;

/**
 *
 * @author icornermalang
 */
public class GUI_BarangKeluar extends javax.swing.JFrame {

    /**
     * Creates new form GUI_BarangKeluar
     */
    public GUI_BarangKeluar() {
        initComponents();
        ID_Barang.setEnabled(false);
        txt_NmBarang.setEnabled(false);
        txt_ForMotor.setEnabled(false);
        txt_Harga.setEnabled(false);
        txt_StokBarang.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Search = new javax.swing.JTextField();
        txt_Harga = new javax.swing.JTextField();
        txt_Jml = new javax.swing.JTextField();
        cmb_Satuan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn_proses = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        memo = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ForMotor = new javax.swing.JTextField();
        txt_NmBarang = new javax.swing.JTextField();
        ID_Barang = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_StokBarang = new javax.swing.JTextField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cari ID/Barang");

        jLabel2.setText("Harga");

        jLabel3.setText("Satuan Keluar");

        jLabel4.setText("Jumlah keluar");

        txt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchActionPerformed(evt);
            }
        });

        cmb_Satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Satuan--", "Unit", "Kardus", "kodi" }));

        jLabel5.setText("Barang Keluar");

        btn_proses.setText("List Baru");
        btn_proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prosesActionPerformed(evt);
            }
        });

        memo.setColumns(20);
        memo.setRows(5);
        jScrollPane1.setViewportView(memo);

        jLabel6.setText("ID Barang");

        jLabel7.setText("Nama Barang");

        jLabel8.setText("For Motor");

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        jLabel9.setText("Stok Barang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_proses, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_StokBarang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_Satuan, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Jml, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Harga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ForMotor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_NmBarang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID_Barang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Search, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cari))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_cari)
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(ID_Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(txt_NmBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(txt_ForMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_StokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addComponent(cmb_Satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(txt_Jml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btn_proses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchActionPerformed

    private void btn_prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prosesActionPerformed
        // TODO add your handling code here:
        BarangMasuk brgMasuk = new BarangMasuk();
        BarangKeluar brgKeluar = new BarangKeluar();
        int ID = Integer.parseInt(ID_Barang.getText());
        String nama = txt_NmBarang.getText();
        int harga = Integer.parseInt(txt_Harga.getText());
        int stok = Integer.parseInt(txt_StokBarang.getText());
        int jumlah = Integer.parseInt(txt_Jml.getText());
        memo.append("Kode Barang :"+Integer.toString(ID)+"\n");
        memo.append("Nama Barang :"+nama+"\n");
        memo.append("jumlah Barang :"+jumlah+"\n");
        memo.append("Harga satuan Barang :"+harga+"\n");
        switch (cmb_Satuan.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, "Masukkan Satuan Barang");
                break;
            case 1:
                memo.append("Harga total:"+brgKeluar.HargaTotalBarang(1,harga, jumlah)+"\n");
                break;
            case 2:
                 memo.append("Harga total:"+brgKeluar.HargaTotalBarang(2,harga, jumlah)+"\n");
                 break;
            case 3:
                 memo.append("Harga total:"+brgKeluar.HargaTotalBarang(3,harga, jumlah)+"\n");
            default:
                break;
        }
        memo.append("Stok Barang tersedia :"+brgKeluar.barangKeluar(jumlah)+"\n");
        
    }//GEN-LAST:event_btn_prosesActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        BarangMasuk brgMasuk = new BarangMasuk();
        if( txt_Search.getText().equalsIgnoreCase("12345")|| txt_Search.getText().equalsIgnoreCase("Kampas rem ysp")){
            JOptionPane.showMessageDialog(null, "Barang Ditemukan");
            ID_Barang.setText(Integer.toString(brgMasuk.kdBarang));
            txt_NmBarang.setText(brgMasuk.NmBarang);
            txt_ForMotor.setText(brgMasuk.ForMotor);
            txt_Harga.setText(Integer.toString(brgMasuk.harga));
            txt_StokBarang.setText(Integer.toString(brgMasuk.jumlah));
        }else{
            JOptionPane.showMessageDialog(null, "Barang belum di tambahkan!!!!");
        }
    }//GEN-LAST:event_btn_cariActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_BarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_BarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_BarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_BarangKeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_BarangKeluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID_Barang;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_proses;
    private javax.swing.JComboBox<String> cmb_Satuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextArea memo;
    private javax.swing.JTextField txt_ForMotor;
    private javax.swing.JTextField txt_Harga;
    private javax.swing.JTextField txt_Jml;
    private javax.swing.JTextField txt_NmBarang;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_StokBarang;
    // End of variables declaration//GEN-END:variables
}
