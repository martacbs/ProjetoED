/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import recursos.exceptions.EmptyCollectionException;
import recursos.interfaces.collections.StackADT;

/**
 *
 * @author martasantos
 */
public class LinkedStack<T> implements StackADT<T>{

    private int count;  // indicates the next open slot
    private LinearNode<T> top; 
   
    @Override
    public void push(T t) {
       LinearNode<T> temp = new LinearNode<T> (t);

      temp.setNext(top);
      top = temp;
      count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty())
         throw new EmptyCollectionException(" ");

      T result = top.getElement();
      top = top.getNext();
      count--;
 
      return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
         throw new EmptyCollectionException(" "); 

      return top.getElement(); 
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }
    
    
    
}
