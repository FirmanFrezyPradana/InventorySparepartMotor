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
public class Barang extends Abstract_KodeBrng{
    protected String kdBarang;
    protected String NmBarang;
    protected String Kategori;
    protected String ForMotor;
    protected String Suplayer;
    int harga_jual;
    int harga_suplayer;
    
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
    
    Barang(){
        kdBarang = "KZL345356467464" ;
        NmBarang = "Kampas Rem YSP";
        ForMotor = "Veza,CB,CBR 150";
        Suplayer= "PT. YSP";
    }
    public String Kategori(String Kategori){
        this.Kategori = Kategori;
        return Kategori;
    }
    public String Suplayer(String Suplayer){
        this.Suplayer = Suplayer;
        return Suplayer;
    } 
}
