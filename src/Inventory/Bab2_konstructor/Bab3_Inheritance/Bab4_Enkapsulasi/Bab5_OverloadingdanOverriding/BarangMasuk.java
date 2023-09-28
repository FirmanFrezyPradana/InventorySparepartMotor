/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding;


/**
 *
 * @author icornermalang
 */
public class BarangMasuk extends Barang{
    protected int harga_jual;
    protected int harga_suplayer;
    private int jumlah;
    private int inputUser,cekSatuan;
    public BarangMasuk(){
        harga_suplayer = 45000;
        jumlah = 200;
    }  
    
    @Override
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
}
