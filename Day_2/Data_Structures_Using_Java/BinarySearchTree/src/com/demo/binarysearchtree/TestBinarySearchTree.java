package com.demo.binarysearchtree;

import java.util.Scanner;

public class TestBinarySearchTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();

		while (true) {
			System.out.println("\n--- Binary Search Tree Menu ---");
			System.out.println("1. Add Node");
			System.out.println("2. Remove Node");
			System.out.println("3. Inorder Traversal");
			System.out.println("4. Preorder Traversal");
			System.out.println("5. Postorder Traversal");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter data to insert: ");
				int data = sc.nextInt();
				bst.addNode(data);
				System.out.println("Node added successfully.");
				break;

			case 2:
				System.out.print("Enter data to remove: ");
				int del = sc.nextInt();
				bst.removeNode(del);
				System.out.println("If present, node removed.");
				break;

			case 3:
				bst.inorder();
				break;

			case 4:
				bst.preorder();
				break;

			case 5:
				bst.postorder();
				break;

			case 6:
				System.out.println("Exiting program...");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
