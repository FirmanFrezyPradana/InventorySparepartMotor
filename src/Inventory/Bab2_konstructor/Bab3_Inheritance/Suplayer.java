/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory.Bab2_konstructor.Bab3_Inheritance;
import java.util.Random;

/**
 *
 * @author icornermalang
 */
public class Suplayer {
    String nmSuplayer,kontrak,alamat,telepon,id;
//    Random Kode = new Random();
    Suplayer(){
        id = "SPL1234";
        nmSuplayer = "Suplayer Default";
        alamat = "Alamat Default";
        telepon = "Telepon Default";
        kontrak = "Kontrak Default";
    }
    void dataID(String ID){
        this.id = id;
    }
    void dataNmSuplayer(String NamaSuplayer){
        this.nmSuplayer = NamaSuplayer;
    }
    void dataKontrak(String Kontrak){
        this.kontrak = Kontrak;
    }
    void dataAlamat(String Alamat){
        this.alamat = Alamat;
    }
    void dataTelepon(String Telepon){
        this.telepon = Telepon;
    }
    String CetakNmSuplayer(){
        return nmSuplayer;
    }
    String CetakKontrak(){
        return kontrak;
    }
    String CetakAlamat(){
        return alamat;
    }
    String CetakTelepon(){
        return telepon;
    }
    String CetakID(){
        return id;
    }

   
}
