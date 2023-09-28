/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.Bab10_Database;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.*;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.*;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Random;


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
        tampil_barang();
        tampil();
        txt_NamaBarang.setEnabled(false);
        txt_deskripsi.setEnabled(false);
        txt_harga.setEnabled(false);
        txt_stock.setEnabled(false);
    }
    int random;
    public Connection conn;
    String kode_barangKeluar1,kode1;
    
    public void itempilih(){
        cmb_barang.setSelectedItem(kode1);
    }
    
    public void batal(){
        cmb_barang.setSelectedItem("--Pilih--");
        txt_NamaBarang.setText(" ");
        txt_deskripsi.setText(" ");
        txt_harga.setText(" ");
        txt_stock.setText(" ");
        txt_Jumlah.setText(" ");
        Calender.setDateFormatString( " ");
    }

    public void koneksi() throws SQLException {
        try {
           conn=null;
           Class.forName("com.mysql.jdbc.Driver");
           conn= DriverManager.getConnection("jdbc:mysql://localhost/InvetorySparepartMotor?user=root&password=");
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.Bab10_Database.GUI_BarangMasuk.class.getName()).log(Level.SEVERE,null, ex);
        }
        catch (SQLException e) {
             Logger.getLogger(Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.Bab10_Database.GUI_BarangMasuk.class.getName()).log(Level.SEVERE,null, e);
        }
        catch (Exception es) {
            Logger.getLogger(Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.Bab10_Database.GUI_BarangMasuk.class.getName()).log(Level.SEVERE,null, es);

        }
    }
    public int rand(){
        Random rndm = new Random();
        for(int i = 0; i<10 ; i++){
            random = rndm.nextInt(100000);
        }
        return random;
    }
    public void tampil_barang(){
            try {
                koneksi();
                String sql = "SELECT barang_kode FROM `tb_barangMasuk`";
                Statement stt = conn.createStatement();
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    Object[] ob = new Object[3];
                    ob[0] = res.getString(1);
                    cmb_barang.addItem((String) ob[0]);
                }
                res.close();
                stt.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
    } 
    public void refresh(){
        new GUI_BarangKeluar().setVisible(true);
        this.setVisible(false);
    }
    public void insert(){
        int Quntity=0,total;
        int rdm = rand();
        String KdBarang   = (String) cmb_barang.getSelectedItem();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = date.format(Calender.getDate());
        int qty = Integer.parseInt(txt_Jumlah.getText());
        int harga = Integer.parseInt(txt_harga.getText());
        if(cmb_satuan.getSelectedIndex() == 1){
            Quntity = qty;
        }else if(cmb_satuan.getSelectedIndex() == 2){
            Quntity = qty * 12;
        }else if(cmb_satuan.getSelectedIndex() == 3){
            Quntity = qty * 24;
        }
        total = harga * Quntity;
        try {
        koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_barangKeluar (KodeBarang_keluar, barangKode,tanggalKeluar,Harga,Quantity,TotalHarga)" 
                                    +"VALUES('"+rdm+"','"+KdBarang +"','"+tanggal+"','"+harga+"','"+Quntity+"','"+total+"')");
            update_stock();
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Barang!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
            
        }
        refresh();
    }
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID Keluar");
        tabelhead.addColumn("KODE");
        tabelhead.addColumn("TanggaL Keluar");
        tabelhead.addColumn("Harga");
        tabelhead.addColumn("QTY");
        tabelhead.addColumn("Total");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_barangKeluar";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2),res.getString(3), res.getString(4), 
                    res.getString(5), res.getString(6),res.getString(7), });
            }
            tabel_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void update_stock(){
        int Quntity=0,jml_stock;
        String kode    = (String) cmb_barang.getSelectedItem();
        int qty = Integer.parseInt(txt_Jumlah.getText());
        int stock =Integer.parseInt(txt_stock.getText());
        if(cmb_satuan.getSelectedIndex() == 1){
            Quntity = qty;
        }else if(cmb_satuan.getSelectedIndex() == 2){
            Quntity = qty * 12;
        }else if(cmb_satuan.getSelectedIndex() == 3){
            Quntity = qty * 24;
        }
        jml_stock = stock - Quntity;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_barangMasuk SET quantity_barang='"+jml_stock+"'WHERE  barang_kode='"+kode+"'");
            statement.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : "+e);
        }
        refresh();
    }
    public void search_barang(){
        try{
        try (Statement statement = conn.createStatement()) {
            String sql="SELECT * FROM tb_barang WHERE `Kode_barang`  LIKE '%"+cmb_barang.getSelectedItem()+"%'";
            ResultSet rs=statement.executeQuery(sql); //menampilkan data dari sql query
            if(rs.next()) // .next() = scanner method
            {
                txt_NamaBarang.setText(rs.getString(3));
                txt_deskripsi.setText(rs.getString(6));
            }
            else{
            JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
            }
        }
        }catch (Exception ex){
            System.out.println("Error."+ex);
        }
    }
    public void search_barangMasuk(){
        try{
        try (Statement statement = conn.createStatement()) {
            String sql="SELECT * FROM tb_barangMasuk WHERE `barang_kode`  LIKE '%"+cmb_barang.getSelectedItem()+"%'";
            ResultSet rs=statement.executeQuery(sql); //menampilkan data dari sql query
            if(rs.next()) // .next() = scanner method
            {
                txt_harga.setText(rs.getString(5));
                txt_stock.setText(rs.getString(6));
            }
            else{
            JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
            }
        }
        }catch (Exception ex){
            System.out.println("Error."+ex);
        }
    }
    public void delete(){
    int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
    if(ok==0){
        try{
            String sql="DELETE FROM tb_barangKeluar WHERE KodeBarang_keluar='"+kode_barangKeluar1+"'";
            java.sql.PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil di hapus");
            batal();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data gagal di hapus");
        }
        refresh();
        }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Jumlah = new javax.swing.JTextField();
        cmb_satuan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn_Proses = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        btn_delete = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Calender = new com.toedter.calendar.JDateChooser();
        btn_cek = new javax.swing.JButton();
        cmb_barang = new javax.swing.JComboBox<>();
        txt_NamaBarang = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_deskripsi = new javax.swing.JTextField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Satuan Keluar");

        jLabel4.setText("Quantity");

        cmb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Satuan--", "Unit", "Kardus", "kodi" }));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("Barang Keluar");

        btn_Proses.setText("Proses");
        btn_Proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProsesActionPerformed(evt);
            }
        });

        jLabel6.setText("Kode Barang");

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_Keluar", "Kode", "Tanggal Keluar", "Harga", "Qty", "Total"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data);

        btn_delete.setText("Hapus");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        jLabel10.setText("Tanggal Keluar");

        btn_cek.setText("Cek");
        btn_cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekActionPerformed(evt);
            }
        });

        cmb_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        cmb_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_barangActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Barang");

        jLabel2.setText("Harga");

        jLabel7.setText("Stock Barang");

        jLabel8.setText("Deskripsi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Calender, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_NamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Proses, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cek)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal)
                        .addGap(97, 381, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Calender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_NamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_deskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Proses, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cek, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProsesActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btn_ProsesActionPerformed

    private void cmb_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_barangActionPerformed
        // TODO add your handling code here:
        search_barang();
        search_barangMasuk();
    }//GEN-LAST:event_cmb_barangActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_data.getSelectedRow();
        kode_barangKeluar1 = tabel_data.getValueAt(tabel, 0).toString();
        kode1 = tabel_data.getValueAt(tabel, 1).toString();
        itempilih();

    }//GEN-LAST:event_tabel_dataMouseClicked

    private void btn_cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekActionPerformed
        // TODO add your handling code here:
        try{
            Calender.getCalendar();
            txt_Jumlah.getText();
            if(cmb_barang.getSelectedIndex()==0) throw new Exception();
            if(cmb_satuan.getSelectedIndex()==0) throw new Exception();
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane, "Input Anda Salah","WARNING",2);
        }
    }//GEN-LAST:event_btn_cekActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btn_batalActionPerformed

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
    private com.toedter.calendar.JDateChooser Calender;
    private javax.swing.JButton btn_Proses;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cek;
    private javax.swing.JButton btn_delete;
    private javax.swing.JComboBox<String> cmb_barang;
    private javax.swing.JComboBox<String> cmb_satuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextField txt_Jumlah;
    private javax.swing.JTextField txt_NamaBarang;
    private javax.swing.JTextField txt_deskripsi;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables
}
