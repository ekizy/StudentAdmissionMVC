package com.example.formcontroller;

import java.util.ArrayList;

public class Instructor {
	private String instructorName;
	private Long instructorMobile;
	private String instructorTitle;
	private int instructorOffice;
	private String instructorEmail;
	private ArrayList <Lecture> lectures;

	public Instructor()
	{
		lectures= new ArrayList <Lecture>();
	}

	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public Long getInstructorMobile() {
		return instructorMobile;
	}
	public void setInstructorMobile(Long instructorMobile) {
		this.instructorMobile = instructorMobile;
	}
	public String getInstructorTitle() {
		return instructorTitle;
	}
	public void setInstructorTitle(String instructorTitle) {
		this.instructorTitle = instructorTitle;
	}
	public String getInstructorEmail() {
		return instructorEmail;
	}
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	public ArrayList <Lecture> getLectures() {
		return lectures;
	}
	public void setLectures(ArrayList <Lecture> lectures) {
		this.lectures = lectures;
	}

	public int getInstructorOffice() {
		return instructorOffice;
	}

	public void setInstructorOffice(int instructorOffice) {
		this.instructorOffice = instructorOffice;
	}

}
