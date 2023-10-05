package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetInventoryListing;
import org.example.DoctorSideAssetListing;
import org.example.ExtentManager;
import org.testng.annotations.Test;

public class DoctorSideAssetListingTest {
    private ExtentReports extent;
    private ExtentTest test;
    @Test
    public void testStatusCodeReponseBody()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Doctor Assets Listing", "Doctor Assets Listing");
        DoctorSideAssetListing list = new DoctorSideAssetListing(test);
        list.testDoctorSideAssetListing();
        extent.flush();

    }
}
