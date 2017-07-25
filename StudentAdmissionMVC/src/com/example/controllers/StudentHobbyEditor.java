package com.example.formcontroller;

import java.beans.PropertyEditorSupport;

public class StudentHobbyEditor extends PropertyEditorSupport {

	//Form gonderildiginde Hobby Editor edit yapan fonksiyonu calistirip datayi hazirlayacaktir.

	@Override
	public void setAsText(String studentHobby) throws IllegalArgumentException{

		if(studentHobby.contains("Soccer")) //kullanıcı soccer girse bile hata vermemesi için value football yapıldı.
			setValue("Football");
		else setValue(studentHobby);
	}
}

