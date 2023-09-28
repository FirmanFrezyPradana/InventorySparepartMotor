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
public class GUI_DATA_DISTRO extends javax.swing.JFrame {

    String tipe1, bahan1, stok1, harga1, total1;
    int id1;

    /**
     * Creates new form GUI_DATA_DISTRO
     */
    public GUI_DATA_DISTRO() {
        initComponents();
        tampil();
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
        tabelhead.addColumn("Tipe");
        tabelhead.addColumn("Bahan");
        tabelhead.addColumn("Jumlah Stok");
        tabelhead.addColumn("Harga");
        tabelhead.addColumn("Total");
        try {
            koneksi();
            String sql = "SELECT * FROM distro";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),});
            }
            table_distro.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void batal() {
        input_harga.setText("");
        input_jmlStok.setText("");
        CB_tipe.setSelectedIndex(0);
        CB_bahan.setSelectedIndex(0);
    }

    public void refresh() {
        new GUI_DATA_DISTRO().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String Tipe = (String) CB_tipe.getSelectedItem();
        String Bahan = (String) CB_bahan.getSelectedItem();
        String Stok = input_jmlStok.getText();
        String harga = input_harga.getText();
        Inventory In;
        Distro D = new Distro();
        In = D;
        D.setStok(Integer.parseInt(input_jmlStok.getText()));
        In.setHarga(Integer.parseInt(input_harga.getText()));
        int total = In.getTotal();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO distro(tipe, bahan, jumlah_stok, harga, total)"
                    + "VALUES('" + Tipe + "','" + Bahan + "','" + Stok + "','" + harga + "','" + total + "')");
            statement.close();
            JOptionPane.showMessageDialog(rootPane, "Berhasil Memasukan Data Distro!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan Input!");
        }
        refresh();
    }
    public void update() {
        String Tipe = (String) CB_tipe.getSelectedItem();
        String Bahan = (String) CB_bahan.getSelectedItem();
        String Stok = input_jmlStok.getText();
        String harga = input_harga.getText();
        Inventory In;
        Distro D = new Distro();
        In = D;
        D.setStok(Integer.parseInt(input_jmlStok.getText()));
        In.setHarga(Integer.parseInt(input_harga.getText()));
        int total = In.getTotal();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE distro SET tipe='" + Tipe + "'," + "bahan='" + Bahan + "'"
                    + ",jumlah_stok='" + Stok + "',harga='" + harga + "',total='" + total + "' WHERE id ='" + id1 + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(rootPane, "Update Data Distro!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    public void delete() {
        int ok = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM distro WHERE id='" + id1 + "'";
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
                String sql = "SELECT * FROM distro WHERE `id` LIKE '%" + input_cari.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql);
                //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    CB_tipe.setSelectedItem(rs.getString(1));
                    CB_tipe.setSelectedItem(rs.getString(2));
                    input_jmlStok.setText(rs.getString(3));
                    input_harga.setText(rs.getString(4));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }
    public void itempilih() {
        CB_tipe.setSelectedItem(tipe1);
        CB_bahan.setSelectedItem(bahan1);
        input_jmlStok.setText(stok1);
        input_harga.setText(harga1);
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
        input_harga = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JToggleButton();
        CB_bahan = new javax.swing.JComboBox<>();
        CB_tipe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        input_jmlStok = new javax.swing.JTextField();
        input_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_distro = new javax.swing.JTable();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_cek = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Harga");

        input_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_hargaActionPerformed(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        CB_bahan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cotton Combed 20s", "Cotton Combed 24s", "Cotton Combed 30s" }));

        CB_tipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kaos", "Hoodie" }));
        CB_tipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_tipeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("DISTRO SOME");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Tipe");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Bahan");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Jumlah Stok");

        input_jmlStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_jmlStokActionPerformed(evt);
            }
        });

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        table_distro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tipe", "Bahan", "Jumlah Stok", "Harga", "Total"
            }
        ));
        table_distro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_distroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_distro);

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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 379, Short.MAX_VALUE)
                        .addComponent(btn_cek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_batal))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 72, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(CB_bahan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(input_jmlStok, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CB_tipe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(input_harga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_cari))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_batal)
                            .addComponent(btn_hapus)
                            .addComponent(btn_ubah)
                            .addComponent(btn_cek)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CB_tipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(CB_bahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_jmlStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(input_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_simpan)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_hargaActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void input_jmlStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_jmlStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_jmlStokActionPerformed

    private void CB_tipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_tipeActionPerformed
        // TODO add your handling code here:
        if (CB_tipe.getSelectedIndex() == 0) {
            CB_bahan.removeAllItems();
            CB_bahan.addItem("Cotton Combed 20s");
            CB_bahan.addItem("Cotton Combed 24s");
            CB_bahan.addItem("Cotton Combed 30s");
        } else {
            CB_bahan.removeAllItems();
            CB_bahan.addItem("Fleece");
            CB_bahan.addItem("Drill");
            CB_bahan.addItem("Baby Terry");
            CB_bahan.addItem("Kanvas");
        }
    }//GEN-LAST:event_CB_tipeActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekActionPerformed
        // TODO add your handling code here:
        try {
            Inventory In;
            Distro D = new Distro();
            In = D;
            D.setStok(Integer.parseInt(input_jmlStok.getText()));
            In.setHarga(Integer.parseInt(input_harga.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Textfield wajib di isi!");
        }
    }//GEN-LAST:event_btn_cekActionPerformed

    private void table_distroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_distroMouseClicked
        // TODO add your handling code here:
        int tabel = table_distro.getSelectedRow();
        id1 = Integer.parseInt(table_distro.getValueAt(tabel, 0).toString());
        tipe1 = table_distro.getValueAt(tabel, 1).toString();
        bahan1 = table_distro.getValueAt(tabel, 2).toString();
        stok1 = table_distro.getValueAt(tabel, 3).toString();
        harga1 = table_distro.getValueAt(tabel, 4).toString();
        itempilih();
    }//GEN-LAST:event_table_distroMouseClicked

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_DATA_DISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_DISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_DISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_DATA_DISTRO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_DATA_DISTRO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_bahan;
    private javax.swing.JComboBox<String> CB_tipe;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cek;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JToggleButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JTextField input_cari;
    private javax.swing.JTextField input_harga;
    private javax.swing.JTextField input_jmlStok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_distro;
    // End of variables declaration//GEN-END:variables
}
