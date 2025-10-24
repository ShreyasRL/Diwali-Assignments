package com.demo.circularlinkedlist;

public class CircularLinkedList {
	private Node head = null;

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Insert at nth Position
	public void insertAtPosition(int data, int position) {
		Node newNode = new Node(data);

		if (head == null) {
			newNode.next = newNode;
			head = newNode;
			return;
		}

		if (position == 1) {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			newNode.next = head;
			temp.next = newNode;
			head = newNode;
			return;
		}

		Node current = head;
		for (int i = 1; i < position - 1 && current.next != head; i++) {
			current = current.next;
		}

		newNode.next = current.next;
		current.next = newNode;
	}

	// Delete Node by data
	public void deleteByData(int key) {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		Node current = head, prev = null;

		// if head node is to be deleted
		if (head.data == key) {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			if (head.next == head) { // only one node
				head = null;
			} else {
				temp.next = head.next;
				head = head.next;
			}
			System.out.println("Deleted node with data: " + key);
			return;
		}

		// Search and Delete
		do {
			prev = current;
			current = current.next;
		} while (current != head && current.data != key);

		if (current.data == key) {
			prev.next = current.next;
			System.out.println("Deleted node with data: " + key);
		} else {
			System.out.println("Node with data " + key + " not found.");
		}

	}

	// Modify node by searching data
	public void modifyNode(int oldData, int newData) {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		Node temp = head;
		do {
			if (temp.data == oldData) {
				temp.data = newData;
				System.out.println("Modified node data from " + oldData + " to " + newData);
				return;
			}
			temp = temp.next;
		} while (temp != head);

		System.out.println("Node with data " + oldData + " not found.");
	}

	// Display circular Linked List
	public void display() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		Node temp = head;
		System.out.print("Circular Linked List: ");
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (temp != head);
		System.out.println();
	}

}
