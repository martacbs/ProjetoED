package collections;

import java.util.Iterator;
import models.Tunel;
import recursos.exceptions.ElementNotFoundException;
import recursos.interfaces.ITunel;
import recursos.interfaces.collections.NetworkADT;

public class Network<T> extends Graph<T> implements NetworkADT<T> {

    private ITunel[][] adjMatrix;
    
    public Network() {
        numVertices = 0;
        this.adjMatrix = new Tunel[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }
   
    @Override
    public void addEdge(T t, T t1, ITunel itunel) throws ElementNotFoundException {
        addEdge (super.getIndex(t), super.getIndex(t1), itunel);
    }
    
    @Override
    public double shortestPathWeight(T t, T t1) throws ElementNotFoundException {
        
        return shortestPathWeight(getIndex(t), getIndex(t1));
    }
    
    public void addEdge (int index1, int index2, ITunel weight){
      if (indexIsValid(index1) && indexIsValid(index2)) {
          
         adjMatrix[index1][index2] = weight;
         adjMatrix[index2][index1] = weight;
         
      }
   }
    
    public void removeEdge(int t, int t1) {
        if (indexIsValid(t) && indexIsValid(t1)) {
            adjMatrix[t][t1] = null;
            adjMatrix[t][t1] = null;
        }
    }
    
    public void removeEdge(T t, T t1) {
        removeEdge(getIndex(t), getIndex(t1));
    }

    public void addVertex() {
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = null;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = null;
            adjMatrix[i][numVertices] = null;
        }
        numVertices++;
    }
    
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = null;
            adjMatrix[i][numVertices] = null;
        }
        numVertices++;
    }

    public void removeVertex (int index)
   {
      if (indexIsValid(index))
      {
         numVertices--;

         for (int i = index; i < numVertices; i++)
            vertices[i] = vertices[i+1];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j <= numVertices; j++)
               adjMatrix[i][j] = adjMatrix[i+1][j];

         for (int i = index; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               adjMatrix[j][i] = adjMatrix[j][i+1];
      }
   }
    
    public void removeVertex (T vertex)
   {
      for (int i = 0; i < numVertices; i++)
      {
         if (vertex.equals(vertices[i]))
         {
            removeVertex(i);
            return;
         }
      }
   }
    
    public Iterator<T> iteratorDFS(int startIndex)
   {
      Integer x;
      boolean found;
      LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
      ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
      boolean[] visited = new boolean[numVertices];

      if (!indexIsValid(startIndex))
         return resultList.iterator();

      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      traversalStack.push(new Integer(startIndex));
      resultList.addToRear(vertices[startIndex]);
      visited[startIndex] = true;
      
      while (!traversalStack.isEmpty())
      {
         x = traversalStack.peek();
         found = false;

         /** Find a vertex adjacent to x that has not been visited
             and push it on the stack */
         for (int i = 0; (i < numVertices) && !found; i++)
         {
            if((adjMatrix[x.intValue()][i].getDistance() < Double.POSITIVE_INFINITY)
               && !visited[i])
            {
               traversalStack.push(new Integer(i));
               resultList.addToRear(vertices[i]);
               visited[i] = true;
               found = true;
            }
         }
         if (!found && !traversalStack.isEmpty())
            traversalStack.pop();
      }
      return resultList.iterator();
   }

     public Iterator<T> iteratorDFS(T startVertex)
   {      
      return iteratorDFS(getIndex(startVertex));
   }
     
      public Iterator<T> iteratorBFS(int startIndex)
   {
      Integer x;
      LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
      ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();

      if (!indexIsValid(startIndex))
         return resultList.iterator();

      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      
      traversalQueue.enqueue(new Integer(startIndex));
      visited[startIndex] = true;
      
      while (!traversalQueue.isEmpty())
      {
         x = traversalQueue.dequeue();
         resultList.addToRear(vertices[x.intValue()]);

         /** Find all vertices adjacent to x that have not been 
             visited and queue them up */
         for (int i = 0; i < numVertices; i++)
         {
            if((adjMatrix[x][i] != null)
               && !visited[i])
            {
               traversalQueue.enqueue(new Integer(i));
               visited[i] = true;
            }
         }
      }
      return resultList.iterator();
   }
      
       public Iterator<T> iteratorBFS(T startVertex)
   {      
      return iteratorBFS(getIndex(startVertex));
   }

    protected Iterator<Integer> iteratorShortestPathIndices
                              (int startIndex, int targetIndex)
   {
      int index;
      double weight;
      int[] predecessor = new int[numVertices];
      Heap<Double> traversalMinHeap = new Heap<Double>();
      ArrayUnorderedList<Integer> resultList = 
                                  new ArrayUnorderedList<Integer>();
      LinkedStack<Integer> stack = new LinkedStack<Integer>();

      int[] pathIndex = new int[numVertices];
      double[] pathWeight = new double[numVertices];
      for (int i = 0; i < numVertices; i++)
         pathWeight[i] = Double.POSITIVE_INFINITY;

      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;

      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || 
                       (startIndex == targetIndex) || isEmpty())
         return resultList.iterator();

      pathWeight[startIndex] = 0;
      predecessor[startIndex] = -1;      
      visited[startIndex] = true;
      weight = 0;

      /** Update the pathWeight for each vertex except the 
          startVertex. Notice that all vertices not adjacent 
          to the startVertex  will have a pathWeight of 
          infinity for now. */
      for (int i = 0; i < numVertices; i++)
      {
         if (!visited[i] && adjMatrix[startIndex][i]!=null)
         {
            pathWeight[i] = pathWeight[startIndex] + 
                            adjMatrix[startIndex][i].getDistance();
            predecessor[i] = startIndex;
            traversalMinHeap.addElement(new Double(pathWeight[i]));
         }
      }

      do 
      {
         weight = (traversalMinHeap.removeMin()).doubleValue();
         traversalMinHeap.removeAllElements();
         if (weight == Double.POSITIVE_INFINITY)  // no possible path
            return resultList.iterator();
         else 
         {
            index = getIndexOfAdjVertexWithWeightOf(visited, pathWeight, 
                                                    weight);
            visited[index] = true;
         }

         /** Update the pathWeight for each vertex that has has not been 
             visited and is adjacent to the last vertex that was visited.
             Also, add each unvisited vertex to the heap. */
         for (int i = 0; i < numVertices; i++)
         {
            if (!visited[i])
            {
               if((adjMatrix[index][i] != null) && 
                  (pathWeight[index] + adjMatrix[index][i].getDistance()) < pathWeight[i])
               {
                  pathWeight[i] = pathWeight[index] + adjMatrix[index][i].getDistance();
                  predecessor[i] = index;
               }        
               traversalMinHeap.addElement(new Double(pathWeight[i]));
            }
         }
      } while (!traversalMinHeap.isEmpty() && !visited[targetIndex]);

      index = targetIndex;
      stack.push(new Integer(index));
      do
      {
         index = predecessor[index];
         stack.push(new Integer(index));
      } while (index != startIndex);
      
      while (!stack.isEmpty())
         resultList.addToRear((stack.pop()));

      return resultList.iterator();
   }

    protected int getIndexOfAdjVertexWithWeightOf(boolean[] visited,
            double[] pathWeight, double weight) {
        for (int i = 0; i < numVertices; i++) {
            if ((pathWeight[i] == weight) && !visited[i]) {
                for (int j = 0; j < numVertices; j++) {
                    if ((adjMatrix[i][j] !=null)
                            && visited[j]) {
                        return i;
                    }
                }
            }
        }

        return -1;  // should never get to here
    }

     public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex)
   {
      ArrayUnorderedList templist = new ArrayUnorderedList();
      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
         return templist.iterator();

      Iterator<Integer> it = iteratorShortestPathIndices(startIndex, 
                             targetIndex);      
      while (it.hasNext())
         templist.addToRear(vertices[(it.next()).intValue()]);
      return templist.iterator();
   }
     
     public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex)
   {
      return iteratorShortestPath(getIndex(startVertex), 
                                  getIndex(targetVertex));
   }

    
    public double shortestPathWeight(int startIndex, int targetIndex)
   {
      double result = 0;
      if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
         return Double.POSITIVE_INFINITY;

      int index1, index2;
      Iterator<Integer> it = iteratorShortestPathIndices(startIndex,
                             targetIndex);

      if (it.hasNext())
         index1 = ((Integer)it.next()).intValue();
      else
         return Double.POSITIVE_INFINITY;

      while (it.hasNext())
      {
         index2 = (it.next()).intValue();
         result += adjMatrix[index1][index2].getDistance();
         index1 = index2;
      }
      
      return result;
   }

     public Network mstNetwork()
   {
      int x, y;
      int index;
      double weight;
      int[] edge = new int[2];
      Heap<ITunel> minHeap = new Heap<>();
      Network<T> resultGraph = new Network<T>();

      if (isEmpty() || !isConnected())
         return resultGraph;

      resultGraph.adjMatrix = new Tunel[numVertices][numVertices];
      for (int i = 0; i < numVertices; i++)
         for (int j = 0; j < numVertices; j++)
            resultGraph.adjMatrix[i][j]= null;
      resultGraph.vertices = (T[])(new Object[numVertices]);      
      
      boolean[] visited = new boolean[numVertices];
      for (int i = 0; i < numVertices; i++)
         visited[i] = false;
      
      edge[0] = 0;
      resultGraph.vertices[0] = this.vertices[0];
      resultGraph.numVertices++;
      visited[0] = true;

      /** Add all edges, which are adjacent to the starting vertex,
          to the heap */
      for (int i = 0; i < numVertices; i++)
            minHeap.addElement((adjMatrix[0][i]));

      while ((resultGraph.size() < this.size()) && !minHeap.isEmpty())
      {
         /** Get the edge with the smallest weight that has exactly
             one vertex already in the resultGraph */
         do
         {
            weight = (minHeap.removeMin()).getDistance();
            edge = getEdgeWithWeightOf(weight, visited);
         } while (!indexIsValid(edge[0]) || !indexIsValid(edge[1]));

         x = edge[0];
         y = edge[1];
         if (!visited[x])
            index = x;
         else 
            index = y;

         /** Add the new edge and vertex to the resultGraph */
         resultGraph.vertices[index] = this.vertices[index];
         visited[index] = true;
         resultGraph.numVertices++;

         resultGraph.adjMatrix[x][y] = this.adjMatrix[x][y];
         resultGraph.adjMatrix[y][x] = this.adjMatrix[y][x];

         /** Add all edges, that are adjacent to the newly added vertex,
             to the heap */
         for (int i = 0; i < numVertices; i++)
         {
            if (!visited[i] && (this.adjMatrix[i][index].getDistance() < 
                                Double.POSITIVE_INFINITY))
            {
               edge[0] = index;
               edge[1] = i;
               minHeap.addElement((adjMatrix[index][i]));
            }
         }
      }
      return resultGraph;
   }

    private int[] getEdgeWithWeightOf(double weight, boolean[] visited) {
        int[] edge = new int[2];
      for (int i = 0; i < numVertices; i++)
         for (int j = 0; j < numVertices; j++)
            if ((adjMatrix[i][j].getDistance() == weight) && (visited[i] ^ visited[j]))
            {
               edge[0] = i;
               edge[1] = j;
               return edge;
            }

      /** Will only get to here if a valid edge is not found */
      edge[0] = -1;
      edge[1] = -1;
      return edge;
    }
    
    protected void expandCapacity()
   {
      T[] largerVertices = (T[])(new Object[vertices.length*2]);
      ITunel[][] largerAdjMatrix = 
         new Tunel[vertices.length*2][vertices.length*2];

      for (int i = 0; i < numVertices; i++)
      {
         for (int j = 0; j < numVertices; j++)
         {
            largerAdjMatrix[i][j].setDistance(adjMatrix[i][j].getDistance());
         }
         largerVertices[i] = vertices[i];
      }

      vertices = largerVertices;
      adjMatrix = largerAdjMatrix;
   }


    
    
}
