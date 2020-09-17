/*Linked List In Java*/
import java.util.*;


public class LinkedList
{
	public static void main(String[] args) {
		//creating a LinkedList
		System.out.println("Linked List Creation: ");
		List list = new List();
		list.addInit(30);list.addInit(20);list.addInit(10);
	    list.addEnd(40);list.addEnd(50);
	    list.firstDelete();
	    list.lastDelete();
	    list.printMyList();
	    //reverse my linked list
	    list.reverseList();
	    list.printMyList();
	}
}
//each node of the linked List
class Node{
    
    public int data;
    public Node next;
    //node constructor
    Node(int data){
        this.next = null;
        this.data = data;
    }
    
    Node(){
    	this.next = null;
    	this.data = -1;
    }
    
}

class List{
    
    public Node head;
    //LinkedList constructor
    List(){
        head = new Node();
    }
    //adding the element initially
    void addInit(int data){
    	System.out.println("Adding : "+data);
        //creating a Node 
        Node n = new Node(data);
        //if list is empty
        if(this.head.next==null) {
        this.head.next = n;
        n.next = null;
        }
        //if list is not empty
        else {
        	n.next = this.head.next ;
        	this.head.next = n;
        }
    } 
    
    //adding the Element to the End 
    void addEnd(int data) {
    	Node n = new Node(data);
    	System.out.println("Adding : "+data);
    	//if list is empty
        if(this.head.next==null) {
        this.head.next = n;
        n.next = null;
        }
        else {
        	Node initPointer = this.head.next;
        	//point towards the end node
        	while(initPointer.next!=null) {	
        		initPointer = initPointer.next;
        		
        	}
        	initPointer.next = n;
        	n.next = null;
        	
        }
        
        
    }
    
    //delete the last element
    void lastDelete() {
    	if(this.head.next==null) {
    		throw new IllegalArgumentException();
    	}
    	else {
    		Node initPointer = this.head.next;
        	//point towards the end node
        	while(initPointer.next.next!=null) {	
        		initPointer = initPointer.next;	
        	}
        	Node deletedNode = initPointer.next;
        	initPointer.next = null;
        	System.out.println("Deleting : "+deletedNode.data);
    		
    	}
    	
    }
    
    //reverse a linked list
    void reverseList() {
    	Node previous = null;
    	Node nextOne = null;
    	Node current = this.head;
    	while(current!=null) {
    		nextOne = current.next;
    		current.next = previous;
    		previous = current;
    		current = nextOne;
    	}
    	this.head = previous;
    }
    
    //delete the first element
    void firstDelete() {
    	if(this.head.next==null) {
    		throw new IllegalArgumentException();
    	}
    	else {
    		Node deletedNode = this.head.next; 
    		this.head.next = this.head.next.next;
    		System.out.println("Deleting : "+deletedNode.data);
    		
    		
    	}
    	
    }
    
    
    void printMyList(){
        Node initPointer = this.head.next;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        while(initPointer!=null) {
        	System.out.println(initPointer.data);
        	initPointer = initPointer.next;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    
}


