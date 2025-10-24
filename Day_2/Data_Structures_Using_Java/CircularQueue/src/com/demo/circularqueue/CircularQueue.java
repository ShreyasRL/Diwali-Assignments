package com.demo.circularqueue;

public class CircularQueue {
	private int[] queue;
	private int front, rear, size, capacity;

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

// Check if queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

// Check if queue is full
	public boolean isFull() {
		return size == capacity;
	}

// Enqueue (insert element)
	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue is full! Expanding capacity...");
			expandCapacity();
		}

		if (front == -1)
			front = 0;

		rear = (rear + 1) % capacity;
		queue[rear] = data;
		size++;

		System.out.println(data + " added to the queue.");
	}

// Dequeue (remove element)
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty! Cannot dequeue.");
			return -1;
		}

		int value = queue[front];
		front = (front + 1) % capacity;
		size--;

		if (size == 0) { // Reset pointers if queue becomes empty
			front = -1;
			rear = -1;
		}

		System.out.println(value + " removed from the queue.");
		return value;
	}

// Peek (get front element)
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return -1;
		}
		return queue[front];
	}

// Display queue contents
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty!");
			return;
		}

		System.out.print("Queue elements: ");
		for (int i = 0; i < size; i++) {
			int index = (front + i) % capacity;
			System.out.print(queue[index] + " ");
		}
		System.out.println();
	}

// Expand capacity dynamically
	private void expandCapacity() {
		int newCapacity = capacity * 2;
		int[] newQueue = new int[newCapacity];

		for (int i = 0; i < size; i++) {
			newQueue[i] = queue[(front + i) % capacity];
		}

		queue = newQueue;
		front = 0;
		rear = size - 1;
		capacity = newCapacity;

		System.out.println("Queue capacity doubled to " + capacity);
	}
}
