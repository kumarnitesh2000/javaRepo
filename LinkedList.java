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
	    list.addEnd(90);
	    list.printMyList();
	    //reverse my linked list
	    list.reverseList();
	    list.printMyList();
	    //Print the middle elements
	    System.out.println(list.findMiddleElement());
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
    
}

class List{
    
    public Node head;
    //LinkedList constructor
    List(){
        this.head = null;
    }
    //adding the element initially
    void addInit(int data){
    	System.out.println("Adding : "+data);
        //creating a Node 
        Node n = new Node(data);
        //if list is empty
        if(this.head==null) {
        this.head = n;
        n.next = null;
        }
        //if list is not empty
        else {
        	n.next = this.head ;
        	this.head = n;
        }
    } 
    
    //adding the Element to the End 
    void addEnd(int data) {
    	Node n = new Node(data);
    	System.out.println("Adding : "+data);
    	//if list is empty
        if(this.head==null) {
        this.head = n;
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
    	if(this.head==null) {
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
    	Node nextOne ;
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
    	if(this.head==null) {
    		throw new IllegalArgumentException();
    	}
    	else {
    		Node deletedNode = this.head.next; 
    		this.head.next = this.head.next.next;
    		System.out.println("Deleting : "+deletedNode.data);
    		
    		
    	}
    	
    }
    //return the data at the middle node
    int findMiddleElement() {
    	//slow pointer and fast pointer towards the first node 
    	Node fast = this.head;
    	Node slow = this.head;
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow.data;
    	
    	
    }
    
    
    void printMyList(){
        Node initPointer = this.head;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        while(initPointer!=null) {
        	
        	System.out.println(initPointer.data);
        	initPointer = initPointer.next;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    
}


