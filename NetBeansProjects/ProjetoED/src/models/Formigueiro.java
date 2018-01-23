/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import collections.ArrayUnorderedList;
import collections.Network;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import recursos.exceptions.ElementNotFoundException;
import recursos.interfaces.IComida;
import recursos.interfaces.IFormiga;
import recursos.interfaces.IFormigueiro;
import recursos.interfaces.IPair;
import recursos.interfaces.IProcessamento;
import recursos.interfaces.ISala;
import recursos.interfaces.ISilo;
import recursos.interfaces.ITunel;

/**
 *
 * @author martasantos
 */
public class Formigueiro implements IFormigueiro{

    private Sala entrada_formigueiro;
    private int idtunel;
    private ArrayUnorderedList<Sala> salas;
    private ArrayUnorderedList<Formiga> formigas;
    private Network<ISala> network;

    public Formigueiro(Sala entrada_formigueiro) {
        this.entrada_formigueiro = entrada_formigueiro;
        this.idtunel = 0;
        salas = new ArrayUnorderedList<>();
        formigas = new ArrayUnorderedList<>();
        this.network = new Network<>();
        
        this.salas.addToRear(entrada_formigueiro);
        
       // this.network.addVertex(getListaSala(entrada_formigueiro.getId()));
        
      
                
    }

    
    
  
    @Override
    public ISala getEntrada() {
        return this.entrada_formigueiro;
    }

    @Override
    public void setEntrada(ISala isala) {
        this.entrada_formigueiro = entrada_formigueiro;
         }

    @Override
    public Iterator<ISala> iterator() {
        return (Iterator<ISala>) this.salas.getIterator();
    
    }

    @Override
    public Iterator<ISala> iteratorBFS(ISala isala) {
        return network.iteratorBFS(isala);
    }

    @Override
    public Iterator<ISala> iteratorBFS() {
        return network.iteratorBFS(entrada_formigueiro);
    }

    @Override
    public void addSala(ISala isala) {
        
    }

    @Override
    public void ligaSala(ISala isala, ISala isala1, int i) {
        
        int distancia = (int) Math.hypot(isala.getX() - isala1.getX(), isala.getY()-isala1.getY());
        Tunel tunel = new Tunel(this.idtunel, distancia, i);
    
        try {
            this.network.addEdge(isala1, isala1, tunel);
            this.idtunel++;
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Formigueiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ISala getListaSala(int j){
        
        Iterator<ISala> salasf = (Iterator<ISala)this.salas.getIterator();
        
        if(salasf.hasNext()){
            ISala next = salasf.next();
            if(j==next.getId()){
                return next;
            }
        }
        return null;
    }

    @Override
    public int getMaxY() {
        int maxY=0;
       for(int i=0; i<salas.getY(); i++){
           
           if(salas.getY()>maxY){
               maxY=salas.getY();
               
           }
          
       }
        return maxY;
    }

    @Override
    public int getMaxX() {
   int maxX=0;
       for(int i=0; i<salas.getX(); i++){
           
           if(salas.getX()>maxX){
               maxX=salas.getX();
               
           }
          
       }
        return maxX;
    }

    @Override
    public Iterator<IPair<ISala, ITunel>> ligacoesDe(ISala isala) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISala getSalaFormiga(int i) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IFormiga getFormiga(int i) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISala getSala(int i) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean vizinhos(ISala isala, ISala isala1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<ISala> iteratorShortestPath(int i, int i1) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<ISala> iteratorMoveFormigaShortestPath(int i, int i1) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<ISala> iteratorCarregaEMoveFormigaShortestPath(int i, int i1) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int custoDoCaminho(Iterator<ISala> itrtr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IFormiga criaFormiga(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IComida criaComida(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISala criaSala(int i, String string, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISilo criaSilo(int i, String string, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IProcessamento criaProcessamento(int i, String string, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
}
