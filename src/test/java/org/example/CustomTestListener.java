package org.example;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomTestListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        // This method is executed before the suite starts running
    }
    @Override
    public void onFinish(ISuite suite) {
        // This method is executed after the suite finishes running
        EmailSenders.sendReport(); // Call the email sending method
    }
}

