/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author martasantos
 */
public class Formiga {
    private int id_formiga;
    private int capacidadeCarga;

    public Formiga(int id_formiga, int capacidadeCarga) {
        this.id_formiga = id_formiga;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getId_formiga() {
        return id_formiga;
    }

    public void setId_formiga(int id_formiga) {
        this.id_formiga = id_formiga;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    
}
