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
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      inorder (root, tempList);
      
      return tempList.iterator();
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
       ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      preorder (root, tempList);
      
      return tempList.iterator();
              }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      postorder (root, tempList);
      
      return tempList.iterator();
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
                       new ArrayUnorderedList<BinaryTreeNode<T>>();
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      BinaryTreeNode<T> current;

      nodes.addToRear (root);
      
      while (! nodes.isEmpty()) 
      {
         current = (BinaryTreeNode<T>)(nodes.removeFirst());
         
         if (current != null)
         {
            tempList.addToRear(current.element);
            if (current.left!=null)
               nodes.addToRear (current.left);
            if (current.right!=null)
               nodes.addToRear (current.right);
         }
         else
            tempList.addToRear(null);
      }
      
      return tempList.iterator();
   }


    private BinaryTreeNode<T> findAgain(T t, BinaryTreeNode<T> root) {
        if (root == null)
         return null;
      
      if (root.element.equals(t))
         return root;
      
      BinaryTreeNode<T> temp = findAgain(t, root.left);
      
      if (temp == null)
         temp = findAgain(t, root.right);
      
      return temp;}

    private void inorder(BinaryTreeNode<T> root, ArrayUnorderedList<T> tempList) {
         if (root != null)
      {
         inorder (root.left, tempList);
         tempList.addToRear(root.element);
         inorder (root.right, tempList);
      }
    }

    private void preorder(BinaryTreeNode<T> root, ArrayUnorderedList<T> tempList) {
        if (root != null)
      {
         tempList.addToRear(root.element);
         preorder (root.left, tempList);
         preorder (root.right, tempList);
      } }

    private void postorder(BinaryTreeNode<T> root, ArrayUnorderedList<T> tempList) {
        if (root != null)
      {
         postorder (root.left, tempList);
         postorder (root.right, tempList);
         tempList.addToRear(root.element);
      }
    }   
}
