/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch;

import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.*;
import java.util.Random;


/**
 *
 * @author icornermalang
 */
public class BarangMasuk extends Barang{
    protected int harga_jual;
    protected int harga_suplayer;
    private int jumlah;
    private int inputUser,cekSatuan;
    private String tanggal;
    
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
    
    public BarangMasuk(){
        harga_suplayer = 45000;
        jumlah = 200;
    }
    
    //getter hasil jml barang
    public int getJumlah() {
        return jumlah;
    }

//    setter dan getter input barang
    public int getInputUser() {
        return inputUser;
    }
    public void setInputUser(int cekSatuan,int inputUser) {
        this.inputUser = inputUser;
        this.cekSatuan = cekSatuan;
        CekSatuan();
    }
    
    public int CekSatuan() {
        if(cekSatuan == 1){
            jumlah = inputUser; 
        }else if(cekSatuan == 2){
            jumlah = inputUser * 12;
        }else if(cekSatuan == 3){
            jumlah = inputUser * 24;
        }
        return jumlah;
    }
    protected int HargaJual(int harga){
        this.harga_jual = harga;
        return harga;
    }  
    protected int HargaSuplayer(int hargaspy){
        this.harga_suplayer = hargaspy;
        return hargaspy;
    } 

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
}
