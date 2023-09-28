/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.Bab10_Database;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.*;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.*;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author icornermalang
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Gui_Barang extends javax.swing.JFrame {

    /**
     * Creates new form Gui_Barang
     */
    public Gui_Barang() {
        initComponents();
        tampil();
        tampil_kategori();
        tampil_suplayer();
    }
    public Connection conn;
    String kode1, nama1 , kategori1 ,suplayer1, forMotor1;
    
    public void batal(){
        Txt_KdBarang.setText(" ");
        Txt_NmBarang.setText(" ");
        txt_Deskripsi.setText(" ");
    }
    
    void itempilih(){
        Cmb_Kategori.setSelectedItem(kategori1);
        cmb_suplayer.setSelectedItem(suplayer1);
        Txt_KdBarang.setText(kode1);
        Txt_NmBarang.setText(nama1);
        txt_Deskripsi.setText(forMotor1);
    }
    public void koneksi() throws SQLException {
        try {
               conn=null;
               Class.forName("com.mysql.jdbc.Driver");
               conn= DriverManager.getConnection("jdbc:mysql://localhost/InvetorySparepartMotor?user=root&password=");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Gui_Barang.class.getName()).log(Level.SEVERE,null, ex);
        }
            catch (SQLException e) {
                 Logger.getLogger(Gui_Barang.class.getName()).log(Level.SEVERE,null, e);
        }
            catch (Exception es) {
                Logger.getLogger(Gui_Barang.class.getName()).log(Level.SEVERE,null, es);
        }
    }
    
    public void tampil_kategori(){
            try {
                koneksi();
                String sql = "SELECT Nm_Kategori FROM `tb_kategori`";
                Statement stt = conn.createStatement();
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    Object[] ob = new Object[3];
                    ob[0] = res.getString(1);
                    Cmb_Kategori.addItem((String) ob[0]);
                }
                res.close();
                stt.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
        public void tampil_suplayer(){
            try {
                koneksi();
                String sql = "SELECT nm_suplayer FROM `tb_suplayer`";
                Statement stt = conn.createStatement();
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    Object[] ob = new Object[3];
                    ob[0] = res.getString(1);
                    cmb_suplayer.addItem((String) ob[0]);
                }
                res.close();
                stt.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("KODE");
        tabelhead.addColumn("Nm Barang");
        tabelhead.addColumn("Kategori");
        tabelhead.addColumn("suplayer");
        tabelhead.addColumn("For Motor");

        try {
        koneksi();
        String sql = "SELECT * FROM tb_barang";
        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery(sql);
        while(res.next()){
        tabelhead.addRow(new Object[]{res.getString(2),res.getString(3),res.getString(4),res.getString(5), res.getString(6),});
        }
        tabel_data.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    public void refresh(){
    new Gui_Barang().setVisible(true);
    this.setVisible(false);
    }

    public void insert(){
        String Kategori    = (String) Cmb_Kategori.getSelectedItem();
        String Suplayer = (String) cmb_suplayer.getSelectedItem();
        String Kode = Txt_KdBarang.getText();
        String Nama= Txt_NmBarang.getText();
        String ForMotor = txt_Deskripsi.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_barang(Kode_barang, nm_barang, kategori_brg, suplayer_brg,for_motor)"
                                    +"VALUES('"+Kode+"','"+Nama+"','"+Kategori+"','"+Suplayer+"','"+ForMotor+"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Nilai!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    public void update(){
        String Kategori    = (String) Cmb_Kategori.getSelectedItem();
        String Suplayer = (String) cmb_suplayer.getSelectedItem();
        String Kode = Txt_KdBarang.getText();
        String Nama= Txt_NmBarang.getText();
        String ForMotor = txt_Deskripsi.getText();

        String kode_lama = kode1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_barang SET kode_barang='"+Kode+"'," + "nm_barang='"+Nama+"'"
                                    +",kategori_brg='"+Kategori+"',suplayer_brg='"+Suplayer+"',for_motor='"+ForMotor+"' WHERE  kode_barang='"+kode_lama+"'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Nilai!");
        } catch (Exception e) {
            System.out.println("Error : "+e);
        }
        refresh();
    }
    
    public void delete(){
    int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin akan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
    if(ok==0){
        try{
            String sql="DELETE FROM tb_barang WHERE Kode_barang='"+Txt_KdBarang.getText()+"'";
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
    public void cari(){
    try{
        try (Statement statement = conn.createStatement()) {
            String sql="SELECT * FROM tb_barang WHERE `Kode_barang`  LIKE '%"+txt_search.getText()+"%'";
            ResultSet rs=statement.executeQuery(sql); //menampilkan data dari sql query
            if(rs.next()) // .next() = scanner method
            {
                Txt_KdBarang.setText(rs.getString(3));
                Txt_NmBarang.setText(rs.getString(2));
                Cmb_Kategori.setSelectedItem(rs.getString(4));
                cmb_suplayer.setSelectedItem(rs.getString(5));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Txt_KdBarang = new javax.swing.JTextField();
        Txt_NmBarang = new javax.swing.JTextField();
        Cmb_Kategori = new javax.swing.JComboBox<>();
        btn_simpan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Deskripsi = new javax.swing.JTextArea();
        btn_cek = new javax.swing.JToggleButton();
        cmb_suplayer = new javax.swing.JComboBox<>();
        btn_Kategori = new javax.swing.JButton();
        btn_suplayer = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("TAMBAH BARANG");

        jLabel2.setText("KODE BARANG");

        jLabel3.setText("Deskripsi");

        jLabel4.setText("KATEGORI");

        jLabel5.setText("NAMA BARANG");

        Cmb_Kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Kategori--", " " }));

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        jLabel7.setText("SUPLAYER");

        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "KODE", "Nm Barang", "Kategori", "Suplayer", "For Motor"
            }
        ));
        tabel_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_dataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data);

        btn_update.setText("Update");
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

        txt_Deskripsi.setColumns(20);
        txt_Deskripsi.setRows(5);
        jScrollPane1.setViewportView(txt_Deskripsi);

        btn_cek.setText("Cek");
        btn_cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekActionPerformed(evt);
            }
        });

        cmb_suplayer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Suplayer--" }));

        btn_Kategori.setText("+");
        btn_Kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KategoriActionPerformed(evt);
            }
        });

        btn_suplayer.setText("+");
        btn_suplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suplayerActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel2))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Txt_NmBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                .addComponent(Txt_KdBarang))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cmb_suplayer, javax.swing.GroupLayout.Alignment.LEADING, 0, 146, Short.MAX_VALUE)
                                                    .addComponent(Cmb_Kategori, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btn_Kategori)
                                                    .addComponent(btn_suplayer)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_cek, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_update)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(355, 355, 355)
                                        .addComponent(btn_delete))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(300, 300, 300)
                                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_cari)
                                    .addComponent(btn_batal)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_KdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Txt_NmBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cmb_Kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btn_Kategori))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_suplayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btn_suplayer))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_cek, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cari)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekActionPerformed
        // TODO add your handling code here:
        try{
            Txt_KdBarang.getText();
            Txt_NmBarang.getText();
            if(Cmb_Kategori.getSelectedIndex()==0) throw new Exception();
            if(cmb_suplayer.getSelectedIndex()==0) throw new Exception();
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane, "Input Anda Salah","WARNING",2);
        }
    }//GEN-LAST:event_btn_cekActionPerformed

    private void tabel_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_dataMouseClicked
        // TODO add your handling code here:
        int tabel = tabel_data.getSelectedRow(); //0
        kode1 = tabel_data.getValueAt(tabel, 0).toString();
        nama1 = tabel_data.getValueAt(tabel, 1).toString();
        kategori1= tabel_data.getValueAt(tabel, 2).toString();
        suplayer1 = tabel_data.getValueAt(tabel, 3).toString();
        forMotor1= tabel_data.getValueAt(tabel, 4).toString();
        itempilih();
    }//GEN-LAST:event_tabel_dataMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_KategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KategoriActionPerformed
        // TODO add your handling code here:
        GUI_Kategori ktg = new GUI_Kategori();
        ktg.show();
    }//GEN-LAST:event_btn_KategoriActionPerformed

    private void btn_suplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suplayerActionPerformed
        // TODO add your handling code here:
        GUI_Suplayer spy = new GUI_Suplayer();
        spy.show();
    }//GEN-LAST:event_btn_suplayerActionPerformed

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
            java.util.logging.Logger.getLogger(Gui_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cmb_Kategori;
    private javax.swing.JTextField Txt_KdBarang;
    private javax.swing.JTextField Txt_NmBarang;
    private javax.swing.JButton btn_Kategori;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JToggleButton btn_cek;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_suplayer;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_suplayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_data;
    private javax.swing.JTextArea txt_Deskripsi;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
