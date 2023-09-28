/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract;

import java.util.Random;



/**
 *
 * @author icornermalang
 */
public class BarangKeluar extends BarangMasuk{
    private int TotHargaBarang;
    private int inpurUser,cekSatuan;
    int jum_BarangKeluar;
    int UpdateStock;
    
    @Override
    public int Kode(){
        return kdBarang;
    }
    @Override
    public String NmBarang(String NmBarang){
        this.NmBarang = NmBarang;
        return NmBarang;
    }

    public int getInpurUser() {
        return inpurUser;
    }

    public int getCekSatuan() {
        return cekSatuan;
    }

    public void setInpurUser(int inpurUser,int cekSatuan) {
        this.inpurUser = inpurUser;
        this.cekSatuan = cekSatuan;

    }
    protected int UpdateStock(int pilih ,int jumlah){
        if(pilih == 1){
            UpdateStock= getJumlah() - jumlah;
        }else if(pilih == 2){
            UpdateStock = getJumlah() - (jumlah * 12);
        }else if(pilih == 3){
            UpdateStock = getJumlah()- (jumlah * 24);
        }
        jumlah();
        return UpdateStock;
    }
    protected int jumlah(){
        return UpdateStock;
    }
    protected int jumlah(int pilih , int jumlah){
        if(pilih == 1){
            jum_BarangKeluar= jumlah;
        }else if(pilih == 2){
            jum_BarangKeluar = jumlah * 12;
        }else if(pilih == 3){
            jum_BarangKeluar = jumlah * 24;
        }
        return jum_BarangKeluar;
    }
    
    protected int jumlah(int pilih,int harga,int jumlah_beli){
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
