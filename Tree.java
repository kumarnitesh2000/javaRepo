import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//Tree algo's goes here


public class Tree {

	
	public static void main(String args[]) {
		
		System.out.println("Tree DataStructure \n");
		
		// creating a treeStructure
		TreeStructure tree  = new TreeStructure();
		//creating a root node
		tree.root = new TreeNode("A");
		tree.root.right = new TreeNode("C");
		tree.root.left = new TreeNode("B");
		tree.root.left.left = new TreeNode("D");
		tree.root.left.right = new TreeNode("E");
		//traversal in tree nodes
		tree.inorderTraversal(tree.root);
		System.out.println("");
		tree.postorderTraversal(tree.root);
		System.out.println("");
		tree.preorderTraversal(tree.root);
		//level order traversal
		System.out.println("");
		tree.levelOrderTraversal(tree.root);
		//vertical order traversal
		System.out.println("");
		int hd = 0; // of root node hd=0
		HashMap<Integer,List<String>> map = new HashMap<Integer,List<String>>(); 
		tree.verticalOrder(tree.root,hd,map);
		printMyHashMap(map);
		
	}
	//printing the hashMap
	public static void printMyHashMap(HashMap<Integer,List<String>> mp) {
		
		Iterator hmIterator = mp.entrySet().iterator();

        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            System.out.println("\t"+mapElement.getKey()+"\t"+mapElement.getValue());
        
        }
		
	}
	
	
}

//this is the structure of the tree
class TreeStructure{
	
	public int totalNodes;
	public TreeNode root;
	
	TreeStructure(){
		this.totalNodes = 0 ;
		this.root = null;
	}
	//inorder
	public void inorderTraversal(TreeNode node) {
		
		if(node == null)
			return;
		
		inorderTraversal(node.left);
		System.out.print("\t"+node.data);
		inorderTraversal(node.right);
		
		
		
	}
	
	//postorder
	public void postorderTraversal(TreeNode node) {
		
		
		if(node == null)
			return;
		
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print("\t"+node.data);
		
		
	}
	
	//preorder
	public void preorderTraversal(TreeNode node) {
		
		
		if(node == null)
			return;
		System.out.print("\t"+node.data);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		
		
	}
	
	//vertical order traversal
	public void verticalOrder(TreeNode node,int hd, HashMap<Integer,List<String>> mp) {
		
		if(node == null) 
            return;
		
		if(mp.containsKey(hd)) {
		List<String> list = mp.get(hd);
		list.add(node.data);
		}
		else {
			List<String> li  = new ArrayList<String>();
			li.add(node.data);
			
			mp.put(hd, li);
		}
		
		verticalOrder(node.left,hd-1,mp);
		verticalOrder(node.right,hd+1,mp);
		
		
		
	}
	
	//bfs
	public void levelOrderTraversal(TreeNode node) {
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		List<String> leftView = new ArrayList<String>();
		leftView.add(node.data);
		while(!q.isEmpty()) {
			
			//process the node
			TreeNode n = q.peek();
			if(n==null)
			{
				System.out.println();
				System.out.println("\tLeft View Of Tree is : ");
				System.out.println("\t"+leftView);
				return;
			}
			System.out.print("\t"+n.data);
			q.remove();
			List<TreeNode> listNodes = n.getNeighbournodes(n);
			//listNode[0]		
			if(listNodes.get(0)!=null)
				leftView.add(listNodes.get(0).data);
				
			for(TreeNode t: listNodes) {
				q.add(t);
			}
			
			
		}
	

	}
	
	
	
}

//class TreeNode
class TreeNode{
	
	public String data ;
	TreeNode left,right;
	
	
	TreeNode(String data){
		
		this.data = data;
		left = right = null;
		
	}
	
	public List<TreeNode> getNeighbournodes(TreeNode node){
		List<TreeNode> listNode = new ArrayList<TreeNode>();
		listNode.add(node.left);
		listNode.add(node.right);
		return listNode;
		
		
	}
	
	
	
	
}



