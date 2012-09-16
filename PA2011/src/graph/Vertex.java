package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<E extends Edge> {
	
	protected List<E> edges;
	
	public Vertex(){
		edges = new ArrayList<E>();
	}
	
	public List<E> getEdges(){
		return edges;
	}
	
	public void addEdge(E edge){
		edges.add(edge);
	}
	
	@Override
	public String toString() {
		String vertex = "";
		for(E e:edges){
			vertex = vertex + e + "\n";
		}
		return vertex;
	}
}
