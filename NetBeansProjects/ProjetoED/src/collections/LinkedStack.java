/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import recursos.exceptions.EmptyCollectionException;
import recursos.interfaces.collections.QueueADT;
import recursos.interfaces.collections.StackADT;


public class LinkedStack<T> implements StackADT<T>{

    private int count;  // indicates the next open slot
    private LinearNode<T> first; 
  
    public LinkedStack(){
    count = 0;
    first = null;
  }

    
    @Override
    public void push(T t) {
        LinearNode<T> newnode = new LinearNode<T> (t);

    newnode.setNext(first);
    first = newnode;
    count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()==true) {
            throw new EmptyCollectionException("Not supported yet.");
        }
        
        LinearNode<T> result = first;
        first = first.getNext();
        count--;
        
        return result.getElement();
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty()==true){
            throw new EmptyCollectionException("Not supported yet.");
        }
        return first.getElement();
    }

    @Override
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LinearNode<T> getFirst() {
        return first;
    }

    public void setFirst(LinearNode<T> first) {
        this.first = first;
    }
    
    
}
