
public class AVLTreeDriver
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AVLTree<Integer> theTree = new AVLTree<Integer>();

		theTree.insert(50);
		theTree.insert(25);
		theTree.insert(75);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(43);
		theTree.insert(30);

		theTree.insert(33);
		theTree.insert(87);
		theTree.insert(93);
		theTree.insert(97); 
		
		theTree.printPreOrder();
	}

}