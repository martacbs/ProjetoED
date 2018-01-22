/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Iterator;
import recursos.exceptions.EmptyCollectionException;
import recursos.exceptions.ProcessedException;
import recursos.interfaces.IComida;
import recursos.interfaces.IProcessamento;

/**
 *
 * @author martasantos
 */
public class SalaProcessamento extends Sala implements IProcessamento{

    public SalaProcessamento(int id_sala, String descricao_sala, int x, int y) {
        super(id_sala, descricao_sala, x, y);
    }

    @Override
    public void acrescentaComida(IComida ic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IComida getProximaComida() throws EmptyCollectionException, ProcessedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<IComida> iteratorComida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
