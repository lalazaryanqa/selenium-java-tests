package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    // Thanks for submitting the form
    @Test
    public void practiceFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);
        Student student = new Student("Maksim",
                "Maksimov", "maksimov325@gmail.com",
                Gender.MALE, "1234567890",
                "23 Mar 2001", " Maths,Chemistry,English ",
                hobbies, "", "address 1",
                StateCity.UTTAR_PRADESH.getState(), StateCity.UTTAR_PRADESH.getCity()[1]);
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
//        Assert.assertTrue(practiceFormPage.isTextInModalMessageValid
//                ("Wrong"));
//        System.out.println("program is working");
        Assert.assertTrue(practiceFormPage.isTextInModalMessageValid
                ("Thanks for submitting the form"));
    }

    @Test
    public void practiceFormPositiveWithSoftAssertTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);
        Student student = new Student("Maksim",
                "Maksimov", "maksimov325@gmail.com",
                Gender.MALE, "1234567890",
                "23 Mar 2001", " Maths,Chemistry,English ",
                hobbies, "", "address 1",
                StateCity.UTTAR_PRADESH.getState(), StateCity.UTTAR_PRADESH.getCity()[1]);
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
//        softAssert.assertTrue(practiceFormPage.isTextInModalMessageValid
//                ("Wrong"), "validate wrong modal message");
        //  System.out.println("program is working");
        softAssert.assertTrue(practiceFormPage.isTextInModalMessageValid
                        ("Thanks for submitting the form"),
                "validate right modal message");
        softAssert.assertTrue(getDriver().findElement
                        (By.xpath("//tbody/tr/td[2]")).getText().
                contains(student.getFirstName()), "validate firstName");
        softAssert.assertTrue(getDriver().findElement
                        (By.xpath("//tbody/tr/td[2]")).getText().
                contains(student.getLastName()), "validate lastName");
        softAssert.assertTrue(getDriver().findElement
                        (By.xpath("//tbody/tr[2]/td[2]")).getText().
                contains(student.getEmail()), "validate Email");
        softAssert.assertAll();
    }
}