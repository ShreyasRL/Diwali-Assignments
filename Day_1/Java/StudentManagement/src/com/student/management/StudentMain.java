package com.student.management;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentMain {
	public static void main(String[] args) {
		List<Student> slist = new ArrayList();

		// 10 student objects
		slist.add(new Student(1, "Virat", "Java", 88, 95));
		slist.add(new Student(2, "Smriti", "Python", 62, 89));
		slist.add(new Student(3, "Rohit", "C++", 77, 84));
		slist.add(new Student(4, "Harmanpreet", "C#", 59, 80));
		slist.add(new Student(5, "Rahul", "JavaScript", 91, 90));
		slist.add(new Student(6, "Shafali", "Java", 45, 66));
		slist.add(new Student(7, "Jadeja", "Python", 84, 88));
		slist.add(new Student(8, "Jemimah", "C++", 73, 78));
		slist.add(new Student(9, "Shubman", "C#", 93, 92));
		slist.add(new Student(10, "Deepti", "JavaScript", 66, 81));

		// Serialize Students
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
			for (Student s : slist) {
				oos.writeObject(s);
			}
			System.out.println("Student Data:");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// De-Serialize Students
		List<Student> dlist = new ArrayList<Student>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
			while (true) {
				try {
					Student s = (Student) ois.readObject();
					dlist.add(s);
				} catch (EOFException e) {
					break;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("");
		// Display Grade or Exception Message
		System.out.println("Student Grades:");
		for (Student s : dlist) {
			try {
				String grade = s.calculateGrade();
				System.out.println(s + "| Grade: " + grade);
			} catch (AttendanceException e) {
				System.out.println(s + " : " + e.getMessage());
			}
		}

		// Sort in decreasing order of attendance
		dlist.sort(new StudentCompare());
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("Students Sorted by Attendance in Descending Order:");
		for (Student s : dlist) {
			System.out.println(s);
		}

	}
}
