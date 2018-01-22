/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import recursos.exceptions.ElementNotFoundException;
import recursos.exceptions.EmptyCollectionException;
import recursos.interfaces.collections.UnorderedListADT;

/**
 *
 * @author martasantos
 */
class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{

    @Override
    public void addToFront(T t) {
        if (size() == list.length)
         expandCapacity();

      for (int scan=rear; scan > 0; scan--)
         list[scan] = list[scan-1];

      list[0] = t;
      rear++;
    }

    @Override
    public void addToRear(T t) {
        if (size() == list.length)
         expandCapacity();

      list[rear] = t;
      rear++;
    }

    @Override
    public void addAfter(T t, T t1) throws ElementNotFoundException {
        if (size() == list.length)
         expandCapacity();

      int scan = 0;
      while (scan < rear && !t1.equals(list[scan])) 
          scan++;
      
      if (scan == rear)
         throw new ElementNotFoundException ("list");
    
      scan++;
      for (int scan2=rear; scan2 > scan; scan2--)
         list[scan2] = list[scan2-1];

      list[scan] = t;
      rear++;
   }
}

    @Override
    public T removeFirst() throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(T t) throws ElementNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T first() throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T last() throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
