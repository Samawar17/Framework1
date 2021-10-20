package com.guru.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guru.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.logging.Logger;

public class Blistener extends BaseTest implements ITestListener {
    GenerateExtentReports rep;
    Logger logger=Logger.getLogger("Blistener");//we have to create connection bet log4j.xml
    // n current class that why we r giving class name during instatiation

    public Blistener() throws IOException {
        super();
        // TODO Auto-generated constructor stub
    }

    ExtentReports extent = GenerateExtentReports.GetReports();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        test.generateLog(Status.PASS, "Test Passed");
        logger.info("suceffuly passed testcase: "+result.getMethod().getMethodName()+"in method: " +result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("failed the execution");
        System.out.println("test case failed at :" + result.getName());
        test.fail(result.getThrowable());

        logger.info(" failed testcase: "+result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();
    }

}
