/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author icornermalang
 */
public class Mahasiswa {
    String nim, nama, prodi, angktn;
    void dataNIM(String Nim){
        this.nim = Nim;
    }    
    void dataNama(String Nama){
        this.nama = Nama;
    }
    void dataProdi(String Prodi){
        this.prodi = Prodi;
    }
    void dataAngkatan(String Angktn){
        this.angktn = Angktn;
    }
    
    String cetakNIM(){
        return nim;
    }
    String cetakNama(){
        return nama;
    }
    String cetakProdi(){
        return prodi;
    }
    String cetakAngkatan(){
        return angktn;
    }

}