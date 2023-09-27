package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetTransferInitiated;
import org.example.AssetTransferInitiatedRevoke;
import org.example.ExtentManager;
import org.example.InitiatedAssetListing;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InitiatedInitiatedAssetListing {
    public ExtentReports extent;
    public ExtentTest test;
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("I.T Asset Inventory Listing", "I.T side asset inventory Listing");
        AssetTransferInitiated initiate =  new AssetTransferInitiated(test);
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void initiatedAssetListing()
    {
        InitiatedAssetListing assetlisting = new InitiatedAssetListing(test);
        assetlisting.testGetInitiatedAssets();

    }
    @AfterTest
    public void assetTransferRevoke()
    {
        AssetTransferInitiatedRevoke initrevoke = new AssetTransferInitiatedRevoke(test);
        initrevoke.testRevokeAsset();
    }
}
