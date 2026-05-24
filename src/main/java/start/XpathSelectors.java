package start;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void practiceFormTest(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        hideFooter();
        WebElement divElements = driver.findElement
                (By.xpath("//div[@class='category-cards']/a[2]"));
        divElements.click();
        WebElement spanPracticeForm = driver.findElement
                (By.xpath("//span[text()='Practice Form']"));
        spanPracticeForm.click();

        pause(3000);
        driver.quit();
    }

    @Test
    public void textBoxXpathTest(){
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideFooter();
        pause(3000);
        //    li[id='item-2'] css
        //   //li[@id='item-2'] xpath
        //    li[id='item-2'] a[class='']  css
        //   //li[@id='item-2']/a[@class='']   xpath
        //  //input[@placeholder='Full Name'] xpath
        //  input[placeholder='Full Name']    css
        WebElement inputFullName = driver.findElement
                (By.xpath("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");
        //  //input[@id='userEmail']
        //  //*[@id='userEmail']
        //  //form/div[2]/div[2]/input
        WebElement inputEmail = driver.findElement
                (By.xpath("//form/div[2]/div[2]/input"));
        inputEmail.sendKeys("monkey123@gmail.com");
        // //*[text()='Current Address']/../..//textarea
        WebElement textareaCurAddress = driver.findElement
                (By.xpath("//*[text()='Current Address']/../..//textarea"));
        textareaCurAddress.sendKeys("monkey street 1");
        WebElement textareaPerAddress = driver.findElement
                (By.xpath("//div[@id='permanentAddress-wrapper']/div[2]/textarea"));
        textareaPerAddress.sendKeys("monkey avenue 4");
        WebElement btnSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        btnSubmit.click();
        WebElement output = driver.findElement(By.xpath("//*[@id='output']"));
        System.out.println(output.getText());
        pause(3000);
        driver.quit();
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer')" +
                ".style.display='none'");
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}