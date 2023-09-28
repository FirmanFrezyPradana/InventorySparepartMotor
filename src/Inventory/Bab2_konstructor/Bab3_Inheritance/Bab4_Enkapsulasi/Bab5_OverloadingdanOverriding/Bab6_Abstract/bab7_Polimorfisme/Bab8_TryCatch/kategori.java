/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch;
import Inventory.Bab2_konstructor.Bab3_Inheritance.Bab4_Enkapsulasi.Bab5_OverloadingdanOverriding.Bab6_Abstract.bab7_Polimorfisme.Bab8_TryCatch.Bab9_Interface.*;

/**
 *
 * @author icornermalang
 */
public class kategori {
    public String KDsuplayer;
    public String Perusahaan;
    public int Tlp;
    public String alamat;
    
    public void Kode( String kode){
        this.KDsuplayer = kode;
    }
    public void Perusahaan(String NmPerusahaan){
        this.Perusahaan = NmPerusahaan;
    }
    public void Alamat(String Alamat){
        this.alamat = Alamat;
    }
    public void tlp(int tlp){
        this.Tlp = tlp;
    }
    
}
