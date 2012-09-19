package graph;

import java.util.ArrayList;
import java.util.List;

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
	
	public V getVertex(int vertexId){
		return vertices.get(vertexId);
	}
	
	public void addVertex(int index, V vertex){
		vertices.add(vertex);
	}
	
	public void addDirectedEdge(int start, int end, E edge){
		Vertex<E> vertexStart = vertices.get(start);
		Vertex<E> vertexEnd = vertices.get(end);
		edge.setEnd(end);
		vertexStart.addEdge(edge);
	}
	/**
	 * 
	 * @param vertexID id of current vertex 
	 * @param originID id of previous vertex
	 * @return id of next vertex or -1 
	 */
	public int nextVertex(int vertexID,int originID){
		V vertex = vertices.get(vertexID);
		List<E> edges = vertex.getEdges();
		
		for(E edge:edges){
			if(edge.getEnd() != originID){
				return edge.getEnd();
			}
		}
		return -1;
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
