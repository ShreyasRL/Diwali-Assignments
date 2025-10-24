package com.demo.binarysearchtree;

public class BinarySearchTree {
	private Node root;

	public class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	// Add a new node
	public void addNode(int data) {
		root = insertRec(root, data);
	}

	private Node insertRec(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}

	// Remove a node
	public void removeNode(int data) {
		root = deleteRec(root, data);
	}

	private Node deleteRec(Node root, int data) {
		if (root == null) {
			System.out.println("Node not found!");
			return root;
		}

		if (data < root.data)
			root.left = deleteRec(root.left, data);
		else if (data > root.data)
			root.right = deleteRec(root.right, data);
		else {
			// Node with one or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// Node with two children: get inorder successor
			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}
		return root;
	}

	private int minValue(Node root) {
		int minVal = root.data;
		while (root.left != null) {
			minVal = root.left.data;
			root = root.left;
		}
		return minVal;
	}

	// Inorder Traversal (Left, Root, Right)
	public void inorder() {
		System.out.print("Inorder Traversal: ");
		inorderRec(root);
		System.out.println();
	}

	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}

	// Preorder Traversal (Root, Left, Right)
	public void preorder() {
		System.out.print("Preorder Traversal: ");
		preorderRec(root);
		System.out.println();
	}

	private void preorderRec(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}

	// Postorder Traversal (Left, Right, Root)
	public void postorder() {
		System.out.print("Postorder Traversal: ");
		postorderRec(root);
		System.out.println();
	}

	private void postorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data + " ");
		}
	}
}
