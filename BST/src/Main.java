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
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int len = args.length;
		BST bst1 = new BST();
	    final int[] int_Sequence = new int[len];
	    System.out.print("Input Sequence: ");
	    for (int i=0; i < len; i++) {
	    	int_Sequence[i] = Integer.parseInt(args[i]);
	    	System.out.print(int_Sequence[i] + " ");
	    	bst1.insert(int_Sequence[i]);
	    }
		
	    System.out.print("\nInorder: ");
	    bst1.inorder();
	    System.out.print("\nPostorder: ");
	    bst1.postorder();
	    System.out.print("\nPreorder: ");
	    bst1.preorder();
	    
	    bst1.updateHeight();
	    bst1.updateDepth();
	    bst1.updateInorder();
	    
	    System.out.println("\n90 Degree Tree: \n");
	    bst1.display();
	    System.out.println("\nDisplay Key & Height: ");
	    bst1.displayKeyAndHeight();
	    System.out.println("\nDisplay Key & Depth: ");
	    bst1.displayKeyAndDepth();
	    System.out.println("\nDisplay Key & Inorder: ");
	    bst1.displayKeyAndInorder();
	    
		
	}

}
