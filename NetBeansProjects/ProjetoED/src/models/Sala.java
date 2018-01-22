/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import recursos.exceptions.ElementNotFoundException;
import recursos.exceptions.EmptyCollectionException;
import recursos.interfaces.IFormiga;
import recursos.interfaces.ISala;
import recursos.interfaces.collections.UnorderedListADT;

/**
 *
 * @author martasantos
 */
public class Sala implements ISala{

    private int id_sala;
    private String descricao_sala;
    private int x,y;

    public Sala(int id_sala, String descricao_sala, int x, int y) {
        this.id_sala = id_sala;
        this.descricao_sala = descricao_sala;
        this.x = x;
        this.y = y;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IFormiga saiFormiga(int i) throws EmptyCollectionException, ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnorderedListADT<IFormiga> listaFormigas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}