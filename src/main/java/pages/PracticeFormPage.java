package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(css = "input[placeholder='First Name']")
    WebElement inputFirstName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement inputEmail;
    @FindBy(css = "#userNumber")
    WebElement inputMobile;
    @FindBy(css = "textarea.form-control")
    WebElement textareaAddress;
    @FindBy(css = "input[id='dateOfBirthInput']")
    WebElement inputDateOfBirth;
    @FindBy(css = ".subjects-auto-complete__input")
    WebElement inputSubjects;
    @FindBy(id = "react-select-3-input")
    WebElement inputState;
    @FindBy(id = "react-select-4-input")
    WebElement inputCity;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalMessage;


    public void typePracticeForm(Student student) {
        inputFirstName.sendKeys(student.getFirstName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputMobile.sendKeys(student.getMobile());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        textareaAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
        scrollActions();
        btnSubmit.click();
    }


    public boolean isTextInModalMessageValid(String text){
        return isTextInElementPresent(modalMessage, text);
    }



    private void typeStateCity(String state, String city) {
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }

    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case SPORTS -> driver.findElement(By.id(h.getLocator())).click();
                case MUSIC -> driver.findElement(By.id(h.getLocator())).click();
                case READING -> driver.findElement(By.id(h.getLocator())).click();
            }
        }
    }

    private void typeSubjects(String subjects) {
        inputSubjects.click();
        String[] strArr = subjects.trim().split(",");
        for (String s : strArr) {
            inputSubjects.sendKeys(s);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeGender(Gender gender) {
        driver.findElement(By.id(gender.getLocator())).click();
    }

    private void typeDateOfBirth(String dateOfBirth) {
        inputDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        if (operationSystem.startsWith("Mac"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        inputDateOfBirth.sendKeys(dateOfBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
    }
}