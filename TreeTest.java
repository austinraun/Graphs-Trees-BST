

public class TreeTest {

	public static void main(String[] args) {
		ArrayToBalancedBST bst = new ArrayToBalancedBST();
		
		int[] intA = {1,2,3,4,5,6,7};
		
		bst.sortedArrayToBST(intA);
		
		ArrayToBalancedBST.TreeNode tnode = bst.sortedArrayToBST(intA);
		
		System.out.println(tnode.data);
		System.out.println(tnode.left.data);
		System.out.println(tnode.left.left.data);

	}

}
