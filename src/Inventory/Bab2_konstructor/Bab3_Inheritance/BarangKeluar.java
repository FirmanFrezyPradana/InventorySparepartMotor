 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance;

/**
 *
 * @author icornermalang
 */
public class BarangKeluar extends BarangMasuk{
    int jml_keluar,TotHargaBarang;
    int barangKeluar(int jumlah){
        jml_keluar = this.jumlah - jumlah;
        return jml_keluar;
    }
    int HargaTotalBarang(int pilih,int harga,int jumlah_beli){
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
