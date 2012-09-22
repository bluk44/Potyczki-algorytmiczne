package graph.tree;

import java.util.LinkedList;

import graph.BiGraph;
import graph.Edge;
import graph.Vertex;

public class Tree<E extends Edge, V extends Vertex<E>> extends BiGraph<E,V>{
	
	public Tree(int initialCapacity){
		super(initialCapacity);
	}
	
	public Tree(){
		
	}
	
	public Tree(Tree<E,V> tree){	
		super(tree);
	}
	
	public int diameter(){
		int d = 0;
		int[] range = new int[vertices.size()];
		boolean[] visited = new boolean[vertices.size()];
		LinkedList<Integer> lV = new LinkedList<Integer>();
		lV.add(0);
		int indexV = -1;
		while(!lV.isEmpty()){
			indexV = lV.pop();
			if(!visited[indexV]){
				visited[indexV] = true;
				V v = vertices.get(indexV);
				for(E e: v.getEdges()){
					if(!visited[e.getEnd()]){
						lV.add(e.getEnd());
						range[e.getEnd()] = range[indexV]+1;
					}
				}
			}
		}
		
		int v1_ID = indexV;
		for(int i=0;i<range.length;i++){
			range[i] = 0;
			visited[i] = false;
		}
		lV.add(v1_ID);
		indexV = -1;
		while(!lV.isEmpty()){
			indexV = lV.pop();
			if(!visited[indexV]){
				visited[indexV] = true;
				V v = vertices.get(indexV);
				for(E e: v.getEdges()){
					if(!visited[e.getEnd()]){
						lV.add(e.getEnd());
						range[e.getEnd()] = range[indexV]+1;
					}
				}
			}
		}
		d = range[indexV] + 1;
		return d;
	}
}
