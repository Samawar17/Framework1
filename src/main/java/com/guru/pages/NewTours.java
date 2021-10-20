package com.guru.pages;

import com.guru.base.BaseTest;
import com.guru.pages.com.RegisterPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewTours extends BaseTest {
    @FindBy(xpath = "//a[contains(text(),'REGISTER')]")
    WebElement RegisterLink;

    @FindBy( xpath = "//input[@name=\"firstName\"]")
    WebElement Firstname;

    @FindBy(name="city")
    WebElement City;

    @FindBy(id="email")
    WebElement Username;

    @FindBy(name="password")
    WebElement Password;

    @FindBy(name="confirmPassword")
    WebElement ConformPassword;

    @FindBy(name="submit")
    WebElement Submit;

    public NewTours()
    {
        PageFactory.initElements(driver,this);
    }
    public String validateTitle()
    {
         return driver.getTitle();
    }
    public RegisterPage AddContactInformation() throws InterruptedException {
        //System.out.println(driver.getTitle());
        //Thread.sleep(5000);
        RegisterLink.click();
        System.out.println(driver.getTitle());
        Firstname.sendKeys("Nayana");
         City.sendKeys("Naperville");
        Username.sendKeys("Samawar");
        Password.sendKeys("Chicago@2021");
        ConformPassword.sendKeys("Chicago@2021");
        Submit.click();
        return new RegisterPage();


    }












}
