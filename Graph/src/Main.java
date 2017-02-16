/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Austin
 * Last Name: Raun
 * Lab Section: 3A
 * email address: araun@uci.edu
 *
 *
 * Assignment: lab8
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{	
		//Create new object
		Graph graph = new Graph();
		String sourceVertex = new String();
		boolean bool;
		int numVerticies = 0;
		int numEdges = 0;
		//Pass input to build the graph
		graph.build_graph(args[0]);
		//Print out the graph's adjacency list 
		graph.display();
		//Get number of verticies & edges
		numVerticies = graph.getNumVerticies();
		numEdges = graph.getNumEdges();
		System.out.println("\n This graph has " + numVerticies +
				" verticies and has " + numEdges + " edges!");
		sourceVertex = graph.getVertexLabelAt(1);
		System.out.println("\n . . . Setting levels from source vertex with label '" 
		+ sourceVertex + "' at index 1:");
		graph.set_levels(sourceVertex);
		System.out.println("Displaying graph's verticies with each vertex's distance from source vertex '" 
		+ sourceVertex + "': ");
		graph.display_levels();
		System.out.print(". . . Is this graph connected?: ");
		//This graph is connected and will return true to prove method works for true
		bool = graph.is_connected(sourceVertex);
		System.out.println(bool);
		sourceVertex = graph.getVertexLabelAt(0);
		System.out.println("\n . . . Setting levels from source vertex with label '" 
		+ sourceVertex + "' at index 0:");
		graph.set_levels(sourceVertex);
		System.out.println("Displaying graph's verticies with each vertex's distance from source vertex '" 
		+ sourceVertex + "': ");
		graph.display_levels();
		System.out.print(". . . Is this graph connected?: ");
		//This graph is not connected and will return false to prove method works for true
		bool = graph.is_connected(sourceVertex);
		System.out.println(bool);
		
	}
}
