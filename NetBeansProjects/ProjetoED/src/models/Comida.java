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

    public int getId_comida() {
        return id_comida;
    }

    public void setId_comida(int id_comida) {
        this.id_comida = id_comida;
    }

    public int getTamanho_comida() {
        return tamanho_comida;
    }

    public void setTamanho_comida(int tamanho_comida) {
        this.tamanho_comida = tamanho_comida;
    }
    
    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTamanho(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
