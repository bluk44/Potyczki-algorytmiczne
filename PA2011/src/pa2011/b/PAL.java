package pa2011.b;

import graph.Edge;
import graph.Vertex;
import graph.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import tools.Sprawdzarka;
import tools.Task;

/**
 * Zadanie: PAL Paliwo
 * 
 * Potyczki Algorytmiczne 2011, runda 4B. Dostępna pamięć: 128 MB.
 * 
 * @author boodex
 * 
 */

public class PAL implements Task {

	String testPath = "testy/PAL";
	Tree<Edge, Vertex<Edge>> tree = null;

	static public void main(String[] args) {
		PAL zadanie = new PAL();
		try {
			Sprawdzarka.check(zadanie, new File(zadanie.testPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// zadanie.solve(System.in, System.out);

	}

	public void solve(InputStream in, OutputStream out) {

		int result = -1;

		Scanner scanner = null;
		PrintWriter writer = new PrintWriter(out);

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

		if (fuel <= diameter - 1) {
			result = fuel + 1;
		} else {
			result = diameter;
			int left_fuel = fuel - diameter + 1;
			left_fuel = left_fuel / 2;
			int left_cities = nVertices - diameter;
			if (left_cities <= left_fuel) {
				result += left_cities;
			} else {
				result += left_fuel;
			}
		}
		writer.print(result);
		writer.print("\n");
		writer.flush();

	}

}
