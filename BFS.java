import java.util.*;
import java.util.ArrayList;
import java.util.List;
//breadth first search

public class BFS {
	public static void main(String args[]) {
		boolean is_Directional = false;
		System.out.println("Implementing Graph !");
		//creating a Graph is directional or not 
		Graph myGraph  = new Graph(is_Directional);
		//creating a node with data "A" and label 0
		GraphNode<String> s = myGraph.createANode("A",0);
		GraphNode<String> d =  myGraph.createANode("B", 1);
		GraphNode<String> e = myGraph.createANode("C", 2);
		//creating a edge b/w [s] and [d]
		myGraph.createEdge(s, d);myGraph.createEdge(s, e);
		//getting the neighbours of [s]
	    s.getNeighbours();
	    
	    //neighbours of e and d 
	    d.getNeighbours();e.getNeighbours();
	    //traverse through BFS 
	    myGraph.Bfs();
	}
}


//this is a node in a Graph
class GraphNode<T>{
	public char nodeStatus;
	public int label;
	public Data<T> data;
	public List<GraphNode<T>> neighbours;
	GraphNode(T data,int label){
		//ready state
		this.nodeStatus = 'r'; // or 'w'  , 'p'
		Data<T> dataInNode = new Data<T>(data);
		this.data = dataInNode;
		this.label = label;
		this.neighbours = new ArrayList<>();
		
		
	}
	
	public String toString() {
		
		String newString = new String("Node["+this.label+"] ");
		return newString;
		
	}
	
	public List<GraphNode<T>> getNeighbours() {
		System.out.println();
		System.out.println("Neighbours of "+this+" is connected to ");
		for(GraphNode<T> node :  this.neighbours) {
			System.out.print(node+"\t");
		}
		return this.neighbours;
	}
	
	
	
	
}

//this is a Graph
class Graph<T>{
	private int numEdges;
	private int numVertex;
	private boolean isDirectional;
	public ArrayList<GraphNode<T>> nodes;
	
	
	//constructor for graph
	Graph(boolean directional){
		this.isDirectional = directional;
		new ArrayList<>();
		
	}
	//get total vertices
	public int getNumVertices() {
		return numVertex;
	}
	//get total edges
	public int getEdges() {
		return numEdges;
	}
	
	//add a node in a graph
	public <T> GraphNode<T> addNode(T data,int label) {
		GraphNode<T> newNode  = new GraphNode<T>(data,label);
		//how to add node in the nodes list 
		
		//not solved 
		return newNode;
		
	}
	
	
	
	public <T> GraphNode<T> createANode(T d,int label) {
		Data<T> data = new Data<T>(d);
		GraphNode addedNode = addNode(data, label);
		System.out.println();
		System.out.print(addedNode.toString()+"Having data "+data.getData());
		return addedNode;
	}
	//creating an edge
	//passing the 2 node to be joined
	public <T> void createEdge(GraphNode<T> s, GraphNode<T> d) {
		
	s.neighbours.add(d);
	d.neighbours.add(s);
	}
	
	//bfs
	public void Bfs() {
		System.out.println();
		System.out.println("Total Nodes in Graph ");
		for(GraphNode<T> node : this.nodes) {
			System.out.println(node);
		}
		//algo goes here
	}
	
	
}

//data in each node 
class Data<T>{
	
	private T data;
	
	Data(T data){
		this.data = data;
		
	}
	public T getData() {
		return (T) this.data.toString();
	}
	
	
}


