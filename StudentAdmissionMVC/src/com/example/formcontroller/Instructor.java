package com.example.formcontroller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.example.validators.IsValidTitle;

public class Instructor {

	@Pattern(regexp="[^0-9]*")
	private String instructorName;
                                    //isim ve soyisimde sayı olması engellendi.
	@Pattern(regexp="[^0-9]*")
	private String instructorSurname;

	@Pattern(regexp="(^$|[0-9]{10})")@NotNull// 10 haneli cep telefonu olması sağlandı
	private String instructorMobile;

	@IsValidTitle() // Yapay bir annotation ile titlelar kontrol ediliyor.
	private String instructorTitle;

	@Min(1) @Max(100) //Ofis numaraları 1 ile 100 arasında olacak şekilde ayarlandı
	private int instructorOffice;

	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" //E-mail kalıbına uyma zorunluluğu sağlandı.
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

	public String getInstructorMobile() {
		return instructorMobile;
	}

	public void setInstructorMobile(String instructorMobile) {
		this.instructorMobile = instructorMobile;
	}


}
