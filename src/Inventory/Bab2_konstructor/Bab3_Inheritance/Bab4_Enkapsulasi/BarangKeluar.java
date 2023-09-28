/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi;


/**
 *
 * @author icornermalang
 */
public class BarangKeluar extends BarangMasuk{
    private int jml_keluar;
    private int TotHargaBarang;
    protected int barangKeluar(int jumlah){
        jml_keluar = this.jumlah - jumlah;
        return jml_keluar;
    }
  
    protected int HargaTotalBarang(int pilih,int harga,int jumlah_beli){
        if(pilih == 1){
            TotHargaBarang = harga * jumlah_beli;
        }else if(pilih == 2){
            TotHargaBarang = (jumlah_beli * 12) * harga;
        }else if(pilih == 3){
            TotHargaBarang = (jumlah_beli * 24) * harga;
        }
        return TotHargaBarang;
    }
}
