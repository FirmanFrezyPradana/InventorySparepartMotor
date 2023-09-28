/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryDistro_2118103;

/**
 *
 * @author alx
 */
public class Invoice extends Vendor {
    private String client;
    public void setClient(String Client){
        this.client = Client;
    }
    public String getClient(){
        return client;
    }
    @Override
    public void setHarga(int Harga){
        harga = Harga;
    }
    public int getTotal(){
        return getJmlPesanan()*getHarga();
    }
}
