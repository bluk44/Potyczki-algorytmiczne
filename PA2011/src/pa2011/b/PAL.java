package pa2011.b;

import graph.Edge;
import graph.MEdge;
import graph.MVertex;
import graph.Vertex;
import graph.tree.Tree;

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
	Tree<Edge, Vertex<Edge>> tree = null;

	static public void main(String[] args) {
		
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
		int fuel = scanner.nextInt();

		tree = new Tree<Edge, Vertex<Edge>>(nVertices);

		for (int i = 0; i < nVertices; i++) {
			tree.addVertex(i, new Vertex<Edge>());
		}
		while (scanner.hasNext()) {
			int vA = scanner.nextInt() - 1;
			int vB = scanner.nextInt() - 1;
			tree.addBiEdge(vA, vB, new Edge(), new Edge());
		}
		int diameter = tree.diameter();
		
		if(fuel <= diameter - 1){
			result = fuel + 1;
		} else {
			result = diameter;
			int left_fuel = fuel - diameter + 1;
			left_fuel = left_fuel / 2;
			int left_cities = nVertices - diameter;
			if(left_cities <= left_fuel){
				result += left_cities;
			} else{
				result += left_fuel;
			}
		}
		
		return result;
	}
}
