package com.guru.pages;

import com.guru.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseTest {//Pagefactory

    @FindBy(xpath="//input[@type='text']") //"//input[@name='uid']")
    WebElement userID;


    @FindBy(name="password")
    WebElement password;

    @FindBy(name="btnLogin")
    WebElement Loginbutton;

    @FindBy(xpath="/html/body/div[2]/h2")
    WebElement logo;
//initialize the page objects
    public Login() {
        PageFactory.initElements(driver,this);//PageFactory is a class n this means current class
                                              //all the above variable initialize with driver
    }
    public String ValidateLoginPageTitle()
    {
        return driver.getTitle();
    }
    public Boolean ValidateLogo()
    {
        return logo.isDisplayed() ;
    }
    public  HomePage Login(String ur, String pw) throws InterruptedException {
        Thread.sleep(3000);
        userID.sendKeys(ur); //UserID,Password,LOginbutton we have mention above
        password.sendKeys(pw);

        Loginbutton.click();
        return  new HomePage();

    }
}
