package Week9;

public class LinkedTreeTest {
	public void main(String[] args) {
		LinkedTree bt = new LinkedTree();
		
		TreeNode n7 = bt.makeBT(null, 'D', null);
		TreeNode n6 = bt.makeBT(null, 'C', null);
		TreeNode n5 = bt.makeBT(null, 'B', null);
		TreeNode n4 = bt.makeBT(null, 'A', null);
		TreeNode n3 = bt.makeBT(n6,'/' , n7);
		TreeNode n2 = bt.makeBT(n4, '*', n5);
		TreeNode n1 = bt.makeBT(n2, '/', n3);
		
		System.out.printf("\nPreOrder >>> \t");
		bt.preorder(n1);
		System.out.printf("\nInOrder >>> \t");
		bt.inorder(n1);
		System.out.printf("\nPostOrder >>> \t");
		bt.postorder(n1);
	}
}
