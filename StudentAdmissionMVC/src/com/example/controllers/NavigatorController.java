package com.example.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.datatypes.Address;
import com.example.datatypes.Course;
import com.example.datatypes.Instructor;
import com.example.datatypes.Lecture;
import com.example.datatypes.Student;
import com.example.db.DBConnector;

@Controller
public class NavigatorController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView homePage()
	{
		ModelAndView model = new ModelAndView("homepage");//javascript dosyasına mapping yapıldı.

		return model;
	}

	@RequestMapping(value="/students",method=RequestMethod.GET)
	public ModelAndView getStudents()
	{
		ModelAndView model = new ModelAndView("Students");//javascript dosyasına mapping yapıldı.

		DBConnector dbConnector= new DBConnector();

		ArrayList <Student> studentList = new ArrayList <Student>();

		String studentsQuery="SELECT * from STUDENTS;";

		try {
			dbConnector.rs =dbConnector.stmt.executeQuery(studentsQuery);


			while(dbConnector.rs.next())
			{
				Student student = new Student();
				int studentID = dbConnector.rs.getInt(1);
				student.setStudentName(dbConnector.rs.getString(2));
				student.setStudentSurname(dbConnector.rs.getString(3));
				student.setStudentHobby(dbConnector.rs.getString(4));

				String dateStr = dbConnector.rs.getString(5);
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date = format.parse(dateStr);
				student.setStudentBirthday(date);
				student.setStudentNumber(dbConnector.rs.getInt(6));
				student.setStudentFaculty(dbConnector.rs.getString(7));

				studentList.add(student);


			}

			dbConnector.con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addObject("students",studentList);
		return model;
	}

	@RequestMapping(value="/instructors",method=RequestMethod.GET)
	public ModelAndView getInstructors()
	{
		ModelAndView model = new ModelAndView("Instructors");//javascript dosyasına mapping yapıldı.

		DBConnector db= new DBConnector();

		ArrayList <Instructor> instructorList = new ArrayList <Instructor>();

		String instructorQuery="SELECT * from INSTRUCTORS;";

		try {
			db.rs=db.stmt.executeQuery(instructorQuery);

			while(db.rs.next())
			{
				Instructor instructor = new Instructor();
				int instructorID= db.rs.getInt(1);

				instructor.setInstructorName(db.rs.getString(2));
				instructor.setInstructorSurname(db.rs.getString(3));
				instructor.setInstructorMobile(db.rs.getString(4));
				instructor.setInstructorTitle(db.rs.getString(5));
				instructor.setInstructorEmail(db.rs.getString(6));
				instructor.setInstructorOffice(db.rs.getInt(7));

				instructorList.add(instructor);


			}
			db.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addObject("instructors",instructorList);
		return model;
	}

	@RequestMapping(value="/lectures",method=RequestMethod.GET)
	public ModelAndView getLectures()
	{
		ModelAndView model = new ModelAndView("Lectures");//javascript dosyasına mapping yapıldı.

		DBConnector db= new DBConnector();

		ArrayList <Lecture> lectureList = new ArrayList <Lecture>();

		String lectureQuery="SELECT * from LECTURES;";

		try {
			db.rs=db.stmt.executeQuery(lectureQuery);

			while(db.rs.next())
			{
				Lecture lecture = new Lecture();
				int lectureID= db.rs.getInt(1);

				int courseID=db.rs.getInt(2);
				int instructorID=db.rs.getInt(3);

				lecture.setInstructionLanguage(db.rs.getString(4));
				lecture.setClassRoom(db.rs.getString(5));
				lecture.setDayTime(db.rs.getString(6));


				String courseQuery="SELECT * from COURSES where id="+courseID+";";
				Statement courseStatement= db.con.createStatement();
				ResultSet courseResult= courseStatement.executeQuery(courseQuery);

				courseResult.next();
				Course course = new Course();
				course.setCourseName(courseResult.getString(2));
				course.setCourseCode(courseResult.getString(3));

				String instructorQuery="SELECT name,surname from INSTRUCTORS where id="+instructorID+";";
				Statement instructorStatement=db.con.createStatement();
				ResultSet instructorResult=instructorStatement.executeQuery(instructorQuery);

				instructorResult.next();
				Instructor instructor = new Instructor();
				instructor.setInstructorName(instructorResult.getString(1));
				instructor.setInstructorSurname(instructorResult.getString(2));

				lecture.setCourse(course);
				lecture.setInstructor(instructor);

				lectureList.add(lecture);


			}
			db.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addObject("lectures",lectureList);
		return model;
	}

	@RequestMapping(value="/courses",method=RequestMethod.GET)
	public ModelAndView getCourses()
	{
		ModelAndView model = new ModelAndView("Courses");//javascript dosyasına mapping yapıldı.

		DBConnector db= new DBConnector();

		ArrayList <Course> courseList = new ArrayList <Course>();

		String courseQuery="SELECT * from COURSES;";

		try {
			db.rs=db.stmt.executeQuery(courseQuery);

			while(db.rs.next())
			{
				Course course = new Course();
				int courseID= db.rs.getInt(1);

				course.setCourseName(db.rs.getString(2));
				course.setCourseCode(db.rs.getString(3));

				courseList.add(course);

			}
			db.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addObject("courses",courseList);
		return model;
	}

	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView contact()
	{
		ModelAndView model = new ModelAndView("contact");//javascript dosyasına mapping yapıldı.

		return model;
	}

	@RequestMapping(value="/addStudent",method=RequestMethod.GET)
	public ModelAndView newStudent()
	{
		ModelAndView model = new ModelAndView("addStudent"); //javascript dosyasına mapping yapıldı.

		return model;
	}

	@RequestMapping(value="/addInstructor",method=RequestMethod.GET)
	public ModelAndView newInstructor()
	{
		ModelAndView model = new ModelAndView("addInstructor"); //javascript dosyasına mapping yapıldı.

		return model;
	}

	@RequestMapping(value="/addLecture",method=RequestMethod.GET)
	public ModelAndView newLecture()
	{
		DBConnector db = new DBConnector();
		ModelAndView model = new ModelAndView("addLecture"); //javascript dosyasına mapping yapıldı.


		ArrayList<Instructor> instructorList = new ArrayList<Instructor> ();
		ArrayList<Course>  courseList = new ArrayList<Course>();

		try {
			db.rs= db.stmt.executeQuery("SELECT name,surname FROM INSTRUCTORS");

			while(db.rs.next())
			{
				Instructor instructor = new Instructor();
				instructor.setInstructorName(db.rs.getString(1));
				instructor.setInstructorSurname(db.rs.getString(2));

				instructorList.add(instructor);
			}

			db.rs=db.stmt.executeQuery("SELECT * from COURSES");
			while(db.rs.next())
			{
				Course course = new Course();
				course.setCourseName(db.rs.getString(2));
				course.setCourseCode(db.rs.getString(3));

				courseList.add(course);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		model.addObject("courses",courseList);
		model.addObject("instructors", instructorList);

		return model;
	}

	@RequestMapping(value="/addCourse",method=RequestMethod.GET)
	public ModelAndView newCourse()
	{
		ModelAndView model = new ModelAndView("addCourse"); //javascript dosyasına mapping yapıldı.

		return model;
	}

	@RequestMapping(value="/student/{studentNumber}",method=RequestMethod.GET)
	public ModelAndView viewStudent(@PathVariable("studentNumber") int studentNumber)
	{

		ModelAndView model = new ModelAndView("student");

		DBConnector dbConnector=new DBConnector();

		Student student = new Student();

		String query = "SELECT id,name,surname,hobby,birthday,faculty from Students where studentnumber="
		+studentNumber+";";

		try {
			dbConnector.rs=dbConnector.stmt.executeQuery(query);
			dbConnector.rs.next();

			int studentID= dbConnector.rs.getInt(1);
			student.setStudentName(dbConnector.rs.getString(2));
			student.setStudentSurname(dbConnector.rs.getString(3));
			student.setStudentHobby(dbConnector.rs.getString(4));

			String dateStr = dbConnector.rs.getString(5);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format.parse(dateStr);
			student.setStudentBirthday(date);

			student.setStudentNumber(studentNumber);
			student.setStudentFaculty(dbConnector.rs.getString(6));

			String skillQuery="SELECT skillname from STUDENTSKILLS where studentid="+studentID+";";

			Statement skillStatement= dbConnector.con.createStatement();

			ResultSet skillResult= skillStatement.executeQuery(skillQuery);

			ArrayList <String> skills = new ArrayList<String>();

			while(skillResult.next())
			{
				skills.add(skillResult.getString(1));
			}

			student.setStudentSkills(skills);

			String addressQuery="SELECT * from ADDRESSES where studentid="+studentID+";";

			Statement addressStatement= dbConnector.con.createStatement();

			ResultSet addressResult=addressStatement.executeQuery(addressQuery);

			addressResult.next();

			Address address = new Address();
			address.setCountry(addressResult.getString(2));
			address.setCity(addressResult.getString(3));
			address.setStreet(addressResult.getString(4));
			address.setPincode(addressResult.getInt(5));

			student.setStudentAddress(address);

			dbConnector.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addObject("student",student);

		return model;
	}

	@RequestMapping(value="/instructor/{instructorName}_{instructorSurname}",method=RequestMethod.GET)
	public ModelAndView viewInstructor(@PathVariable("instructorName") String instructorName,
			@PathVariable("instructorSurname") String instructorSurname)
	{
		ModelAndView model = new ModelAndView("instructor");

		DBConnector dbConnector=new DBConnector();

		Instructor instructor = new Instructor();

		String query="SELECT * from INSTRUCTORS WHERE name='"+instructorName+"' AND surname='"+instructorSurname+"' ;";

		try {
			dbConnector.rs=dbConnector.stmt.executeQuery(query);
			dbConnector.rs.next();

			int instructorID = dbConnector.rs.getInt(1);
			instructor.setInstructorName(dbConnector.rs.getString(2));
			instructor.setInstructorSurname(dbConnector.rs.getString(3));
			instructor.setInstructorMobile(dbConnector.rs.getString(4));
			instructor.setInstructorTitle(dbConnector.rs.getString(5));
			instructor.setInstructorEmail(dbConnector.rs.getString(6));
			instructor.setInstructorOffice(dbConnector.rs.getInt(7));

			model.addObject("instructor",instructor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return model;
	}

	@RequestMapping(value="enrollStudent",method=RequestMethod.GET)
	public ModelAndView enrollStudent()
	{
		ModelAndView model = new ModelAndView("enrollStudent");

		String lectureQuery="SELECT * FROM LECTURES JOIN COURSES ON courses.id=lectures.courseid";

		String studentQuery="SELECT * FROM STUDENTS";

		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
		ArrayList<Student> studentList = new ArrayList<Student>();

		DBConnector dbConnector=new DBConnector();

		try {
			dbConnector.rs=dbConnector.stmt.executeQuery(lectureQuery);
			while(dbConnector.rs.next())
			{
				Lecture lecture = new Lecture();
				Course course = new Course();
				lecture.setDayTime(dbConnector.rs.getString(6));
				lecture.setClassRoom(dbConnector.rs.getString(5));

				course.setCourseName(dbConnector.rs.getString(7));
				course.setCourseCode(dbConnector.rs.getString(8));

				lecture.setCourse(course);
				lecture.setInstructionLanguage(dbConnector.rs.getString(4));

				lectureList.add(lecture);

			}

			dbConnector.rs=dbConnector.stmt.executeQuery(studentQuery);
			while(dbConnector.rs.next())
			{
				Student student = new Student();
				student.setStudentName(dbConnector.rs.getString(2));
				student.setStudentSurname(dbConnector.rs.getString(3));
				student.setStudentHobby(dbConnector.rs.getString(4));
				student.setStudentNumber(dbConnector.rs.getInt(6));
				student.setStudentFaculty(dbConnector.rs.getString(7));

				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		model.addObject("students", studentList);
		model.addObject("lectures", lectureList);

		return model;

	}
}
