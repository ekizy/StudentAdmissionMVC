package com.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.datatypes.Course;
import com.example.datatypes.Instructor;
import com.example.datatypes.Lecture;
import com.example.datatypes.Student;
import com.example.db.DBConnector;

@Controller
public class AdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		//binder.setDisallowedFields(new String [] {"studentMobile"});
		/*Field engellendi. AdmissionComplete
		sayfasinda bos olucak. */
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class,"studentBirthday",new CustomDateEditor(format,false));
		//Dogum gunu alani icin yeni bir format tanimlandi.

	}

	@ModelAttribute
	public void addingCommonObjects(Model model1)
	{
		model1.addAttribute("commonMessage","Welcome to the website");
	}


	//Direk objeden page request.
	@RequestMapping(value="/submitStudent",method=RequestMethod.POST)
	public ModelAndView submitStudent(@Valid @ModelAttribute("student1") Student student1
			,BindingResult result)
	{
		//Request parametreleri javascript dosyalarıyla tutarlı olmak zorunda.

		if(result.hasErrors()) // Sinifla veri baglantisi tutmazsa. Yani hata varsa form geri dondurulur.
		{
			ModelAndView model = new ModelAndView("addStudent"); //javascript dosyasına yönlendirildi.
            return model;
		}

		//student tablosuna,skills tablosuna ve adres tablosuna veriler eklendi.

		DBConnector dbConnector = new DBConnector();
		String studentBirthday="";

		try {

			DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
			studentBirthday = outputFormatter.format(student1.getStudentBirthday()); // Output : 01/20/2012

			System.out.println(studentBirthday);

			String studentInsert ="INSERT INTO STUDENTS (name,surname,hobby,birthday,studentnumber,faculty) VALUES ('"+
					student1.getStudentName().toString()+"','"+student1.getStudentSurname()
					+"','"+student1.getStudentHobby().toString()+"','"
					+studentBirthday+"',"+student1.getStudentNumber()+",'"
					+student1.getStudentFaculty()+"');";

			dbConnector.stmt.executeUpdate(studentInsert);


			dbConnector.rs=dbConnector.stmt.executeQuery("SELECT id from STUDENTS WHERE studentnumber="
			+Integer.toString(student1.getStudentNumber())+";");

			dbConnector.rs.next();

			int studentID=dbConnector.rs.getInt(1);

			System.out.println(studentID);



			ArrayList <String> skillList = student1.getStudentSkills();

			System.out.println(skillList.toString());

			for(int i=0;i<skillList.size();i++)
			{
				String skillInsert = "INSERT INTO STUDENTSKILLS (studentid,skillname) VALUES("
			+studentID+",'"+skillList.get(i)+"');";
				dbConnector.stmt.executeUpdate(skillInsert);
			}

			String addressInsert="INSERT INTO ADDRESSES (country,city,street,pincode,studentid) VALUES('"+
			   student1.getStudentAddress().getCountry()+"','"+student1.getStudentAddress().getCity()+"','"+
			   student1.getStudentAddress().getStreet()+"',"+student1.getStudentAddress().getPincode()+","+
			   studentID+");";

			dbConnector.stmt.executeUpdate(addressInsert);

			dbConnector.con.close();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView("studentAddSuccess"); // javascript dosyasına yönlendirildi.

		model.addObject("student1",student1);
		model.addObject("studentBirthday", studentBirthday);
		//Modele farklı türlerde objeler eklenip javascript dosyalarından bu objeler yansıtılabilir.

		return model;
	}


	@RequestMapping(value="/submitInstructor",method=RequestMethod.POST)
	public ModelAndView submitInstructor(@Valid @ModelAttribute("instructor") Instructor instructor
			,BindingResult result)
	{

		if(result.hasErrors()) // Hata kontrol edildi.
		{
			ModelAndView model = new ModelAndView("addInstructor"); //javascript dosyasına yönlendirildi.
            return model;
		}

		DBConnector dbConnector = new DBConnector();

		try {
			String instructorInsert ="INSERT INTO INSTRUCTORS (name,surname,mobile,title,email) VALUES ('"+
					instructor.getInstructorName()+"','"+instructor.getInstructorSurname()
					+"','"+instructor.getInstructorMobile()+"','"
					+instructor.getInstructorTitle()+"','"+instructor.getInstructorEmail()+"',"+instructor.getInstructorOffice()
					+");";

			dbConnector.stmt.executeUpdate(instructorInsert);


			dbConnector.rs=dbConnector.stmt.executeQuery("SELECT id from INSTRUCTORS WHERE name='"+instructor.getInstructorName()
			+"' AND surname='"+instructor.getInstructorSurname()+"';");

			dbConnector.rs.next();

			int instructorID=dbConnector.rs.getInt(1);

			System.out.println(instructorID);

			dbConnector.con.close();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView("instructorAddSuccess"); // javascript dosyasına yönlendirildi.

		model.addObject("teacher",instructor);


		return model;
	}

	@RequestMapping(value="/submitLecture",method=RequestMethod.POST)
	public ModelAndView submitLecture(@Valid @ModelAttribute("lecture") Lecture lecture,
			@ModelAttribute("courseCode") String courseCode,@ModelAttribute("instructorFullname") String instructorFullname,
			BindingResult result)
	{

		if(result.hasErrors()) // Hata kontrol edildi.
		{
			ModelAndView model = new ModelAndView("addLecture"); //javascript dosyasına yönlendirildi.
            return model;
		}

		DBConnector db = new DBConnector();
		String instructorName ="";
		String instructorSurname="";

		try {
			String courseQuery="SELECT id from COURSES where coursecode='"+courseCode+"'";
			Statement courseStatement= db.con.createStatement();
			ResultSet courseResult= courseStatement.executeQuery(courseQuery);

			courseResult.next();
			int courseID =courseResult.getInt(1);

			String [] fullname= instructorFullname.split("-");
			instructorName= fullname[0];
			instructorSurname= fullname[1];

			String instructorQuery="SELECT id from INSTRUCTORS where name='"+instructorName+
					"' AND surname='"+instructorSurname+"'";

			Statement instructorStatement= db.con.createStatement();
			ResultSet instructorResult= courseStatement.executeQuery(instructorQuery);

			instructorResult.next();
			int instructorID=instructorResult.getInt(1);

			String lectureInsert ="INSERT INTO LECTURES (courseid,instructorid,instructionlang,classroom,daytime) VALUES ("+
					courseID+","+instructorID
					+",'"+lecture.getInstructionLanguage()+"','"
					+lecture.getClassRoom()+"','"+lecture.getDayTime()+"');";

			db.stmt.executeUpdate(lectureInsert);

			db.con.close();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView("lectureAddSuccess"); // javascript dosyasına yönlendirildi.

		model.addObject("lecture",lecture);
		model.addObject("instructorName",instructorName);
		model.addObject("instructorSurname",instructorSurname);
		model.addObject("courseCode",courseCode);


		return model;
	}

	@RequestMapping(value="/submitCourse",method=RequestMethod.POST)
	public ModelAndView submitCourse(@Valid @ModelAttribute("course") Course course,BindingResult result)
	{

		if(result.hasErrors()) // Hata kontrol edildi.
		{
			ModelAndView model = new ModelAndView("addCourse"); //javascript dosyasına yönlendirildi.
            return model;
		}

		DBConnector dbConnector = new DBConnector();

		try {

			String courseInsert ="INSERT INTO COURSES (coursename,coursecode) VALUES ('"+ course.getCourseName()+"','"+
			course.getCourseCode()+"');";

			dbConnector.stmt.executeUpdate(courseInsert);

			dbConnector.con.close();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView model = new ModelAndView("courseAddSuccess"); // javascript dosyasına yönlendirildi.

		model.addObject("course",course);


		return model;
	}




}
