package com.raghav.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
	private int rollNo;
	private String name;
	
	Student(int rollNo, String name){
		this.rollNo = rollNo;
		this.name = name;
	}//end student
	
	public String toString() {
		return this.rollNo + " " + this.name;
	}

//	@Override
//	public int compareTo(Student otherStudent) {
//		if(this.rollNo > otherStudent.rollNo) return 1;
//		else if(this.rollNo < otherStudent.rollNo) return -1;
//		else return 0;
//	}
	
	@Override
	public int compareTo(Student otherStudent) {
		return this.name.compareTo(otherStudent.name);
	}
}//end student
public class ComparatorVsComparable {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"Raghav"));
		list.add(new Student(2,"Sanjeev"));
		list.add(new Student(3,"Aditya"));
		System.out.println("Before sorting :: " + list);
		Collections.sort(list);
		System.out.println("After sorting :: " + list);
	}

}
