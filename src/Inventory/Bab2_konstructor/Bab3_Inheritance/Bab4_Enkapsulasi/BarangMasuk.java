/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi;


/**
 *
 * @author icornermalang
 */
public class BarangMasuk extends Barang{
    protected int harga_jual;
    protected int jumlah;
    protected int harga_suplayer;
    public BarangMasuk(){
        harga_suplayer = 45000;
        jumlah = 200;
    }
    protected int HargaJual(int harga){
        this.harga_jual = harga;
        return harga;
    }
    protected int Jumlah(int pilih,int jumlah){
        if(pilih == 1){
            jumlah = jumlah;
        }else if(pilih == 2){
            jumlah = jumlah * 12;
        }else if(pilih == 3){
            jumlah = jumlah * 24;
        }
        return jumlah;
    } 
    
}
