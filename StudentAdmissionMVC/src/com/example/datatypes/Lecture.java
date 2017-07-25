package com.example.datatypes;

import com.example.validators.IsValidLanguage;

public class Lecture {

	private Course course;
	private Instructor instructor;
	@IsValidLanguage()
	private String instructionLanguage;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getInstructionLanguage() {
		return instructionLanguage;
	}
	public void setInstructionLanguage(String instructionLanguage) {
		this.instructionLanguage = instructionLanguage;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}
