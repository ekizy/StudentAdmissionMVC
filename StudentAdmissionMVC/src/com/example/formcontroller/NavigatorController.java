package com.example.formcontroller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
				student.setStudentHobby(dbConnector.rs.getString(3));

				String dateStr = dbConnector.rs.getString(4);
				SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				Date date = format.parse(dateStr);
				student.setStudentBirthday(date);
				student.setStudentNumber(dbConnector.rs.getInt(5));

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

				studentList.add(student);


			}

			//dbConnector.con.close();

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

	@RequestMapping(value="/teachers",method=RequestMethod.GET)
	public ModelAndView getTeachers()
	{
		ModelAndView model = new ModelAndView("Teachers");//javascript dosyasına mapping yapıldı.

		//DBConnector db= new DBConnector();

		return model;
	}


	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView contact()
	{
		ModelAndView model = new ModelAndView("contact");//javascript dosyasına mapping yapıldı.

		return model;
	}

	@RequestMapping(value="/getAdmission",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm()
	{
		ModelAndView model = new ModelAndView("AdmissionForm"); //javascript dosyasına mapping yapıldı.

		return model;
	}

	@RequestMapping(value="/student/{studentNumber}",method=RequestMethod.GET)
	public ModelAndView viewStudent()
	{
		ModelAndView model = new ModelAndView("student");

		//db'den student verilerini çek. Sayfaya yolla.

		return model;
	}


}
