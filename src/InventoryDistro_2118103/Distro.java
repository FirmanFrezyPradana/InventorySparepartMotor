/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryDistro_2118103;

/**
 *
 * @author alx
 */
public class Distro extends Inventory implements Quantity{
    private int jml_stok;
    public int keuntungan, quantity;
    public Distro(){
        this.keuntungan = 15000;
    }
    @Override
    public void setStok(int Stok){
        this.jml_stok = Stok;
    }
    @Override
    public int getStok(){
        return jml_stok;
    }
    @Override
    public int getTotal(){
        return jml_stok*harga;
    }
    public void setHarga(int Harga){
        this.harga = Harga+keuntungan;
    }
}
