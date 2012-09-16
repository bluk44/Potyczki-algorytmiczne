package graph;

import java.util.ArrayList;

/**
 * abstract class representing graph
 * 
 * @author boodex
 *
 */
public class Graph<E extends Edge, V extends Vertex<E>> {
	
	protected ArrayList<V> vertices;
	
	public Graph(){
		vertices = new ArrayList<V>();
	}
	
	public Graph(int initialCapacity){
		vertices = new ArrayList<V>(initialCapacity);
	}
	
	public Graph(Graph<E,V> graph){
		vertices = new ArrayList<V>(graph.getVertices());
	}
	
	public ArrayList<V> getVertices(){
		return vertices;
	}
	
	public void addVertex(int index, V vertex){
		vertices.add(vertex);
	}
	
	public void addDirectedEdge(int start, int end, E edge){
		Vertex<E> vertexStart = vertices.get(start);
		Vertex<E> vertexEnd = vertices.get(end);
		if(vertexStart != null && vertexEnd != null){
			edge.setEnd(end);
			vertexStart.addEdge(edge);
		}
	}
	
	@Override
	public String toString() {
		String graph = "";
		for(int i =0;i<vertices.size(); i++){
			graph = graph + "vertex_"+i+": \n"+vertices.get(i).toString();
		}
		return graph;
	}
}
