package com.student.management;

import java.util.Comparator;

public class StudentCompare implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		// Decreasing Order of Attendance
		return Double.compare(s2.getAttendance_percentage(), s1.getAttendance_percentage());
	}

}
