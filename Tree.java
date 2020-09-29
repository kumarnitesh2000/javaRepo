import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

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



