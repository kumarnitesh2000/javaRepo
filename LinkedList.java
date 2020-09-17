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
    void printMyList(){
        Node initPointer = this.head.next;
        while(initPointer!=null) {
        	System.out.println(initPointer.data);
        	initPointer = initPointer.next;
        }
       
    }
    
    
}


