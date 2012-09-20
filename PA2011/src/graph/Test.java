package graph;

import graph.tree.Tree;

public class Test {

	public static void main(String[] args) {
		int graphSize = 7;
		Tree<Edge, Vertex<Edge>> tree = new Tree<Edge, Vertex<Edge>>(graphSize);
		
		for(int i=0;i<graphSize;i++){
			tree.addVertex(i, new Vertex<Edge>());
		}
		
		tree.addBiEdge(0, 5, new Edge(), new Edge());
		tree.addBiEdge(0, 3, new Edge(), new Edge());
		tree.addBiEdge(0, 4, new Edge(), new Edge());
		
		tree.addBiEdge(5, 1, new Edge(), new Edge());
		tree.addBiEdge(4, 2, new Edge(), new Edge());
		tree.addBiEdge(4, 6, new Edge(), new Edge());
		
//		System.out.println(tree);
//		System.out.println(tree.diameter());
//		int[] range = tree.diameter();
//		for(int i=0;i<range.length;i++){
//			System.out.println(i+": "+range[i]);
//		}
		int a = 11;
		int x = a / 3;
		System.out.println(x);
	}
}

