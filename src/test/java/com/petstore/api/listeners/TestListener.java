package com.petstore.api.listeners;

import com.aventstack.extentreports.Status;
import com.petstore.api.utils.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports before any tests start
        ExtentManager.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test for each method
        ExtentManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success
        ExtentManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure with the exception
        ExtentManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped tests
        ExtentManager.getTest().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the ExtentReports after all tests
        ExtentManager.flushReports();
    }
}
