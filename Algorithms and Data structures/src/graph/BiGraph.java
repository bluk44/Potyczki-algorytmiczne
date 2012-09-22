package graph;

/**
 * represents bidirectional graph
 * bidirectional graph has two directed edges between connected vertices a->b and b->a
 * 
 * @author boodex
 *
 */
public class BiGraph<E extends Edge,V extends Vertex<E>> extends Graph<E, V>{
	
	public BiGraph(int initialCapacity){
		super(initialCapacity);
	}
	
	public BiGraph(){
		
	}
	
	public BiGraph(BiGraph<E,V> biGraph){	
		super(biGraph);
	}
	
	public void addBiEdge(int vertA, int vertB, E edgeAB, E edgeBA){
		addDirectedEdge(vertA, vertB, edgeAB);
		addDirectedEdge(vertB, vertA, edgeBA);
	}
	
}
