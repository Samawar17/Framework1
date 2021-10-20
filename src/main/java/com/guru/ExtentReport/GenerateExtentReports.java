package com.guru.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateExtentReports {
    //ExtentReports is a class which is present in import com.aventstack.extentreports package

    static ExtentReports extent; //Specify the location of reports
    //public ExtentTest test;//What details should be populate in reports


    public static ExtentReports GetReports() {
        System.out.print("hrllo from getreportd() mrthods");
       // extent=new ExtentReports(System.getProperty("user.dir")+"\\test-output\\MyOwnReports.html");
        String path=System.getProperty("user.dir")+"/test-output/extent.html";//giving location for the reports
        ExtentSparkReporter report=new ExtentSparkReporter(path);
        System.out.print("after");

        report.config().setReportName("Web Automation Report");
    report.config().setDocumentTitle("Test Result");
        extent =new ExtentReports();
        extent.attachReporter(report);

        extent.setSystemInfo("Tester","Nayana");
    return extent;

    }

}

