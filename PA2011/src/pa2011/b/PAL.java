package pa2011.b;

import graph.BiGraph;
import graph.Edge;
import graph.MarkedEdge;
import graph.Vertex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Zadanie: PAL
 *	Paliwo
 *
 *  Potyczki Algorytmiczne 2011, runda 4B.
 *  Dostępna pamięć: 128 MB.
 *  
 * @author boodex
 *
 */

public class PAL {
	static public void main(String[] args){
		// graf powinien miec:
		// dodawanie wierzchołków z odpowiednim indexem OK
		// pobieranie wierzchołków o podanym indeksie
		// konstruktor kopiujacy                        OK 
		String inPath = "testy/PAL/test0.in";
		FileInputStream in = null;
		Scanner scanner = null;
		try {
			in = new FileInputStream(inPath);
		} catch (FileNotFoundException e) {
			System.out.println("test file not found");
			return;
		}
		scanner = new Scanner(in);
		int nVertices = scanner.nextInt();
		int nEdges = scanner.nextInt();
		BiGraph<MarkedEdge, Vertex<MarkedEdge>> graph = new BiGraph<MarkedEdge, Vertex<MarkedEdge>>(nVertices);
		for(int i=0;i<nVertices;i++){
			graph.addVertex(i, new Vertex<MarkedEdge>());
		}
		while(scanner.hasNext()){
			int vA = scanner.nextInt() - 1;
			int vB = scanner.nextInt() - 1;
			graph.addBiEdge(vA, vB, new MarkedEdge(), new MarkedEdge());
		}
		
//		System.out.println(graph.toString());
		
	}
	
	int longestWay(BiGraph<MarkedEdge, Vertex<MarkedEdge>> graph, List<Integer> way){
		ArrayList<LinkedList<Integer>> pWays = new ArrayList<LinkedList<Integer>>();
		ArrayList<Integer> waysLength = new ArrayList<Integer>();
		int nWays = 0;
		List<Vertex<MarkedEdge>> vertices = graph.getVertices();
		
		// stworzenie listy potencjalnych dróg		
		for(int i=0;i<vertices.size();i++){
			Vertex<MarkedEdge> vertex = vertices.get(i);
			if(vertex.getEdges().size() == 1){
				LinkedList<Integer> pWay = new LinkedList<Integer>();
				pWay.add(i);
				pWays.add(pWay);
				waysLength.add(1);
				++nWays;
			}
		}
		
//		for(int i=0;i<pWays.size();i++){
//			System.out.println("way_"+i+": ");
//			System.out.println(pWays.get(i));
//		}
		
		// szukanie drogi
		while(nWays > 2){
			for(int i=0; i<pWays.size();i++){
				LinkedList<Integer> w = pWays.get(i);
				if(w!=null){
					int iLast = w.getLast();
					int iNext = 0;
					Vertex<MarkedEdge> lastV = vertices.get(iLast);
					// idz do nastepnego
					for(MarkedEdge mE:lastV.getEdges()){
						if(mE.active){
							iNext = mE.getEnd();
							break;
						}
					}
					
				}
			}
		}
		return 0;
	}
}
