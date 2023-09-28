/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InventoryDistro_2118103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alx
 */
public class GUI_DATA_VENDOR extends javax.swing.JFrame {

    int id1;
    String tipe1, bahan1, nama1, lokasi1, jumlah1, ukuran1;

    /**
     * Creates new form GUI_DATA_VENDOR
     */
    public GUI_DATA_VENDOR() {
        initComponents();
        Vendor V = new Vendor();
        input_namavendor.setText(V.Nama);
        input_lokasi.setText(V.lokasi);
        input_jmlpesanan.setText(Integer.toString(V.getJmlPesanan()));
        input_namavendor.setEnabled(false);
        input_lokasi.setEnabled(false);
        input_jmlpesanan.setEnabled(false);
        tampil();
        tampil_tipe();
    }
    public Connection conn;

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db_inventory?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_DATA_DISTRO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_DATA_DISTRO.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_DATA_DISTRO.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Id");
        tabelhead.addColumn("Nama Vendor");
        tabelhead.addColumn("Lokasi");
        tabelhead.addColumn("Tipe");
        tabelhead.addColumn("Bahan");
        tabelhead.addColumn("Jumlah Pesanan");
        tabelhead.addColumn("Ukuran");
        try {
            koneksi();
            String sql = "SELECT * FROM vendor";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            table_vendor.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void tampil_tipe() {
        try {
            koneksi();
            String sql = "SELECT DISTINCT tipe FROM distro order by tipe asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                CB_tipe.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_bahan(String tipe) {
        try {
            koneksi();
            String sql = "SELECT DISTINCT bahan FROM distro WHERE tipe = '" + tipe + "'";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                CB_bahan.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void refresh() {
        new GUI_DATA_VENDOR().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String nama_vendor = input_namavendor.getText();
        String lokasi = input_lokasi.getText();
        String Tipe = (String) CB_tipe.getSelectedItem();
        String Bahan = (String) CB_bahan.getSelectedItem();
        String JumlahPesanan = input_jmlpesanan.getText();
        String Ukuran = input_ukuran.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO vendor(nama_vendor, lokasi, tipe, bahan, jumlah_pesanan, ukuran)"
                    + "VALUES('" + nama_vendor + "','" + lokasi + "','" + Tipe + "','" + Bahan + "','" + JumlahPesanan + "','" + Ukuran + "')");
            statement.close();
            JOptionPane.showMessageDialog(rootPane, "Berhasil Memasukan Data Vendor!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        refresh();
    }

    public void update() {
        String nama_vendor = input_namavendor.getText();
        String lokasi = input_lokasi.getText();
        String Tipe = (String) CB_tipe.getSelectedItem();
        String Bahan = (String) CB_bahan.getSelectedItem();
        String JumlahPesanan = input_jmlpesanan.getText();
        String Ukuran = input_ukuran.getText();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE vendor SET nama_vendor='" + nama_vendor + "'," + "lokasi='" + lokasi + "'"
                    + ",tipe='" + Tipe + "',bahan='" + Bahan + "',jumlah_pesanan='" + JumlahPesanan + "',ukuran='" + Ukuran + "' WHERE id_pesanan ='" + id1 + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(rootPane, "Update Data Vendor!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }

    public void batal() {
        CB_tipe.setSelectedIndex(0);
        input_ukuran.setText("");
        if (CbxGantiVendor.isSelected()) {
            input_namavendor.setText("");
            input_lokasi.setText("");
        }
        if (CbxCustomPcs.isSelected()) {
            input_jmlpesanan.setText("");
        }
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM vendor WHERE id_pesanan='" + id1 + "'";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Data gagal di hapus");
            }
        }
        refresh();
    }

    public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM vendor WHERE `id_pesanan` LIKE '%" + input_cari.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql);
                //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    input_namavendor.setText(rs.getString(2));
                    input_lokasi.setText(rs.getString(3));
                    CB_tipe.setSelectedItem(rs.getString(4));
                    CB_tipe.setSelectedItem(rs.getString(5));
                    input_jmlpesanan.setText(rs.getString(6));
                    input_ukuran.setText(rs.getString(7));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }

    public void itempilih() {
        input_namavendor.setEnabled(true);
        input_lokasi.setEnabled(true);
        input_jmlpesanan.setEnabled(true);
        input_namavendor.setText(nama1);
        input_lokasi.setText(tipe1);
        CB_tipe.setSelectedItem(tipe1);
        CB_bahan.setSelectedItem(bahan1);
        input_jmlpesanan.setText(jumlah1);
        input_ukuran.setText(ukuran1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        input_namavendor = new javax.swing.JTextField();
        input_lokasi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CB_tipe = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        CB_bahan = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        input_jmlpesanan = new javax.swing.JTextField();
        CbxGantiVendor = new javax.swing.JCheckBox();
        CbxCustomPcs = new javax.swing.JCheckBox();
        input_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_vendor = new javax.swing.JTable();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_cek = new javax.swing.JButton();
        input_ukuran = new javax.swing.JTextField();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("VENDOR");

        jLabel2.setText("Nama Vendor");

        jLabel3.setText("Lokasi");

        jLabel4.setText("Tipe");

        CB_tipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tipe" }));
        CB_tipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_tipeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Bahan");

        CB_bahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Bahan" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Ukuran");

        btn_simpan.setText("SImpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Jumlah Pesanan");

        CbxGantiVendor.setText("Ganti Vendor");
        CbxGantiVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxGantiVendorActionPerformed(evt);
            }
        });

        CbxCustomPcs.setText("Custom pcs");
        CbxCustomPcs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbxCustomPcsActionPerformed(evt);
            }
        });

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        table_vendor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama Vendor", "Lokasi", "Tipe", "Bahan", "Jumlah Pesanan", "Ukuran"
            }
        ));
        table_vendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_vendorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_vendor);

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        btn_cek.setText("Cek Error");
        btn_cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CbxGantiVendor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(input_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(56, 56, 56)
                                    .addComponent(input_namavendor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CB_tipe, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CB_bahan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(input_ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input_jmlpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_simpan))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_cek)
                                .addGap(20, 20, 20)
                                .addComponent(btn_ubah)
                                .addGap(18, 18, 18)
                                .addComponent(btn_hapus)
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_cari))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CbxCustomPcs)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_batal)
                            .addComponent(btn_hapus)
                            .addComponent(btn_ubah)
                            .addComponent(btn_cek)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(input_namavendor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(input_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CB_tipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CB_bahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_jmlpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_ukuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_simpan)
                .addGap(14, 14, 14)
                .addComponent(CbxCustomPcs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CbxGantiVendor)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CB_tipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_tipeActionPerformed
        // TODO add your handling code here:
        CB_bahan.removeAllItems();
        tampil_bahan(CB_tipe.getItemAt(CB_tipe.getSelectedIndex()));
    }//GEN-LAST:event_CB_tipeActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        try {
            if (CB_tipe.getSelectedIndex() == 0) {
                throw new Exception("");
            } else {
                insert();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Tipe!");
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void CbxGantiVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxGantiVendorActionPerformed
        // TODO add your handling code here:
        input_namavendor.setEnabled(true);
        input_lokasi.setEnabled(true);
    }//GEN-LAST:event_CbxGantiVendorActionPerformed

    private void CbxCustomPcsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxCustomPcsActionPerformed
        // TODO add your handling code here:
        if (CbxCustomPcs.isSelected()) {
            input_jmlpesanan.setEnabled(true);
        }
    }//GEN-LAST:event_CbxCustomPcsActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekActionPerformed
        // TODO add your handling code here:
        try {
            if (CB_tipe.getSelectedIndex() == 0) {
                throw new Exception("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Tipe!");
        }
    }//GEN-LAST:event_btn_cekActionPerformed

    private void table_vendorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_vendorMouseClicked
        // TODO add your handling code here:
        int tabel = table_vendor.getSelectedRow();
        id1 = Integer.parseInt(table_vendor.getValueAt(tabel, 0).toString());
        nama1 = table_vendor.getValueAt(tabel, 1).toString();
        lokasi1 = table_vendor.getValueAt(tabel, 2).toString();
        tipe1 = table_vendor.getValueAt(tabel, 3).toString();
        bahan1 = table_vendor.getValueAt(tabel, 4).toString();
        jumlah1 = table_vendor.getValueAt(tabel, 5).toString();
        ukuran1 = table_vendor.getValueAt(tabel, 6).toString();
        itempilih();
    }//GEN-LAST:event_table_vendorMouseClicked

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        update();
        input_namavendor.setEnabled(false);
        input_lokasi.setEnabled(false);
        input_jmlpesanan.setEnabled(false);
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_DATA_VENDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_VENDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_VENDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_VENDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_DATA_VENDOR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_bahan;
    private javax.swing.JComboBox<String> CB_tipe;
    private javax.swing.JCheckBox CbxCustomPcs;
    private javax.swing.JCheckBox CbxGantiVendor;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cek;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JTextField input_cari;
    private javax.swing.JTextField input_jmlpesanan;
    private javax.swing.JTextField input_lokasi;
    private javax.swing.JTextField input_namavendor;
    private javax.swing.JTextField input_ukuran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_vendor;
    // End of variables declaration//GEN-END:variables
}
