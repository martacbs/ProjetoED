/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

/**
 *
 * @author martasantos
 */
class BinaryTreeNode<T> {
    protected T element;
   protected BinaryTreeNode<T> left, right;
   
    BinaryTreeNode (T obj) 
   {
      element = obj;
      left = null;
      right = null;
   }

   public int numChildren(){
      int children = 0;

      if (left != null)
         children = 1 + left.numChildren();

      if (right != null)
         children = children + 1 + right.numChildren();

      return children;
   }
}
