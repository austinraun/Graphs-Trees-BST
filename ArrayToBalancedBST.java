public class ArrayToBalancedBST {
	
	public TreeNode root;
	public class TreeNode{
		public int data;
		public TreeNode left;
		public TreeNode right;
		
		
		public TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	
	public TreeNode sortedArrayToBST(int[] arr) {
        int len = arr.length;
        return helper(arr, 0, len-1);
    }
    
    private TreeNode helper(int[] num, int l, int h) {
        
    	StringBuilder sb = new StringBuilder();
    	sb.append('a');
    	if(l > h) return null;
        else {
            int mid = (l + h) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = helper(num, l, mid-1);
            node.right = helper(num, mid+1, h);
            return node;
        }
    }
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