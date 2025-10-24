package com.demo.circularqueue;

import java.util.Scanner;

public class TestCircularQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter initial capacity of circular queue: ");
		int capacity = sc.nextInt();

		CircularQueue cq = new CircularQueue(capacity);

		while (true) {
			System.out.println("\n--- Circular Queue Menu ---");
			System.out.println("1. Enqueue (Insert)");
			System.out.println("2. Dequeue (Delete)");
			System.out.println("3. Peek (Front Element)");
			System.out.println("4. Display Queue");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter element to insert: ");
				int data = sc.nextInt();
				cq.enqueue(data);
				break;

			case 2:
				cq.dequeue();
				break;

			case 3:
				int front = cq.peek();
				if (front != -1)
					System.out.println("Front element: " + front);
				break;

			case 4:
				cq.display();
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
