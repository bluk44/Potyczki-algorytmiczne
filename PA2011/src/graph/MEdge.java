package graph;

public class MEdge extends Edge {
	public boolean active = true;
	public int pos_end = -1;
	
	public String toString(){
		return "--> " + end + " active: " + active + " pos end: " + pos_end;
	}
}
