/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.Bab10_Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        tampil();
        tampil_barang();
    }
    public Connection conn;
    public void batal(){
        cmb_barang.setSelectedItem(0);
        txt_HargaSuplayer.setText(" ");
        txt_HargaJual.setText(" ");
        txt_Jumlah.setText(" ");
    }
        
    String KdBarang1 , tanggal1;
    int harga_Spy1,harga_Jual1,Qty1;
    
    public void refresh(){
    new GUI_BarangMasuk ().setVisible(true);
    this.setVisible(false);
    }
    
    public void itempilih(){
            cmb_barang.setSelectedItem(KdBarang1);
            cmb_barang.setEnabled(false);
            Calender.setDateFormatString(tanggal1);
            txt_HargaSuplayer.setText(Integer.toString(harga_Spy1));
            txt_HargaJual.setText(Integer.toString(harga_Jual1));
            txt_Jumlah.setText(Integer.toString(Qty1));
    }

    public void koneksi() throws SQLException {
        try {
           conn=null;
           Class.forName("com.mysql.jdbc.Driver");
           conn= DriverManager.getConnection("jdbc:mysql://localhost/InvetorySparepartMotor?user=root&password=");
        }
        catch (ClassNotFoundException ex){
            Logger.getLogger(GUI_BarangMasuk.class.getName()).log(Level.SEVERE,null, ex);
        }
        catch (SQLException e) {
             Logger.getLogger(GUI_BarangMasuk.class.getName()).log(Level.SEVERE,null, e);
        }
        catch (Exception es) {
            Logger.getLogger(GUI_BarangMasuk.class.getName()).log(Level.SEVERE,null, es);

        }
    }
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("KODE");
        tabelhead.addColumn("TanggaL Masuk");
        tabelhead.addColumn("Nm Barang");
        tabelhead.addColumn("Suplayer");
        tabelhead.addColumn("Harga Awal");
        tabelhead.addColumn("Harga Jual");
        tabelhead.addColumn("Stock Barang");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_barangMasuk INNER JOIN tb_barang ON tb_barang.Kode_barang = tb_barangMasuk.barang_kode;";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(9), 
                    res.getString(11), res.getString(4), res.getString(5),res.getString(6),});
            }
            tabel_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void tampil_barang(){
            try {
                koneksi();
                String sql = "SELECT Kode_barang FROM `tb_barang`";
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
    

    public void insert(){
        int Quntity=0;
        String KdBarang   = (String) cmb_barang.getSelectedItem();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = date.format(Calender.getDate());
        int harga_Spy = Integer.parseInt(txt_HargaSuplayer.getText());
        int harga_Jual   = Integer.parseInt(txt_HargaJual.getText());
        int qty = Integer.parseInt(txt_Jumlah.getText());
        if(cmb_satuan.getSelectedIndex() == 1){
            Quntity = qty;
        }else if(cmb_satuan.getSelectedIndex() == 2){
            Quntity = qty * 12;
        }else if(cmb_satuan.getSelectedIndex() == 3){
            Quntity = qty * 24;
        }
        try {
        koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_barangMasuk (barang_kode, tanggal_masuk, harga_suplayer,harga_jual, quantity_barang)" 
                                    +"VALUES('"+KdBarang +"','"+tanggal +"','"+harga_Spy+"','"+harga_Jual+"','"+Quntity+"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Barang!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
            
        }
        refresh();
    }
    
    public void delete(){
    int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
    if(ok==0){
        try{
            String sql="DELETE FROM tb_barangMasuk WHERE barang_kode='"+cmb_barang.getSelectedItem()+"'";
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

    public void update(){
        String HargaSuplayer  = txt_HargaSuplayer.getText();
        String HargaJual = txt_HargaJual.getText();
        String juml   = txt_Jumlah.getText();
        String Kodelama = KdBarang1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_barangMasuk SET harga_suplayer='"+HargaSuplayer+"'," + "harga_jual='"+HargaJual+"'"
                    + ",quantity_barang='"+juml+"'WHERE barang_kode = '"+Kodelama+"'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Barang Masuk!");
        } catch (Exception e) {
            System.out.println("Error : "+e);
        }
        refresh();
    }
    public void cari(){
    try{
        try (Statement statement = conn.createStatement()) {
            String sql="SELECT * FROM tb_barangMasuk WHERE `barang_kode`  LIKE '%"+txt_Search.getText()+"%'";
            ResultSet rs=statement.executeQuery(sql); //menampilkan data dari sql query
            if(rs.next()) // .next() = scanner method
            {
                cmb_barang.setSelectedItem(rs.getString(2));
                txt_HargaSuplayer.setText(rs.getString(4));
                txt_HargaJual.setText(rs.getString(5));
                txt_Jumlah.setText(rs.getString(6));
            }
            else{
            JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
            }
        }
        }catch (Exception ex){
            System.out.println("Error."+ex);
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

        jDayChooser2 = new com.toedter.calendar.JDayChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_HargaJual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_satuan = new javax.swing.JComboBox<>();
        txt_Jumlah = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_HargaSuplayer = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        Calender = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btn_cek = new javax.swing.JButton();
        cmb_barang = new javax.swing.JComboBox<>();
        Next_TabahBarang = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        txt_Search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Barang Masuk");

        jLabel6.setText("Harga Jual");

        jLabel7.setText("Satuan");

        jLabel9.setText("Rp.");

        cmb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Satuan--", "Unit", "Kardus", "kodi" }));

        jLabel10.setText("Quantity");

        jLabel12.setText("Harga Suplayer");

        jLabel13.setText("Rp.");

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        jLabel3.setText("Kode/Nama");

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "KODE", "Tanggal Masuk", "Nm Barang", "Suplayer", "Harga Awal", "Harga Jual", "Stock Barang"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data);

        btn_update.setText("Ubah");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

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

        jLabel8.setText("Tanggal masuk");

        btn_cek.setText("Cek");
        btn_cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekActionPerformed(evt);
            }
        });

        cmb_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Barang--" }));

        Next_TabahBarang.setText("+ Tambah Barang");
        Next_TabahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Next_TabahBarangActionPerformed(evt);
            }
        });

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cari))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_HargaSuplayer)
                                    .addComponent(txt_HargaJual)
                                    .addComponent(cmb_satuan, 0, 177, Short.MAX_VALUE)
                                    .addComponent(txt_Jumlah)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Calender, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(cmb_barang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cek, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_update)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete)
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Next_TabahBarang))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cek, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Next_TabahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmb_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(Calender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_HargaSuplayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_HargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Jumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cari)
                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        insert();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekActionPerformed
        // TODO add your handling code here:
        try{
            if(cmb_barang.getSelectedIndex()==0) throw new Exception();
            Calender.getDateFormatString();
            txt_HargaSuplayer.getText();
            txt_HargaJual.getText();
            txt_Jumlah.getText();
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane, "Input Anda Salah","WARNING",2);
        }
    }//GEN-LAST:event_btn_cekActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_data.getSelectedRow(); //0
        KdBarang1 = tabel_data.getValueAt(tabel, 0).toString();
        tanggal1 = tabel_data.getValueAt(tabel, 1).toString();
        harga_Spy1 = Integer.parseInt(tabel_data.getValueAt(tabel, 4).toString());
        harga_Jual1 = Integer.parseInt(tabel_data.getValueAt(tabel, 5).toString());
        Qty1 = Integer.parseInt(tabel_data.getValueAt(tabel, 6).toString());
        itempilih();

    }//GEN-LAST:event_tabel_dataMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void Next_TabahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Next_TabahBarangActionPerformed
        // TODO add your handling code here:
        Gui_Barang brg = new Gui_Barang();
        brg.show();
    }//GEN-LAST:event_Next_TabahBarangActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cari();
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
    private com.toedter.calendar.JDateChooser Calender;
    private javax.swing.JButton Next_TabahBarang;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cek;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_barang;
    private javax.swing.JComboBox<String> cmb_satuan;
    private com.toedter.calendar.JDayChooser jDayChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextField txt_HargaJual;
    private javax.swing.JTextField txt_HargaSuplayer;
    private javax.swing.JTextField txt_Jumlah;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
