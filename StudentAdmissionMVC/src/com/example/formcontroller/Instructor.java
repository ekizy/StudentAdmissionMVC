package com.example.formcontroller;

public class Instructor {
	private String instructorName;
	private String instructorSurname;
	private Long instructorMobile;
	private String instructorTitle;
	private int instructorOffice;
	private String instructorEmail;

	public Instructor()
	{
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

	public int getInstructorOffice() {
		return instructorOffice;
	}

	public void setInstructorOffice(int instructorOffice) {
		this.instructorOffice = instructorOffice;
	}

	public String getInstructorSurname() {
		return instructorSurname;
	}

	public void setInstructorSurname(String instructorSurname) {
		this.instructorSurname = instructorSurname;
	}

}
