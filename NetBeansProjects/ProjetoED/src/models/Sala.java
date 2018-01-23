/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import collections.ArrayUnorderedList;
import recursos.exceptions.ElementNotFoundException;
import recursos.exceptions.EmptyCollectionException;
import recursos.interfaces.IFormiga;
import recursos.interfaces.ISala;
import recursos.interfaces.collections.UnorderedListADT;
import java.util.Iterator;

/**
 *
 * @author martasantos
 */
public class Sala implements ISala{

    private int id_sala;
    private String descricao_sala;
    private int x,y;
    private UnorderedListADT<IFormiga> formigas;

    public Sala(int id_sala, String descricao_sala, int x, int y) {
        this.id_sala = id_sala;
        this.descricao_sala = descricao_sala;
        this.x = x;
        this.y = y;
        this.formigas = new ArrayUnorderedList<>();
    }
    
    @Override
    public int getId() {
        return id_sala;
    }

    @Override
    public void setId(int i) {
        this.id_sala=id_sala;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int i) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int i) {
        this.y=y;
    }

    @Override
    public String getDescricao() {
        return descricao_sala;
    }

    @Override
    public void setDescricao(String string) {
        this.descricao_sala=descricao_sala;
    }

    @Override
    public void entraFormiga(IFormiga i) {
        this.formigas.addToRear((Formiga)i);
    }
    
    @Override
    public IFormiga saiFormiga(int i) throws EmptyCollectionException, ElementNotFoundException {
     
        if(this.formigas.isEmpty()){
            throw new EmptyCollectionException("Não há formigas nesta sala");
        } 
     
        Iterator<IFormiga> iterador = this.formigas.iterator();
        while(iterador.hasNext()){
            IFormiga formiga_a_remover = iterador.next();
            if(i ==  formiga_a_remover.getId()){
              return  this.formigas.remove(formiga_a_remover);
                
            }
        }
        throw new ElementNotFoundException("Não existe formiga com esse id");
        
         
    }

    @Override
    public UnorderedListADT<IFormiga> listaFormigas() {
        return this.formigas;
    }

    @Override
    public String toString() {
        return "Sala{" + "id_sala=" + id_sala + ", descricao_sala=" + descricao_sala + ", x=" + x + ", y=" + y + ", formigas=" + formigas + '}';
    }

    
}