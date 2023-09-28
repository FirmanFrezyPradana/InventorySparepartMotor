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
public class GUI_INVOICE extends javax.swing.JFrame {
    int id1;
    String client1, idpesanan1, kode1, jumlah1, tipe1, bahan1, harga1, fullkode;
    /**
     * Creates new form GUI_INVOICE
     */
    public GUI_INVOICE() {
        initComponents();
        Invoice I = new Invoice();
        jLabel1.setText(I.Nama);
        input_tipe.setEnabled(false);
        input_bahan.setEnabled(false);
        input_jmlpesanan.setEnabled(false);
        input_harga.setEnabled(false);
        tampil();
        tampil_kode_nama();
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
        tabelhead.addColumn("Client");
        tabelhead.addColumn("Kode");
        tabelhead.addColumn("Tipe");
        tabelhead.addColumn("Bahan");
        tabelhead.addColumn("Jumlah");
        tabelhead.addColumn("Harga/pcs");
        try {
            koneksi();
            String sql = "SELECT * FROM invoice";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
            }
            table_invoice.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void tampil_kode_nama() {
        try {
            koneksi();
            String sql = "SELECT nama_vendor FROM vendor order by nama_vendor asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                CB_kode.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_kode_id(String kode) {
        try {
            koneksi();
            String sql = "SELECT id_pesanan FROM vendor WHERE nama_vendor = '" + kode + "'";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                CB_idpesanan.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_tipe(String kode, String id_pesanan) {
        try {
            koneksi();
            String sql = "SELECT tipe FROM vendor WHERE nama_vendor = '" + kode + "' && id_pesanan = '" + id_pesanan + "'";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                  String tipe = res.getString("Tipe");
                  input_tipe.setText(tipe);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_bahan(String kode, String id_pesanan) {
        try {
            koneksi();
            String sql = "SELECT bahan FROM vendor WHERE nama_vendor = '" + kode + "' && id_pesanan = '" + id_pesanan + "'";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                  String bahan = res.getString("Bahan");
                  input_bahan.setText(bahan);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_jumlah(String kode, String id_pesanan) {
        try {
            koneksi();
            String sql = "SELECT jumlah_pesanan FROM vendor WHERE nama_vendor = '" + kode + "' && id_pesanan = '" + id_pesanan + "'";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                  String jumlah_pesanan = res.getString("jumlah_pesanan");
                  input_jmlpesanan.setText(jumlah_pesanan);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void tampil_harga(String tipe, String bahan) {
        try {
            koneksi();
            String sql = "SELECT harga FROM distro WHERE tipe = '" + tipe + "' && bahan = '" + bahan + "'";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                  String harga = res.getString("harga");
                  input_harga.setText(harga);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void refresh() {
        new GUI_INVOICE().setVisible(true);
        this.setVisible(false);
    }

    public void insert() {
        String client = input_client.getText();
        String kode = (String) (CB_kode.getSelectedItem() + "_" + CB_idpesanan.getSelectedItem());
        String Tipe = input_tipe.getText();
        String Bahan = input_bahan.getText();
        String JumlahPesanan = input_jmlpesanan.getText();
        String Harga = input_harga.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO invoice(client, kode, tipe, bahan, jumlah_pesanan, harga)"
                    + "VALUES('" + client + "','" + kode + "','" + Tipe + "','" + Bahan + "','" + JumlahPesanan + "','" + Harga + "')");
            statement.close();
            JOptionPane.showMessageDialog(rootPane, "Berhasil Memasukan Data Vendor!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        refresh();
    }
    
    public void update() {
        String client = input_client.getText();
        String kode = (String) (CB_kode.getSelectedItem() + "_" + CB_idpesanan.getSelectedItem());
        String Tipe = input_tipe.getText();
        String Bahan = input_bahan.getText();
        String JumlahPesanan = input_jmlpesanan.getText();
        String Harga = input_harga.getText();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE invoice SET client='" + client + "'," + "kode='" + kode + "'"
                    + ",tipe='" + Tipe + "',bahan='" + Bahan + "',jumlah_pesanan='" + JumlahPesanan + "',harga='" + Harga + "' WHERE id_invoice ='" + id1 + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(rootPane, "Update Data Vendor!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    
    public void batal() {
        input_client.setText("");
        CB_idpesanan.setSelectedIndex(0);
        CB_kode.setSelectedIndex(0);
        input_tipe.setText("");
        input_bahan.setText("");
        input_harga.setText("");
        input_jmlpesanan.setText("");
    }
    public void delete() {
        int ok = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM invoice WHERE id_invoice='" + id1 + "'";
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
                String sql = "SELECT * FROM invoice WHERE `id_invoice` LIKE '%" + input_cari.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql);
                //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    input_client.setText(rs.getString(2));
                    fullkode = rs.getString(3);
                    String[] spStg = fullkode.split("_");
                    CB_idpesanan.setSelectedItem(spStg[1]);
                    CB_kode.setSelectedItem(spStg[0]);
                    input_tipe.setText(rs.getString(4));
                    input_bahan.setText(rs.getString(5));
                    input_jmlpesanan.setText(rs.getString(6));
                    input_harga.setText(rs.getString(7));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }
    public void itempilih() {
        String[] spStg = fullkode.split("_");
        input_client.setText(client1);
        CB_idpesanan.setSelectedItem(spStg[1]);
        CB_kode.setSelectedItem(spStg[0]);
        input_jmlpesanan.setText(jumlah1);
        input_tipe.setText(tipe1);
        input_bahan.setText(bahan1);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        input_client = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        input_jmlpesanan = new javax.swing.JTextField();
        input_harga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        input_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_invoice = new javax.swing.JTable();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_cek = new javax.swing.JButton();
        input_tipe = new javax.swing.JTextField();
        input_bahan = new javax.swing.JTextField();
        CB_kode = new javax.swing.JComboBox<>();
        CB_idpesanan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("NAMA VENDOR");

        jLabel2.setText("Client");

        jLabel3.setText("Kode");

        jLabel4.setText("Tipe");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Bahan");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Jumlah Pesanan");

        input_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_hargaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel8.setText("Harga/pcs");

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        table_invoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Client", "Kode", "Tipe", "Bahan", "Jumlah", "Harga/pcs"
            }
        ));
        table_invoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_invoiceMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_invoice);

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

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_cek.setText("Cek Error");
        btn_cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekActionPerformed(evt);
            }
        });

        CB_kode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kode" }));
        CB_kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_kodeActionPerformed(evt);
            }
        });

        CB_idpesanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));
        CB_idpesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_idpesananActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input_client, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(input_jmlpesanan)
                            .addComponent(input_harga, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(btn_simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input_tipe, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(input_bahan, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CB_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CB_idpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 247, Short.MAX_VALUE)
                        .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cari))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 145, Short.MAX_VALUE)
                        .addComponent(btn_cek)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_batal))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(input_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(CB_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_idpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(input_tipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(input_bahan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input_jmlpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(input_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_simpan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_batal)
                            .addComponent(btn_hapus)
                            .addComponent(btn_ubah)
                            .addComponent(btn_cek))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_hargaActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekActionPerformed
        // TODO add your handling code here:
//        try {
//            Inventory In;
//            Invoice I = new Invoice();
//            In = I;
//            I.setClient(input_client.getText());
//            I.setJmlPesanan(Integer.parseInt(input_jmlpesanan.getText()));
//            In.setNama(input_kode.getText());
//            In.setHarga(Integer.parseInt(input_harga.getText()));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, "Textfield wajib di isi!");
//        }
    }//GEN-LAST:event_btn_cekActionPerformed

    private void CB_kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_kodeActionPerformed
        // TODO add your handling code here:
        CB_idpesanan.removeAllItems();
        tampil_kode_id(CB_kode.getItemAt(CB_kode.getSelectedIndex()));
    }//GEN-LAST:event_CB_kodeActionPerformed

    private void CB_idpesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_idpesananActionPerformed
        // TODO add your handling code here:
        tampil_tipe(CB_kode.getItemAt(CB_kode.getSelectedIndex()), CB_idpesanan.getItemAt(CB_idpesanan.getSelectedIndex()));
        tampil_bahan(CB_kode.getItemAt(CB_kode.getSelectedIndex()), CB_idpesanan.getItemAt(CB_idpesanan.getSelectedIndex()));
        tampil_jumlah(CB_kode.getItemAt(CB_kode.getSelectedIndex()), CB_idpesanan.getItemAt(CB_idpesanan.getSelectedIndex()));
        tampil_harga(input_tipe.getText(), input_bahan.getText());
    }//GEN-LAST:event_CB_idpesananActionPerformed

    private void table_invoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_invoiceMouseClicked
        // TODO add your handling code here:
        int tabel = table_invoice.getSelectedRow();
        id1 = Integer.parseInt(table_invoice.getValueAt(tabel, 0).toString());
        client1 = table_invoice.getValueAt(tabel, 1).toString();
        fullkode = table_invoice.getValueAt(tabel, 2).toString();
        tipe1 = table_invoice.getValueAt(tabel, 3).toString();
        bahan1 = table_invoice.getValueAt(tabel, 4).toString();
        jumlah1 = table_invoice.getValueAt(tabel, 5).toString();
        harga1 = table_invoice.getValueAt(tabel, 6).toString();
        itempilih();
    }//GEN-LAST:event_table_invoiceMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_INVOICE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_INVOICE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_INVOICE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_INVOICE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_INVOICE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_idpesanan;
    private javax.swing.JComboBox<String> CB_kode;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_cek;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JTextField input_bahan;
    private javax.swing.JTextField input_cari;
    private javax.swing.JTextField input_client;
    private javax.swing.JTextField input_harga;
    private javax.swing.JTextField input_jmlpesanan;
    private javax.swing.JTextField input_tipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_invoice;
    // End of variables declaration//GEN-END:variables
}
