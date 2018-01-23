package collections;

import recursos.exceptions.ElementNotFoundException;
import recursos.interfaces.collections.UnorderedListADT;



public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    public ArrayUnorderedList()
   {
      super();
   }

    public ArrayUnorderedList (int initialCapacity)
   {
      super(initialCapacity);
   }
   
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

    

