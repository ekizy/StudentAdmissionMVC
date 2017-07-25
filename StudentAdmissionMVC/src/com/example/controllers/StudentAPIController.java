package com.example.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.datatypes.Student;

//@Controller
@RestController
public class StudentAPIController {

     //produces değişkeni ile sayfanın destekleyeceği formatlar kısıtlanabilir. Mesela şu an sadece json.
	//@ResponseBody
	@RequestMapping(value="/students",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Student> getStudentsList()
	{
		ArrayList<Student> students =new ArrayList<Student>();

		Student student1= new Student();
		student1.setStudentName("Serkan Bekir");


		Student student2= new Student();
		student2.setStudentName("Yusuf Ekiz");

		Student student3= new Student();
		student3.setStudentName("Emre Cetiner");

		students.add(student1);
		students.add(student2);
		students.add(student3);

		return students;
	}

	//@ResponseBody
	@RequestMapping(value="/students/{number}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable("number") int studentNumber)
	{
		//db'den student bilgileri alınır. Projeye db bağlamak lazım.

		Student student = new Student();
		student.setStudentNumber(studentNumber);
		return student;
	}
	// consume ile body'e sadece json şeklinde input girilmesi sağlanır.
	@RequestMapping(value="/students/{name}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateStudentInfo(@PathVariable("name") String studentName,@RequestBody Student student)
	{
		// db'e git.Student'ı bul. sonra update et.
		System.out.println("student name:"+ studentName);
		System.out.println("student name:"+ student.getStudentName());
		return true;
	}


	@RequestMapping(value="/students/update/{name}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudentInformation(@PathVariable("name") String studentName,@RequestBody Student student)
	{
		// db'e git.Student'ı bul. sonra update et.
		System.out.println("student name:"+ studentName);
		System.out.println("student name:"+ student.getStudentName());

		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.add("Key1","value1");
		httpHeaders.add("Key2", "value2");

		return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.OK); //Notfound tarzı statuslar da kullanılabilir.
	//birinci arguman true olduğu için Boolean yazıldı.
	//tek arguman yollanırsa sadece response status alır
	//iki arguman yollanırsa response body,response status alır
    // üç arguman alırsa response body,httpHeaders ve response status alır.
	}

	@RequestMapping(value="/students",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> getNewStudent(@RequestBody Student student)
	{
		// db'e kaydet.
		System.out.println("student name:"+student.getStudentName());

		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.add("Location",ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(student.getStudentName()).toUri().toString()
				);

		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
		//yeni birşey yollandı mı genellikle created sinyali yollanır. (201)
	}

	@RequestMapping(value="/students/update/{name}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudentInformation(@PathVariable("name") String studentName)
	{
		// db'e git.Student'ı bul. sonra sil
		System.out.println("student name:"+ studentName);

		HttpHeaders httpHeaders= new HttpHeaders();

		return new ResponseEntity<Boolean>(true,httpHeaders,HttpStatus.OK);
	}

}
