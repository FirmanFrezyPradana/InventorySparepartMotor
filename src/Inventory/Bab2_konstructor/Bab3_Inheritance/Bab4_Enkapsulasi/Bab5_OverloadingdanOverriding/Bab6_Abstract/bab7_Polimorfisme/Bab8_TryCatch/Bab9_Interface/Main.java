/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author icornermalang
 */
public class Main {
    public static void main(String[] args) {
        Barang brg;
        brg =  new BarangKeluar();
        BarangKeluar brgklr = (BarangKeluar) brg;
        brgklr.Kode("KVB08695-35663-6456");
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat format = new SimpleDateFormat(tampilan);
        brgklr.setTanggalKeluar(String.valueOf(format.format(01-01-1970)));
        brg.NmBarang("Vanbel Set Beat FI");
        brg.ForMotor("Beat FI");
        brg = new BarangMasuk();
        BarangMasuk brgmsk = (BarangMasuk) brg;
        brgmsk.HargaJual(145000);
        brgklr.jumlah(1, 4);
        brgklr.jumlah(1, 145000, 4);
        System.out.println("Kode Barang :"+brgklr.kdBarang);
        System.out.println("Nama Barang :"+brgklr.NmBarang);
        System.out.println("Tanggal Keluar : "+brgklr.getTanggalKeluar());
        System.out.println("Harga :" + brgmsk.harga_jual);
        System.out.println("QTY :" +brgklr.jum_BarangKeluar);
        System.out.println("Total Harga :"+brgklr.TotHargaBarang);
        System.out.println("Total Panjak :"+brgklr.PPN());
        System.out.println("Potongan Member :"+brgklr.Member(0));
    }
}
