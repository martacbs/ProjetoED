/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Iterator;
import recursos.exceptions.ElementNotFoundException;
import recursos.interfaces.collections.GraphADT;

/**
 *
 * @author vieir
 */
public class Graph<T> implements GraphADT<T>
{
   protected final int DEFAULT_CAPACITY = 10;
   protected int numVertices;   // number of vertices in the graph
   protected boolean[][] adjMatrix;   // adjacency matrix
   protected T[] vertices;   // values of vertices
    
    
    @Override
    public void addVertex(T t) {
  if (numVertices == vertices.length)
         expandCapacity();

      vertices[numVertices] = t;
      for (int i = 0; i <= numVertices; i++)
      {
         adjMatrix[numVertices][i] = false;
         adjMatrix[i][numVertices] = false;
      }      
      numVertices++;    }
    
       protected void expandCapacity()
   {
      T[] largerVertices = (T[])(new Object[vertices.length*2]);
      boolean[][] largerAdjMatrix = 
            new boolean[vertices.length*2][vertices.length*2];

      for (int i = 0; i < numVertices; i++)
      {
         for (int j = 0; j < numVertices; j++)
         {
            largerAdjMatrix[i][j] = adjMatrix[i][j];
         }
         largerVertices[i] = vertices[i];
      }

      vertices = largerVertices;
      adjMatrix = largerAdjMatrix;
   }

    @Override
    public void removeVertex(T t) throws ElementNotFoundException {
  for (int i = 0; i < numVertices; i++)
      {
         if (t.equals(vertices[i]))
         {
            removeVertex(i);
            return;
         }
        
      } 
    }

    @Override
    public void addEdge(T t, T t1) throws ElementNotFoundException {
    addEdge (getIndex(t), getIndex(t1));
    }

    @Override
    public void removeEdge(T t, T t1) throws ElementNotFoundException {
      removeEdge (getIndex(t), getIndex(t1));
    }

    @Override
    public Iterator iteratorBFS(T t) {
 return iteratorBFS(getIndex(t)); }

    @Override
    public Iterator iteratorDFS(T t) {
 return iteratorDFS(getIndex(t));  }

    @Override
    public Iterator iteratorShortestPath(T t, T t1) {
return iteratorShortestPath(getIndex(t), 
                                  getIndex(t1));  }

    @Override
    public boolean isEmpty() {
return (numVertices == 0);  }

    @Override
    public boolean isConnected() {
if (isEmpty())
         return false;
      
      Iterator<T> it = iteratorBFS(0);
      int count = 0;

      while (it.hasNext())
      {
         it.next();
         count++;
      }
      return (count == numVertices);  }

    @Override
    public int size() {
 return numVertices;
    }

    @Override
    public T[] getVertices() {
Object[] vertices = new Object[numVertices];
      Object vertex;
      
      for (int i = 0; i < numVertices; i++)
      {
         vertex = this.vertices[i];
         vertices[i] = vertex;
      }
      return (T[]) vertices;
   }  
}
  

