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
public class Barang extends Abstract_KodeBrng{
    protected int kdBarang;
    protected String NmBarang;
    protected String Kategori;
    protected String ForMotor;
    protected String Suplayer;
    protected int harga;
    
    @Override
    public int Kode(){
        Random rndm = new Random();
        kdBarang = rndm.nextInt(100000);
        return kdBarang;
    }
    @Override
    public String NmBarang(String NmBarang){
        this.NmBarang = NmBarang;
        return NmBarang;
    }
    Barang(){
        kdBarang = 123456 ;
        NmBarang = "Kampas Rem YSP";
        ForMotor = "Veza,CB,CBR 150";
        Suplayer= "PT. YSP";
        harga = 35000;
    }

    public String Kategori(String Kategori){
        this.Kategori = Kategori;
        return Kategori;
    }
    public String ForMotor(String ForMotor){
        this.ForMotor = ForMotor;
        return ForMotor;
    }
    public String Suplayer(String Suplayer){
        this.Suplayer = Suplayer;
        return Suplayer;
    }
    public int Harga(int harga){
        this.harga = harga;
        return harga;
    }
    
}
