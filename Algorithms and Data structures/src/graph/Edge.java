package graph;
/**
 * directed edge
 * @author boodex
 *
 */
public class Edge{
	
	/**
	 * index koncowego wierzchołka
	 */
	protected int end;
	
	public Edge(){
		this.end = -1;

	}
	
	public Edge(int end){
		this.end = end;

	}
	
	public void setEnd(int end){
		this.end = end;
	}
	
	public int getEnd(){
		return end;
	}
	
	@Override
	public String toString() {
		return "--> " + end;
	}
}
