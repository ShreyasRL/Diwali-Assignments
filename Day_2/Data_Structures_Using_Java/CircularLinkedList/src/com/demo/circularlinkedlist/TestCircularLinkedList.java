package com.demo.circularlinkedlist;

import java.util.Scanner;

public class TestCircularLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularLinkedList cll = new CircularLinkedList();

		while (true) {
			System.out.println("\n--- Circular Linked List Menu ---");
			System.out.println("1. Insert Node");
			System.out.println("2. Delete Node");
			System.out.println("3. Modify Node");
			System.out.println("4. Display List");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter data to insert: ");
				int data = sc.nextInt();
				System.out.print("Enter position: ");
				int pos = sc.nextInt();
				cll.insertAtPosition(data, pos);
				break;

			case 2:
				System.out.print("Enter data to delete: ");
				int key = sc.nextInt();
				cll.deleteByData(key);
				break;

			case 3:
				System.out.print("Enter old data: ");
				int oldData = sc.nextInt();
				System.out.print("Enter new data: ");
				int newData = sc.nextInt();
				cll.modifyNode(oldData, newData);
				break;

			case 4:
				cll.display();
				break;

			case 5:
				System.out.println("Exiting program...");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}
