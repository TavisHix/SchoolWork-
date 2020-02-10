
public class BinarySearchTreeDriver {

	public static void main(String[] args)
	{
		BinarySearchTree b = new BinarySearchTree();
		 b.add(21);
		 b.add(34);
		 b.add(5);
		 b.add(23);
		 b.add(13);
		 b.add(1);
		 b.add(14);
		 b.add(35);
		 b.add(22);
		 b.add(37);
		 
		 b.printPreOrder();
		 System.out.println(" ");
		 b.printPostOrder();
	}
}
