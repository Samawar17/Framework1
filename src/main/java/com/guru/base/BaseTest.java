package com.guru.base;

import com.guru.utility.Testutil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;
    public  BaseTest()
    {
        prop=new Properties();//create a object Properties class
        FileInputStream ip= null;
        try {
            ip = new FileInputStream("C://Users//sunil//IdeaProjects//Framework//src//" +
                    "main//java//com//guru//confi//confi.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);//load method will get all the data from confi file and load in Basetest class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void initialization(){
      String browsername=prop.getProperty("browser");//reading browser from properties file
        if(browsername.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C://InnovapathDriver//chromedriver_win32//chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browsername.equals("FF")){
            System.setProperty("webdriver.gecko.driver","C://InnovapathDriver//chromedriver_win32//gecko.exe");
            driver = new FirefoxDriver(); }

        driver.manage().window();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Testutil.Page_load_time, TimeUnit.SECONDS);//insted of this 20 hard coded value we can take from testutil class
                                                                           //so that it will be easy to change in future
        driver.manage().timeouts().implicitlyWait(Testutil.Implicity_wait, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }}
