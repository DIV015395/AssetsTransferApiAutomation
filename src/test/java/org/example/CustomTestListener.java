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
        EmailSenders.emailSenderToManjeetSharma();
        EmailSenders.emailSenderToRajeshMishra();
        EmailSenders.emailSenderToVikasSood();
    }
}

//<listeners>
//<listener class-name="org.example.CustomTestListener" />
//</listeners>

