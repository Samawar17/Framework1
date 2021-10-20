package com.guru.pages;


import com.guru.InsuranceLogin;
import com.guru.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {

    @FindBy(xpath ="//td[contains(text(),'Manger Id : mngr356622')]")
    WebElement ManagerID;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
    WebElement Welcome;

    @FindBy(xpath = "//h2[text()='Guru99 Bank']")
    WebElement Logo;

     @FindBy(xpath = "//a[contains(text(),'New Tours')]")
             WebElement NewTours;

     @FindBy(linkText = "Insurance Project")
             WebElement InsuranceProject;

     //Create constructor of the class and initialize the page objects
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    //creates methods
    public String VarifyHomePageTitle() //later will call this method in homepagetest method and use assert to varify tittle
    {
        return driver.getTitle();
    }
    public NewTours ClickONNewtours() throws InterruptedException //when we click on new customer we will get new
                                // customer page that is why return type is object of new customer
    {
        NewTours.click();
       // Thread.sleep(5000);
        System.out.println(driver.getTitle());
        return new NewTours();
    }
    public InsuranceLogin ClickOnInsuranceProject(){
        InsuranceProject.click();
        System.out.println(driver.getTitle());
        return new InsuranceLogin();
    }








}
