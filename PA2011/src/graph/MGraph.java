package graph;

public class MGraph extends Graph<MEdge, MVertex>{
	
	public MGraph(){
		
	}
	
	public MGraph(int initialCapacity){
		super(initialCapacity);
	}
	
	public MGraph(MGraph graph){
		super(graph);
	}
	
	public void addBiEdge(int vertA, int vertB, MEdge edgeAB, MEdge edgeBA){
		edgeAB.setEnd(vertB);
		edgeBA.setEnd(vertA);
		edgeAB.pos_end = vertices.get(vertB).getEdges().size();
		System.out.println(vertices.get(vertB).getEdges().size());
		edgeBA.pos_end = vertices.get(vertA).getEdges().size();
		
		vertices.get(vertA).addEdge(edgeAB);
		vertices.get(vertB).addEdge(edgeBA);
	}
}
