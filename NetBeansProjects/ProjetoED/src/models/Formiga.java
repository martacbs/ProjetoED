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
import collections.ArrayUnorderedList;
import java.util.Iterator;
import recursos.interfaces.collections.UnorderedListADT;

/**
 *
 * @author martasantos
 */
public class Formiga implements IFormiga{
    
    private int id_formiga;
    private int capacidade_maxima;
    private int carga_formiga;
    private UnorderedListADT<IComida> comida;

    public Formiga(int id_formiga, int capacidade_maxima, Comida comida) {
        this.id_formiga = id_formiga;
        this.capacidade_maxima = capacidade_maxima;
        this.carga_formiga = 0;
        this.comida = new collections.ArrayUnorderedList<>();
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

    public int getCarga_formiga() {
        return carga_formiga;
    }

    public void setCarga_formiga(int carga_formiga) {
        this.carga_formiga = carga_formiga;
    }

    public UnorderedListADT<IComida> getComida() {
        return comida;
    }

    public void setComida(UnorderedListADT<IComida> comida) {
        this.comida = comida;
    }
    

    @Override
    public void addComida(IComida ic) throws FormigaCheiaException {
       this.comida.addToRear(ic);
        if(this.carga_formiga >= this.capacidade_maxima){
            throw new  FormigaCheiaException();
        }
    }

    @Override
    public IComida removeComida(int i) throws EmptyCollectionException, ElementNotFoundException {
        Comida  comida = (Comida) this.getComida();
        if(this.carga_formiga ==0){
            throw new EmptyCollectionException("Formiga sem carga");
        }
        if(i != comida.getId()){
            throw new ElementNotFoundException("Não existe esta comida nesta formiga");
        }
            
        return this.comida.remove(comida);
    }

    @Override
    public IComida removeComida() throws EmptyCollectionException {
        return this.comida.removeFirst();
                
    }

    @Override
    public int getCarga() {
           return this.carga_formiga;
         }   

    @Override
    public String toString() {
        return "Formiga{" + "id_formiga=" + id_formiga + ", capacidade_maxima=" + capacidade_maxima + ", carga_formiga=" + carga_formiga + ", comida=" + comida + '}';
    }
    
    
}
