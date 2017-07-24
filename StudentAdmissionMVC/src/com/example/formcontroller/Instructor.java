package com.example.formcontroller;

import javax.validation.constraints.Pattern;

public class Instructor {

	@Pattern(regexp="[^0-9]*")
	private String instructorName;

	@Pattern(regexp="[^0-9]*")
	private String instructorSurname;

	@Pattern(regexp="[0-9]{10}")
	private Long instructorMobile;

	private String instructorTitle;

	private int instructorOffice;

	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
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
