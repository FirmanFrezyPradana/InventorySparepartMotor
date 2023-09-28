/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryDistro_2118103;

/**
 *
 * @author alx
 */
public class Main {
    public static void main(String[] args) {
        Distro D = new Distro();
        D.setStok(24);
        D.setHarga(65000);
        System.out.println("DATA STOK");
        System.out.println("----------");
        System.out.println("Jumlah Stok :\t" + D.getStok());
        System.out.println("Harga :\t"+D.getHarga());
        System.out.println("Jumlah Total :\t"+D.getTotal());
    }
}
