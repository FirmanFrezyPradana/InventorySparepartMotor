/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author icornermalang
 */
public class coba1 {
    static int myStaticVariable = 10;

    public static void main(String[] args) {
        // Akses atribut statis
        System.out.println("Nilai atribut statis: " + coba1.myStaticVariable);

        // Ubah nilai atribut statis
        coba1.myStaticVariable = 20;

        // Sekarang nilai atribut statis telah berubah
        System.out.println("Nilai atribut statis setelah perubahan: " + coba1.myStaticVariable);
    }
}
