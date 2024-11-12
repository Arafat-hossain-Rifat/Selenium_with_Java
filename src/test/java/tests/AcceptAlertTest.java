package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AcceptAlertTest extends BaseTest{
    private final By JS_ALERT=By.xpath(String.format((PRECISE_TEXT_PATH),"JavaScript Alerts"));
    private final By JS_ALERT_BUTTON=By.xpath("//button[@onclick='jsPrompt()']");
    private final By SUCCESS_TEXT_LOCATOR=By.id("result");

    @Test
    public void acceptAlertTest(){
        driver.findElement(JS_ALERT).click();
        driver.findElement(JS_ALERT_BUTTON).click();
        String testInput="Test text";
        driver.switchTo().alert().sendKeys(testInput);
        driver.switchTo().alert().accept();
        String successText=driver.findElement(SUCCESS_TEXT_LOCATOR).getText();
        Assert.assertTrue(successText.contains(testInput));
    }
}
