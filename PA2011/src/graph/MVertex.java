package graph;

public class MVertex extends Vertex<MEdge> {
	
	public int wayID = -1;
	int nActive = 0;
	public void addEdge(MEdge edge){
		edges.add(edge);
		++nActive;
	}
	
	public MEdge getEdge(int endVertexID){
		MEdge edge = null;
		for(MEdge e : edges){
			if(e.getEnd() == endVertexID){
				edge = e;
				break;
			}
		}
		return edge;
	}
	
	public void deactivateEdge(int edgeID){
		edges.get(edgeID).active = false;
		--nActive;
	}
		
	public int nEdges(){
		return nActive;
	}
	
	public String toString() {
		String vertex = "wayID: "+ wayID + " active: "+nActive+"\n";
		for(MEdge e:edges){
			vertex = vertex + e + "\n";
		}
		return vertex;
	}
}
