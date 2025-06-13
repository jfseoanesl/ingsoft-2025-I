package org.example.encapsuladopormetodo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> listItemPedido;
    private String pais;

    public Pedido() {
        this.listItemPedido = new ArrayList();
    }

    public Pedido(String pais, List<ItemPedido> items) {
        this.listItemPedido=items;
        this.pais = pais;
    }

    public List<ItemPedido> getListItemPedido() {
        return listItemPedido;
    }

    public void setListItemPedido(List<ItemPedido> listItemPedido) {
        this.listItemPedido = listItemPedido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public double getTotalPedido(){

        double total = 0;
        for(ItemPedido i: this.listItemPedido){
           total += i.getTotalItem();
        }

         return total+=total* TaxProcesor.getTasaImpuesto("US");

    }





}
