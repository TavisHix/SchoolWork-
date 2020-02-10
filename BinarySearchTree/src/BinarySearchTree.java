
public class BinarySearchTree<E extends Comparable<E>>
{
	public class Node
	{
		private Node left;
		private Node right;
		private E data;
		
		public Node(E data)
		{
			this.data = data;
		}
		
		public String toString()
		{
			return this.data.toString();
		}
	}
	
	Node root;
	
	public void add(E data)
	{
		//if root is null, add first node to root
		if(root == null)
		{
			root = new Node(data);
		}
		//tree is not empty
		else
		{
			//start lookingfor the root
			Node current = root;
			boolean placed = false;
			while(!placed)
			{
			
			//if you get a negative, data is less than root
			if(data.compareTo(current.data) < 0)
			{
				if(current.left == null)
				{
					current.left = new Node(data);
					placed = true;
				}
				else
				{
					current = current.left; 
				}
			}
			//data is greater than(assume no duplicates), move towards the right
			else
			{
				if(current.right == null)
				{
					current.right = new Node(data);
					placed = true;
				}
				else
				{
					current = current.right; 
				}
			}
			}
		}
	}
	
	public void insert(E data)
	{
		root = insert(root, data);
	}
	
	private Node insert(Node curr, E data)
	{
		if(curr == null)
			new Node(data);
		else if(data.compareTo(curr.data) < 0)
			curr.left = insert(curr.left, data);
		else
			curr.right = insert(curr.right, data);
		
		return curr;
	}
	
	public void printPreOrder()
	{
		printPreOrder(root);
	}
	
	private void printPreOrder(Node curr)
	{
		if(curr != null)
		{
			System.out.println(curr);
			printPreOrder(curr.left);
			printPreOrder(curr.right);
		}
	}
	
	public void printPostOrder()
	{
		printPostOrder(root);
	}
	
	private void printPostOrder(Node curr)
	{
		if(curr != null)
		{
			printPreOrder(curr.left);
			printPreOrder(curr.right);
			System.out.println(curr);
		}
	}
	
}
