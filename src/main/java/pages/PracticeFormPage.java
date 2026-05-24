package pages;

import dto.Student;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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

    public void typePracticeForm(Student student) {
        inputFirstName.sendKeys(student.getFirstName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputMobile.sendKeys(student.getMobile());
        typeDateOfBirth(student.getDateOfBirth());
        textareaAddress.sendKeys(student.getAddress());


    }
    private void typeSubjects(String subjects){
        inputSubjects.click();
        String[] strArr = subjects.trim().split(",");
        for (String str : strArr) {
            inputSubjects.sendkeys(s);
            inputSubjects.sendkeys(Keys.ENTER);

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
