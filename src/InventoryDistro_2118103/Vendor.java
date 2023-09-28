/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryDistro_2118103;

/**
 *
 * @author alx
 */
public class Vendor extends Distro {
    public String ukuran;
    private int jml_pesanan;
    Vendor(){
        this.Nama = "JAGUAR SCREEN PRINTING";
        this.lokasi = "JOGJA";
        this.jml_pesanan = 12;
    }
    Vendor(String nama_vendor, String lokasi){
        this.Nama = nama_vendor;
        this.lokasi = lokasi;
        this.jml_pesanan = 12;
    }
    public void setJmlPesanan(int Jumlah){
        this.jml_pesanan = Jumlah;
    }
    public int getJmlPesanan(){
        return jml_pesanan;
    }
    @Override
    public void setHarga(int Harga){
        this.harga = Harga+keuntungan;
    }
}
