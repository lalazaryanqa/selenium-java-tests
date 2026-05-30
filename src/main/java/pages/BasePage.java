package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
    static WebDriver driver;
    public static void setDriver(WebDriver wd){
        driver =wd;
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

    public void scrollActions() {
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0, 500).perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTextInElementPresent(WebElement element, String text){
        return element.getText().contains(text);
    }
}