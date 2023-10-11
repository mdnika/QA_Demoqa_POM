package com.ait.demoqa.tests.form;

import com.ait.demoqa.data.StudentData;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.form.PracticeFormPage;
import com.ait.demoqa.tests.TestBase;
import com.ait.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getForms();
    new SidePanel(driver).selectPracticeForm();
  }

  @Test
  public void fillPracticeFormTest() {
    //hide iframes(ad & footer)
    new PracticeFormPage(driver).hideIframes();
    //enter personal data
    new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
            StudentData.EMAIL, StudentData.PHONE_NUMBER)
        //select gender
        .selectGender(StudentData.GENDER)
        //enter data(select date)
        //.enterDate(StudentData.DATE_OF_BIRTH)
        .selectDate("May", "1990", "30") //30 May 1990
        // add subjects
        .addSubjects(StudentData.SUBJECTS)
        //select hobby
        .selectHobby(StudentData.HOBBYS)
        //upload file
        .uploadFile(StudentData.PATH)
        //enter address
        .enterAddress(StudentData.ADDRESS)
        //select state
        .selectState(StudentData.STATE)
        //select city
        .selectCity(StudentData.CITY)
        //submit form
        .submitForm()
        //assert result
        .assertModalTitle("Thanks for submitting the form");


  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "addNewStudentFromCSV")
  public void fillPracticeFormFromDataProviderTest(String name, String lastname,
      String email, String phone, String date, String path, String address) {
    //hide iframes(ad & footer)
    new PracticeFormPage(driver).hideIframes();
    //enter personal data
    new PracticeFormPage(driver).enterPersonalData(name, lastname, email, phone)
        //select gender
        .selectGender(StudentData.GENDER)
        //enter data(select date)
        .enterDate(date)
        // add subjects
        .addSubjects(StudentData.SUBJECTS)
        //select hobby
        .selectHobby(StudentData.HOBBYS)
        //upload file
        .uploadFile(path)
        //enter address
        .enterAddress(address)
        //select state
        .selectState(StudentData.STATE)
        //select city
        .selectCity(StudentData.CITY)
        //submit form
        .submitForm()
        //assert result
        .assertModalTitle("Thanks for submitting the form");

  }

}
