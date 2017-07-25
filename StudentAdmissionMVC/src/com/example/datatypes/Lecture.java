package com.example.datatypes;

import com.example.validators.IsValidLanguage;

public class Lecture {

	private Course course;
	private Instructor instructor;
	@IsValidLanguage()
	private String instructionLanguage;
	private String classRoom;
	private String dayTime;
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
	public String getDayTime() {
		return dayTime;
	}
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

}
