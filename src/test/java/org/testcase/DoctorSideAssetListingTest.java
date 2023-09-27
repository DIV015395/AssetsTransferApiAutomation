package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetInventoryListing;
import org.example.DoctorSideAssetListing;
import org.example.ExtentManager;
import org.testng.annotations.Test;

public class DoctorSideAssetListingTest {
    public ExtentReports extent;
    public ExtentTest test;
    @Test
    public void testStatusCodeReponseBody()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("I.T Asset Inventory Listing", "I.T side asset inventory Listing");
        DoctorSideAssetListing list = new DoctorSideAssetListing(test);
        list.testDoctorSideAssetListing();

    }
}
