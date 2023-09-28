/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryDistro_2118103;

/**
 *
 * @author alx
 */
public abstract class Inventory {
    String Nama, lokasi, bahan, tipe;
    int harga;
    public abstract void setHarga(int Harga);
    public abstract int getTotal();
    public void setTipe(String Tipe){
        this.tipe = Tipe;
    }
    public String getTipe(){
        return tipe;
    }
    public void setNama(String nama){
        this.Nama = nama;
    }
    public String getNama(){
        return Nama;
    }
    public void setBahan(String Bahan){
        this.bahan = Bahan;
    }
    public String getBahan(){
        return bahan;
    }
    public int getHarga(){
        return harga;
    }
}
