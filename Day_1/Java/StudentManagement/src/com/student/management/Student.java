package com.student.management;

import java.io.Serializable;

public class Student implements Serializable {
	private int rollno;
	private String sname;
	private String course;
	private double attendance_percentage;
	private double score;

	// Default Constructor
	public Student() {
		super();
	}

	// Paramaterized Constructor
	public Student(int rollno, String sname, String course, double attendance_percentage, double score) {
		super();
		this.rollno = rollno;
		this.sname = sname;
		this.course = course;
		this.attendance_percentage = attendance_percentage;
		this.score = score;
	}

	// Method calculate grade
	public String calculateGrade() throws AttendanceException {
		if (attendance_percentage < 60) {
			throw new AttendanceException("Attendance lesser than 60% Not eligible for grade calculation.");
		}

		if (score >= 90)
			return "A";
		else if (score >= 75)
			return "B";
		else if (score >= 60)
			return "C";
		else
			return "D";
	}

	// Getters
	public int getRollno() {
		return rollno;
	}

	public String getSname() {
		return sname;
	}

	public String getCourse() {
		return course;
	}

	public double getAttendance_percentage() {
		return attendance_percentage;
	}

	public double getScore() {
		return score;
	}

	// toString() Method
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", course=" + course + ", attendance_percentage="
				+ attendance_percentage + ", score=" + score + "]";
	}

}
