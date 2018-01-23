/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import recursos.interfaces.IComida;

/**
 *
 * @author martasantos
 */
public class Comida implements IComida{

    private int id_comida;
    private int tamanho_comida;

    public Comida(int id_comida, int tamanho_comida) {
        this.id_comida = id_comida;
        this.tamanho_comida = tamanho_comida;
    }
    
   @Override
    public int getId() {
       return id_comida;
    }

    @Override
    public void setId(int i) {
        this.id_comida=id_comida;
    }

    @Override
    public int getTamanho() {
        return tamanho_comida;
    }

    @Override
    public void setTamanho(int i) {
        this.tamanho_comida=tamanho_comida;
    }

    @Override
    public String toString() {
        return "Comida{" + "id_comida=" + id_comida + ", tamanho_comida=" + tamanho_comida + '}';
    }
    
    
}
