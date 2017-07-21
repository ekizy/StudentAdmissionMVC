package com.example.formcontroller;

import java.sql.SQLException;
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

		binder.registerCustomEditor(String.class,"studentHobby",new StudentHobbyEditor());
		//hobby icin editor kaydedildi.

	}

	@ModelAttribute
	public void addingCommonObjects(Model model1)
	{
		model1.addAttribute("commonMessage","Welcome to the page");
	}


	//Direk objeden page request.
	@RequestMapping(value="/submitAdmission",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1
			,BindingResult result)
	{
		//Request parametreleri javascript dosyalarıyla tutarlı olmak zorunda.

		if(result.hasErrors()) // Sinifla veri baglantisi tutmazsa. Yani hata varsa form geri dondurulur.
		{
			ModelAndView model = new ModelAndView("AdmissionForm"); //mapping to the javascript file
            return model;
		}

		//student tablosuna,skills tablosuna ve adres tablosuna veriler eklendi.

		DBConnector dbConnector = new DBConnector();

		try {
			String studentInsert ="INSERT INTO STUDENTS (name,hobby,birthday,studentnumber) VALUES ('"+
					student1.getStudentName().toString()+"','"+student1.getStudentHobby().toString()+"','"
					+student1.getStudentBirthday().toString()+"',"+student1.getStudentNumber()+");";

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

		ModelAndView model = new ModelAndView("AdmissionComplete"); // mapping to the javascript file.
		//model.addObject("promptMessage","The submitted information by you:: Name:" + name +" , Hobby: " + hobby);
		//model.addObject("headerMessage","Thanks for the admission");

		//Modele farklı türlerde objeler eklenip javascript dosyalarından bu objeler yansıtılabilir.

		return model;
	}


	/*
	//Parametreli page request.
	@RequestMapping(value="/submitAdmission.html",method=RequestMethod.POST)
   public ModelAndView submitAdmissionForm(
		   @RequestParam(value="studentName",defaultValue="Mert") String name ,
           @RequestParam(value="studentHobby",defaultValue="Football") String hobby,
           @RequestParam(value="studentMobile",defaultValue="0") String phoneNumber,
           @RequestParam(value="studentBirthDay",defaultValue="0") String birthDay,
           @RequestParam(value="studentSkills",defaultValue="No Skills") String [] skills)
   {
       //These request parameters should be consistent with the javascript file.

       Student student = new Student();
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       try{
    	   student.setStudentName(name);
    	   student.setStudentHobby(hobby);
    	   student.setStudentMobile(Long.parseLong(phoneNumber));
    	   student.setStudentBirthday(format.parse(birthDay));

    	   ArrayList <String> studentSkills =new ArrayList <String>();

    	   for(int i =0;i<skills.length;i++)
    	   {
    		   studentSkills.add(skills[i]);
    	   }

    	   student.setStudentSkills(studentSkills);
       }

       catch(Exception e)
       {
    	   System.out.println(e.getStackTrace());
       }
       ModelAndView model = new ModelAndView("AdmissionComplete"); // mapping to the javascript file.
       //model.addObject("promptMessage","The submitted information by you:: Name:" + name +" , Hobby: " + hobby);
       model.addObject("student1",student);
       model.addObject("headerMessage","Thanks for the admission");

       return model;
   } */






}
