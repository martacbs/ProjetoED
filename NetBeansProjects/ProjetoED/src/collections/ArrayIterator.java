/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayIterator<T> implements Iterator<T> {

    private int count;    
   private int current;  
   private T[] items;

    
   public ArrayIterator (T[] collection, int size)
   {
      items = collection;
      count = size;
      current = 0;
   }

    @Override
    public boolean hasNext() {
        return (current < count);
    }

    @Override
    public T next() {
        if (! hasNext())
         throw new NoSuchElementException();

 	  current++;
 	  
      return items[current - 1]; 

    }
}
