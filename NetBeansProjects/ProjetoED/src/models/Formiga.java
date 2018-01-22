/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import recursos.exceptions.ElementNotFoundException;
import recursos.exceptions.EmptyCollectionException;
import recursos.exceptions.FormigaCheiaException;
import recursos.interfaces.IComida;
import recursos.interfaces.IFormiga;

/**
 *
 * @author martasantos
 */
public class Formiga implements IFormiga{
    
    private int id_formiga;
    private int capacidade_maxima=3;
    private Comida comida;

    public Formiga(int id_formiga, int capacidade_maxima, Comida comida) {
        this.id_formiga = id_formiga;
        this.capacidade_maxima = capacidade_maxima;
        this.comida = comida;
    }

    @Override
    public int getCapacidadeCarga() {
        return capacidade_maxima;
    }

    @Override
    public void setCapacidadeCarga(int i) {
        this.capacidade_maxima=capacidade_maxima;
    }

    @Override
    public int getId() {
        return id_formiga;
    }

    @Override
    public void setId(int i) {
        this.id_formiga=id_formiga;
    }

    @Override
    public void addComida(IComida ic) throws FormigaCheiaException {
            for(int i=0; i<comida.getId(); i++){
                if(capacidade_maxima!=3){
                    this.addComida(ic);
                    capacidade_maxima++;
                }
                else{
                    throw new FormigaCheiaException();
                }
            }
        }

    @Override
    public IComida removeComida(int i) throws EmptyCollectionException, ElementNotFoundException {
        for(int j=0; j<comida.getId(); j++){
                if(capacidade_maxima==0){
                    throw new EmptyCollectionException("x");
                }
                if(i = ){
                    
                }
    }

    }

    @Override
    public IComida removeComida() throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCarga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
