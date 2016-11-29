package com.my.finalproject.modelstore;

import java.util.ArrayList;

import com.my.finalproject.model.Classtable;
import com.my.finalproject.model.Student;


public class Mainpagedataprepareobject {

	private Classtable theclass;
	private ArrayList<Student> students;
	
	public Mainpagedataprepareobject(){
		this.students = new ArrayList<Student>();
	}
	public Classtable getTheclass() {
		return theclass;
	}
	public void setTheclass(Classtable theclass) {
		this.theclass = theclass;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	

}