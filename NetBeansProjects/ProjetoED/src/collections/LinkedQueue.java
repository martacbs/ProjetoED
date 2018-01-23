/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import recursos.exceptions.EmptyCollectionException;
import recursos.interfaces.collections.QueueADT;

public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinearNode<T> front, rear;

    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    @Override
    public void enqueue(T t) {
        LinearNode<T> newnode = new LinearNode<T>(t);

        if(count!=0){
            rear.setNext(newnode);
            rear=newnode;
        }else{
            front=newnode;
            rear=newnode;
        }
        count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }else{
        
        T result = front.getElement();
        front = front.getNext();
        count--;
        return result;
        } 
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue empty");
        }
        return front.getElement();
    }
    
    public T last(){
       if (isEmpty()) {
            throw new EmptyCollectionException("queue empty");
        }
       return rear.getElement();
    }

    @Override
    public boolean isEmpty() {
        if(count==0){
        return true;
        }else{
            return false;
        }
    }

    @Override
    public int size() {
        return count;
    }

}
