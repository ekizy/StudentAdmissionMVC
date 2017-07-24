package com.example.formcontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.validators.IsValidHobby;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL) //null olan fieldlar json body'sine yazılmayacak.
//@JsonIgnoreProperties({"studentHobby"}) Bazı fieldlar yok da sayılabilir.
//Json görünümündeki fieldlar sıralandı.
@JsonPropertyOrder({"student_name","studentHobby","studentMobile","studentBirthday","studentAddress","studentSkills"})
public class Student {
	@JsonProperty("student_name") //Json body'sinde görünmesini istediğimiz field adı.
	@Pattern(regexp="[^0-9]*") //isimde rakam bulunmamasi için bir pattern tanimlandi.
	private String studentName;

	@Pattern(regexp="[^0-9]*") //soyisimde rakam bulunmamasi için bir pattern tanimlandi.
	private String studentSurname;


	//@Size(min=2,max=20,message="Please give a value for hobby which has a length between {min} and {max}")
	//Hataya ozel mesaj da verilebilir.

	@Size(min=2,max=20) @IsValidHobby()
	//isValidHobby yapay annotation. Ici bos da kalabilir. listenin default valuesu var isValid class'ında
	private String studentHobby;

	@Past
	private Date studentBirthday; //tarih formati. DD/MM/YYYY seklinde olmali.

	private ArrayList<String> studentSkills;

	private Address studentAddress; //adres sinifi student sinifinda kullanildi.

	@Min(1) @Max(999999999)   //studentNumber'ın (1,999999999) aralığında olması sağlandı.
	private int studentNumber;

	private String studentFaculty;

	public Student(String name,String hobby)
	{
		this.studentName=name;
		this.studentHobby=hobby;
	}

	public Student()
	{

	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Date getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public String getStudentFaculty() {
		return studentFaculty;
	}

	public void setStudentFaculty(String studentFaculty) {
		this.studentFaculty = studentFaculty;
	}


}
