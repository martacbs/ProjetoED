package collections;

import java.util.Iterator;
import recursos.exceptions.ElementNotFoundException;
import recursos.exceptions.EmptyCollectionException;
import recursos.interfaces.collections.BinaryTreeADT;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
   protected BinaryTreeNode<T> root;
   
   public LinkedBinaryTree() 
   {
      count = 0;
      root = null;
   }

   public LinkedBinaryTree (T element) 
   {
      count = 1;
      root = new BinaryTreeNode<T> (element);
   }

    @Override
    public T getRoot() throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
       return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T t) {
        T temp;
      boolean found = false;
      
      try 
      {
         temp = find (t);
         found = true;
      }
      catch (Exception ElementNotFoundException) 
      {
         found = false;
      }
      
      return found;
    }

    @Override
    public T find(T t) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain( t, root );
      
      if( current == null )
         throw new ElementNotFoundException("binary tree");
      
      return (current.element);
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private BinaryTreeNode<T> findAgain(T t, BinaryTreeNode<T> root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
