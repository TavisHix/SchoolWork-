

public class AVLTree<E extends Comparable<E>>
{
	public class Node
	{
		private E data;
		private Node left;
		private Node right;

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

	public AVLTree()
	{

	}

	public void insert(E data)
	{
		root = insert(root, data);
	}

	private Node insert(Node p, E toInsert)
	{
		if (p == null)
		{
			return new Node(toInsert);
		}
		// move down the left side of the tree
		else if (toInsert.compareTo(p.data) < 0)
		{
			p.left = insert(p.left, toInsert);

			if (height(p.left) - height(p.right) == 2)
			{
				if (toInsert.compareTo(p.left.data) < 0)
					p = R_Rotation(p);
				else
					p = LR_Rotation(p);
			}
		}

		// move down the right side of the tree
		else
		{
			p.right = insert(p.right, toInsert);

			// AVL balance property not met, need to rebalance
			if (height(p.right) - height(p.left) == 2)
			{
				if (toInsert.compareTo(p.right.data) > 0)
					p = L_Rotation(p);	
				else
					p = RL_Rotation(p);
			}

		}
		
		return p;

	}

	public int height(Node n)
	{
		if (n == null)
			return 0;
		
		int leftHeight = height(n.left);
		int rightHeight = height(n.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public Node R_Rotation(Node n)
	{
		Node leftChildRightTree = n.left.right;
		Node oldParent = n;
		n = n.left;
		n.right = oldParent;
		oldParent.left = leftChildRightTree;
		return n;
	}

	public Node LR_Rotation(Node n)
	{
		n.left = L_Rotation(n.left);
		n = R_Rotation(n);
		return n;
	}

	public Node RL_Rotation(Node n)
	{
		n.right = R_Rotation(n.right);
		n = L_Rotation(n);
		return n;
	}

	public Node L_Rotation(Node n)
	{
		Node rightChildLeftTree = n.right.left;
		Node oldParent = n;
		n = oldParent.right;
		n.left = oldParent;
		oldParent.right = rightChildLeftTree;
		return n;
	}
	
	public void printPreOrder()
	{
		printPreOrder(root);
	}

	private void printPreOrder(Node current)
	{
		if (current != null)
		{
			System.out.println(current);
			printPreOrder(current.left);
			printPreOrder(current.right);
		}
	}
}