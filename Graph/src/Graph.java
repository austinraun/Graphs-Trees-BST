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
 * Filename : Graph.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

import java.io.*;
import java.util.*;

public class Graph{
	
	private ArrayList<Vertex> myVerticies = new ArrayList<Vertex>();
	private Vertex[] myVertzz;
	private int numVerticies;
	private int numEdges;
	private String[] verticies = new String[100];
	
	public void addVertex(Vertex v){
		myVerticies.add(v);
	}
	
	public void printVerticies(){
		for (int i=0; i< numVerticies; i++){
			System.out.println(myVertzz[i].label);
		}
		
	}
	
	public void setNumVerticies(int num){
		numVerticies = num;
	}
	public void setNumEdges(int num){
		numEdges = num;
	}
	public int getNumVerticies(){
		return numVerticies;
	}
	public int getNumEdges(){
		return numEdges;
	}

	private static class Vertex{
		private List<Vertex> neighbors = new ArrayList<Vertex>();
		private int distance = 0;
		private String label = "";
		
		public void addNeighbor(Vertex v){
			neighbors.add(v);
		}
		public void setDistance(int dist){
			distance = dist;
		}
		public void setLabel(String n){
			label = n;
		}
		public void Vertex(int dista, String n){
			distance = dista;
			label = n;
		}
		
	}
	
	private Vertex source = new Vertex();
	private List<Vertex> vertContainer = new ArrayList<>();
    private Map<String,List<String>> neighbors = new HashMap<String,List<String>>();
    private Map<Vertex,List<Vertex>> vertexContainer = new HashMap<Vertex,List<Vertex>>();
    
	Graph(){
		source = null; 
	}

	void build_graph(String filename){
		String lines;
		try{
			
			Scanner s = new Scanner(new File(filename));
			numVerticies = Integer.parseInt(s.next());
			numEdges = Integer.parseInt(s.next());
			myVertzz = new Vertex[numVerticies];

		    for (int i = 0; i < numVerticies; i++){
		    	verticies[i] = (s.next());
		    	System.out.println(verticies[i]);
		    	this.add(verticies[i]);
		    	Vertex tempVertex = new Vertex();
		    	tempVertex.setLabel(verticies[i]);
		    	addVertex(tempVertex);
		    	myVertzz[i] = tempVertex; 
		    	if (i == 0){
		    		source = tempVertex;
		    	}
		    }
		    
		    /***
		    * Update Neighbors for each vertex
		    *
		     ***/
		    for (int j = 0; j < numEdges; j++){
		    	String first, second;
		    	first = s.next();
		    	second = s.next();
		    	this.add(first,second);
		    	for (int k = 0; k < numVerticies; k++){
		    		if(myVertzz[k].label.equals(first)){
		    			for(int l = 0; l < numVerticies; l++){
		    				if(myVertzz[l].label.equals(second)){
		    					myVertzz[k].neighbors.add(myVertzz[l]);
		    				}
		    			}
		    		}
		    	}
		    	
		    	
		    }
		    s.close();		    
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		catch (ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		this.setNumEdges(numEdges);
		this.setNumVerticies(numVerticies);
		
	}

	public String getVertexLabelAt(int i){
		return verticies[i];
	}
	
    public String toString () {
        StringBuffer s = new StringBuffer();
        for (String v: neighbors.keySet()){
        	s.append("\n" + v + " -> " + neighbors.get(v));
        }
        return s.toString();                
    }

	
	 public void add (String vertex) {
		if (neighbors.containsKey(vertex)){
			return;
		}
	  	Vertex newVertex = new Vertex();
	  	newVertex.setLabel(vertex);
		vertexContainer.put(newVertex, new ArrayList<Vertex>());
	  	vertContainer.add(newVertex);
	  	neighbors.put(vertex, new ArrayList<String>());
	 }
	 public void add (String start, String end) {
        this.add(start); 
        this.add(end);
        neighbors.get(start).add(end);
    }
	
	 
	 public void display(){
		 System.out.print("\nThis graph's adjacency list is: ");
		 System.out.println(this);
	 }
	 
	 
	 Map<String, Integer> distanc = new HashMap<String,Integer>();
	 public void display_levels(){
		 System.out.println("Distances FROM source: " + distanc);
	 }
	 
	 public void set_levels(String vertex) {
		 int distan;
			// Initially, all distance are infinity, except start node
	        for (String v: neighbors.keySet()) distanc.put(v, null);
	        distanc.put(vertex, 0);
	        // Queue for BFS
	        Queue<String> queue = new LinkedList<String>();
	        //First vertex in
	        queue.offer(vertex);
	        while (!queue.isEmpty()) {
	            String v = queue.remove();
	            distan = distanc.get(v);
	            // Update neighbors
	            for (String n: neighbors.get(v)) {
	                if (distanc.get(n) != null){
	                	continue;  
	                }
	                distanc.put(n, distan + 1);
	                queue.offer(n); 
	            }
	        }
     
	   }
	 
		public boolean is_connected(String vertex){
			this.set_levels(vertex);
			//If a value is infinity then it is not connected
			for(Map.Entry<String, Integer> entry: distanc.entrySet()) {
				if (entry.getValue() == null){
					return false;
				}
			}
			return true;
		}
}
