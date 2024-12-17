package com.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationFormTestNG {
    WebDriver driver; 
    
   

    @BeforeTest
    public void setUp() {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void registrationTest(String firstName, String lastName, String email, String password, String day, String month, String year, String gender) throws InterruptedException {
        WebElement createAccount = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createAccount.click();

        Thread.sleep(3000); 

        WebElement firstNameElement = driver.findElement(By.name("firstname"));
        firstNameElement.sendKeys(firstName);

        WebElement surnameElement = driver.findElement(By.name("lastname"));
        surnameElement.sendKeys(lastName);

        WebElement emailElement = driver.findElement(By.name("reg_email__"));
        emailElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By.name("reg_passwd__"));
        passwordElement.sendKeys(password);

        WebElement dayElement = driver.findElement(By.name("birthday_day"));
        new Select(dayElement).selectByVisibleText(day);

        WebElement monthElement = driver.findElement(By.name("birthday_month"));
        new Select(monthElement).selectByVisibleText(month);

        WebElement yearElement = driver.findElement(By.name("birthday_year"));
        new Select(yearElement).selectByVisibleText(year);

        WebElement genderElement = driver.findElement(By.xpath("//label[text()='" + gender + "']"));
        genderElement.click();

        WebElement signUpButton = driver.findElement(By.name("websubmit"));
        signUpButton.click();

        
        driver.navigate().to("https://www.facebook.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}