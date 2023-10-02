package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetInventoryListing;
import org.example.ExtentManager;
import org.testng.annotations.Test;

public class AssetInventoryListingTest {


    public ExtentReports extent;
    public ExtentTest test;
    @Test
    public void assetInventoryListing()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("I.T Asset Inventory Listing", "I.T side asset inventory Listing");
        AssetInventoryListing obj = new AssetInventoryListing(test);
        obj.testInventoryListing();
        test.pass("Test case passed successfully.");
        extent.flush();
    }
}
