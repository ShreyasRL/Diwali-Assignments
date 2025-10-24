package com.demo.quicksort;

import java.util.Scanner;

public class QuickSortStrings {
	// Function to perform QuickSort
	public static void quickSort(String[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			// Recursively sort left and right parts
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	// Partition function
	private static int partition(String[] arr, int low, int high) {
		String pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j < high; j++) {
			// Compare strings lexicographically
			if (arr[j].compareToIgnoreCase(pivot) <= 0) {
				i++;
				// Swap arr[i] and arr[j]
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Swap pivot to correct position
		String temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	// Display function
	public static void display(String[] arr) {
		for (String s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	// Main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of strings: ");
		int n = sc.nextInt();
		sc.nextLine(); // Consume newline

		String[] arr = new String[n];
		System.out.println("Enter " + n + " strings:");

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}

		System.out.println("\nBefore Sorting:");
		display(arr);

		quickSort(arr, 0, n - 1);

		System.out.println("\nAfter Sorting (Alphabetical Order):");
		display(arr);

		sc.close();
	}
}
