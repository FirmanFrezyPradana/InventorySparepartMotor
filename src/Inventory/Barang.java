/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;
import java.util.Random;
/**
 *
 * @author icornermalang
 */
public class Barang {
    String NmBarang,Kategori,ForMotor,Suplayer;
    int Harga,kdBarang;
    
    int Kode(){
        Random rndm = new Random();
        kdBarang = rndm.nextInt(100000);
        return kdBarang;
    }
    void dataNmBarang(String NmBarang){
        this.NmBarang = NmBarang;
    }
    void dataKategori(String Kategori){
        this.Kategori = Kategori;
    }
    void dataForMotor(String ForMotor){
        this.ForMotor = ForMotor;
    }
    void dataSuplayer(String Suplayer){
        this.Suplayer = Suplayer;
    }
    int dataHarga(int Harga){
        this.Harga = Harga;
        return Harga;
    }
    String CetakNmBarang(){
        return NmBarang;
    }
    String CetakKategori(){
        return Kategori;
    }
    String CetakForMotor(){
        return ForMotor;
    }
    String CetakSuplayer(){
        return Suplayer;
    }
    int CetakHarga(){
        return Harga;
    }
    
}
