package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="student")
@SequenceGenerator(name = "seq", sequenceName="rollNo_seq", initialValue=2, allocationSize=2)
public class Student implements Serializable {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO) // specifies that pk value will be incrementing automatically.
	// AUTO means it will take any random number, if we want particular sequence then we can use sequence too
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq") // sequence means it will be like 1,2,3,4.....
	@Column(name="rollNumber")
	private int rollNumber;
	@Column(name="studentName")
	private String studentName;
	@Column(name="avgScore")
	private double avgScore; 
	public Student()
	{
		
	}
	public Student(int rollNumber, String studentName, double avgScore) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.avgScore = avgScore;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", studentName=" + studentName + ", avgScore=" + avgScore + "]";
	}
	
	
	
}
