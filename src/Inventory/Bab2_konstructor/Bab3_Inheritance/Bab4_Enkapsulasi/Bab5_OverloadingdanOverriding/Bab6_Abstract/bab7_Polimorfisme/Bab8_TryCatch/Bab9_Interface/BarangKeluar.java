/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface;

import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.*;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.*;
import java.util.Random;


/**
 *
 * @author icornermalang
 */
public class BarangKeluar extends BarangMasuk implements PPNdangolongan{
    public int TotHargaBarang;
    private int inpurUser,cekSatuan;
    int jum_BarangKeluar;
    int UpdateStock,pajak,member;
    private String tanggalKeluar;

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }
    
    @Override
    public String Kode(String kd){
        this.kdBarang = kd;
        return kd;
    }
    @Override
    public String NmBarang(String NmBarang){
        this.NmBarang = NmBarang;
        return NmBarang;
    }
    @Override
    public String ForMotor(String ForMotor){
        this.ForMotor = ForMotor;
        return ForMotor;
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

    @Override
    public int PPN() {
        return (TotHargaBarang + 2000);
        
    }

    @Override
    public int Member(int pilih) {
        if(pilih == 0){
            member = (int) (PPN() - (TotHargaBarang *0.1));
        }
        return member;
    }
}
