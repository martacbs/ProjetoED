/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import recursos.interfaces.ITunel;

/**
 *
 * @author martasantos
 */
public class Tunel implements ITunel{

    private int id_tunel;
    private int comprimento;
    private int raio;

    public Tunel(int id_tunel, int comprimento, int raio) {
        this.id_tunel = id_tunel;
        this.comprimento = comprimento;
        this.raio = raio;
    }
    
    @Override
    public int getDistance() {
        return comprimento;
    }

    @Override
    public void setDistance(int i) {
        this.comprimento = comprimento;
    }

    @Override
    public int getRadious() {
        return raio;
    }

    @Override
    public void setRadious(int i) {
        this.raio=raio;
    }

    @Override
    public int getId() {
        return id_tunel;
    }

    @Override
    public void setId(int i) {
        this.id_tunel = id_tunel;
    }
    
    
}
