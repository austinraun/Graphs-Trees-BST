/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Austin
 * Last Name: Raun
 * Lab Section: 3A
 * email address: araun@uci.edu
 *
 *
 * Assignment: lab7
 * Filename : BST.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class BST {

	private static class BinaryNode{
		
		private int value;
		private BinaryNode left;
		private BinaryNode right;
		//Next extend your BST.java with the following functionality.
		private int height; //the height of the BinaryNode
		private int depth; //the depth of the BinaryNode
		private int inorder_pos; //the position of a given node in a sorted 
		//order (determined by inorder traversal)
		
		// Getters
		public int getValue() { return value; }
		public BinaryNode getLeftNode() { return left; }
		public BinaryNode getRightNode() { return right; }
		public int getHeight() { return height; }
		public int getDepth() { return depth; }
		public int getInoder_Pos() { return inorder_pos; }
		
		// Setters
		public void setValue(int v) { value = v; }
		public void setRightNode(BinaryNode n) { right = n; }
		public void setLeftNode(BinaryNode n) { left = n; }
		public void setHeight(int h) { height = h; }
		public void setDepth(int d) { depth = d; }
		public void setInorder_Pos(int p) { inorder_pos = p; }
		
		public BinaryNode(){
			left = null;
	        right = null;
	        value = 0;
	        height = -1; 
			depth = 0;
			inorder_pos = 0; 
		}
		public BinaryNode(int newVal) {
			left = null;
	        right = null;
	        value = newVal;
	        height = -1; 
			depth = 0;
			inorder_pos = 0; 
		}
		
	    private static BinaryNode insert(int value, BinaryNode t) {
	    // Your Implementation here. See course slides Lecture 7
	    	if (t == null)
	             t = new BinaryNode(value);
	         else
	         {
	             if (value <= t.getValue())
	                 t.left = insert(value, t.left);
	             else
	                 t.right = insert(value, t.right);
	         }
	         return t;
	    	
	    }
	    private static BinaryNode remove(int value, BinaryNode t) {
	    // Your Implementation here. See course slides Lecture 7
	    	 BinaryNode b1, b2, n;
	         if (t.getValue() == value)
	         {
	        	 BinaryNode leftNode, rightNode;
	             leftNode = t.getLeftNode();
	             rightNode = t.getRightNode();
	             if (leftNode == null && rightNode == null)
	                 return null;
	             else if (leftNode == null)
	             {
	                 b1 = rightNode;
	                 return b1;
	             }
	             else if (rightNode == null)
	             {
	                 b1 = leftNode;
	                 return b1;
	             }
	             else
	             {
	            	 b1 = rightNode;
	                 b2 = rightNode;
	                 while (b1.getLeftNode() != null){
	                     b1 = b1.getLeftNode();
	                 }
	                 b1.setLeftNode(leftNode);
	                 return b2;
	             }
	         }
	         if (value < t.getValue()){
	             n = remove(value,t.getLeftNode());
	             t.setLeftNode(n);
	         }else{
	             n = remove(value,t.getRightNode());
	             t.setRightNode(n);             
	         }
	         return t;
	    	
	    }
	    private static void display(BinaryNode t) {
	    // Your Implementation here
	    	if(t != null){
	    		curr_depth++;
	    		display(t.right);
	    		curr_depth--;
	    		for(int i = 0; i < curr_depth; i++){
	    			System.out.print(" ");
	    		}
	    		System.out.println(t.value);
	    		curr_depth++;
	    		display(t.left);
	    		curr_depth--;
	    	}
	    	
	    }
	} // end of BinaryNode class
	
	private static int curr_depth;
	private BinaryNode root = null;
	
	private static int inorderNum;
	
	public boolean isEmpty(){ return(root == null); }
	
	public void insert(int value) { 
		root = BinaryNode.insert(value, root);	
		
	}
    public void remove(int value) {  
    	if (isEmpty()){
            System.out.println("Tree Empty");
    	}
    	root = BinaryNode.remove(value, root);
	}
	public void display() { 
		BinaryNode.display(root); 
	}
	
	public void inorder(){
		inorder(root);
	}
	private void inorder(BinaryNode r)
    {
        if (r != null)
        {
            inorder(r.getLeftNode());
            System.out.print(r.getValue() +" ");
            inorder(r.getRightNode());
        }
    }
	
	
	public void postorder(){
		postorder(root);
	}
	private void postorder(BinaryNode r)
    {
        if (r != null){
            postorder(r.getLeftNode());             
            postorder(r.getRightNode());
            System.out.print(r.getValue() +" ");
        }
    }   
	
	
	
	public void preorder(){
		preorder(root);
	}
	private void preorder(BinaryNode r){
        if (r != null){
            System.out.print(r.getValue() +" ");
            preorder(r.getLeftNode());             
            preorder(r.getRightNode());
        }
    }
	
	public void updateHeight(){
		System.out.println("\n**Currently Updating Heights**");
		updateHeight(root);
	}
	private int updateHeight(BinaryNode t){
		if(t == null){
			return 0;
		}
		int left = 0;
		if(t.left !=null){
			left = 1 + updateHeight(t.left);
		}
		int right = 0;
		if (t.right != null){
			right = 1 + updateHeight(t.right);
		}
		if (right > left){
			t.height = right;
			return right;
		} else {
			t.height = left;
			return left;
		}
		
	}
	
	public void updateDepth(){
		System.out.println("\n**Currently Updating Depths**");
		updateDepth(root, 0);
	}
	
	private void updateDepth(BinaryNode t, int depth){
		if (t==null){
			return;
		}
		t.depth = depth;
		updateDepth(t.left, depth + 1);
		updateDepth(t.right,depth + 1);
		
	}
	
	public void updateInorder(){
		System.out.println("\n**Currently Updating Inorder**");
		inorderNum = 0;
		updateInorder(root);
	}
	
	private void updateInorder(BinaryNode t){
		if( t != null){
			
			if(t.left != null){
				updateInorder(t.left);
			}
			t.inorder_pos = inorderNum;
			inorderNum++;
			if (t.right != null){
				updateInorder(t.right);
			}
		}

	}
	
	public void displayKeyAndHeight(){
		curr_depth = 0;
		displayKeyAndHeight(root);
		System.out.println();
		
	}
	
	private void displayKeyAndHeight(BinaryNode t){
		if (t != null){
			curr_depth ++;
			displayKeyAndHeight(t.right);
			curr_depth --;
			System.out.println("Key " + "'"+ t.value + "'" + " height = " + t.height);
			curr_depth++;
			displayKeyAndHeight(t.left);
			curr_depth--;
		}
	}
	
	
	
	public void displayKeyAndDepth(){
		curr_depth = 0;
		displayKeyAndDepth(root);
		System.out.println();
		
	}
	
	private void displayKeyAndDepth(BinaryNode t){
		if (t != null){
			curr_depth ++;
			displayKeyAndDepth(t.right);
			curr_depth --;
			System.out.println("Key " + "'"+ t.value + "'" + " depth = " + t.depth);
			curr_depth++;
			displayKeyAndDepth(t.left);
			curr_depth--;
		}
	}
	
	public void displayKeyAndInorder(){
		curr_depth = 0;
		displayKeyAndInorder(root);
		System.out.println();
	}
	
	private void displayKeyAndInorder(BinaryNode t){
		if (t != null){
			curr_depth ++;
			displayKeyAndInorder(t.right);
			curr_depth --;
			System.out.println("Key " + "'"+ t.value + "'" + " Inorder Position = " + t.inorder_pos);
			curr_depth++;
			displayKeyAndInorder(t.left);
			curr_depth--;
		}
	}
	
	
}

