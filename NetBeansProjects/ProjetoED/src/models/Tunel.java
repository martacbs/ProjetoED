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
public class Tunel {
    private int id_tunel;
    private float comprimento;
    private float raio;

    public Tunel(int id_tunel, float comprimento, float raio) {
        this.id_tunel = id_tunel;
        this.comprimento = comprimento;
        this.raio = raio;
    }

    public int getId_tunel() {
        return id_tunel;
    }

    public void setId_tunel(int id_tunel) {
        this.id_tunel = id_tunel;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }
    
    
}
