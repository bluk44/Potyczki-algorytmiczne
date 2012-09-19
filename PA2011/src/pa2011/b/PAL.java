package pa2011.b;

import graph.BiGraph;
import graph.MEdge;
import graph.MGraph;
import graph.MVertex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Zadanie: PAL Paliwo
 * 
 * Potyczki Algorytmiczne 2011, runda 4B. Dostępna pamięć: 128 MB.
 * 
 * @author boodex
 * 
 */

public class PAL {

	String inPath = "testy/PAL/test0.in";
	MGraph graph = null, workingGraph = null;

	ArrayList<LinkedList<Integer>> ways = new ArrayList<LinkedList<Integer>>(); // lista drog
	LinkedList<Integer> waysShort = new LinkedList<Integer>();
	int[] iWay = null; // mapowanie ID drogi na pozycje w "ways"
	int waysPtr = 0;
	static public void main(String[] args) {
		// graf powinien miec:
		// dodawanie wierzchołków z odpowiednim indexem OK
		// pobieranie wierzchołków o podanym indeksie
		// konstruktor kopiujacy OK
		
//		MGraph graph = new MGraph(3);
//		graph.addVertex(0, new MVertex());
//		graph.addVertex(1, new MVertex());
//		graph.addVertex(2, new MVertex());
//		graph.addBiEdge(0, 1, new MEdge(), new MEdge());
//		graph.addBiEdge(0, 2, new MEdge(), new MEdge());
//		System.out.println(graph);
		
		PAL zadanie = new PAL();
		System.out.println("rozwiazanie: "+ zadanie.solve());
	}

	public int solve() {

		int result = -1;

		FileInputStream in = null;
		Scanner scanner = null;
		try {
			in = new FileInputStream(inPath);
		} catch (FileNotFoundException e) {
			System.out.println("test file not found");
			return -1;
		}

		scanner = new Scanner(in);
		int nVertices = scanner.nextInt();
		int nEdges = scanner.nextInt();

		graph = new MGraph(nVertices);

		for (int i = 0; i < nVertices; i++) {
			graph.addVertex(i, new MVertex());
		}
		while (scanner.hasNext()) {
			int vA = scanner.nextInt() - 1;
			int vB = scanner.nextInt() - 1;
			graph.addBiEdge(vA, vB, new MEdge(), new MEdge());
		}
		System.out.println(graph.toString());
		// stworzenie listy potencjalnych dróg
		iWay = new int[nVertices];
		for (int i = 0; i < graph.getVertices().size(); i++) {
			MVertex vertex = graph.getVertices().get(i);
			if (vertex.getEdges().size() == 1) {
				LinkedList<Integer> way = new LinkedList<Integer>();
				way.add(i);
				ways.add(way);
				iWay[i] = ways.size() - 1;
			}
		}
		int intersection = findIntersect(7);
		
		System.out.println(intersection);
		
		
		// wynik
		return result;
	}
	/**
	 * 
	 * @param wayID
	 * @return vertex id of intersection or -1
	 */
	int findIntersect(int wayID) {
		int vertexID = -1;
		LinkedList<Integer> way = getWay(wayID);
			
		int prevID = way.getLast();
		int nextID = graph.nextVertex(prevID, prevID);
		MVertex nextV = graph.getVertex(nextID);

		while (nextV.nEdges() < 3 && nextV.wayID == -1) {
//			System.out.println("lol");
			way.add(nextID);
			int next2ID = graph.nextVertex(nextID, prevID);
			if (next2ID == -1) {
				// TODO
				return vertexID;
			} else {
				nextV = graph.getVertex(next2ID);
				prevID = nextID;
				nextID = next2ID;
			}
		}

		if (nextV.nEdges() >= 3) {
			int pos_end = graph.getVertex(prevID).getEdge(nextID).pos_end;		
			nextV.deactivateEdge(pos_end);
			System.out.println("vertex "+ nextID +  nextV);
		}

		if (nextV.wayID == -1) {
			nextV.wayID = wayID;
			vertexID = nextID;
		}

		return vertexID;
	}
	
	void chooseLonger(int vertexID, int wayID){
		MVertex v = graph.getVertex(vertexID);
		if(v.wayID == -1){
			v.wayID = wayID;
		} else if(getWay(v.wayID).size() < getWay(wayID).size()){
			waysShort.add(v.wayID);
			v.wayID = wayID;
		} else {
			waysShort.add(wayID);
		}
		
	}
	
	LinkedList<Integer> getWay(int wayID){
		return ways.get(iWay[wayID]);
	}
	
	void swapWays(int way1ID, int way2ID){
		int pos1 = iWay[way1ID];
		int pos2 = iWay[way2ID];
		
		LinkedList<Integer> way1 = ways.get(pos1);
		LinkedList<Integer> tmp = ways.get(pos1);
		LinkedList<Integer> way2 = ways.get(pos2);
		
		way1 = way2;
		way2 = tmp;
		
		iWay[way1ID] = pos2;
		iWay[way2ID] = pos1;
	}
}
