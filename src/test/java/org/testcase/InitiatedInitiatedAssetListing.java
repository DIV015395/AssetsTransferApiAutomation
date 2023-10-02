package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetTransferInitiated;
import org.example.AssetTransferRevoke;
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
        test = extent.createTest("Initiated => Intiated Asset Request", "Initiated by I.T user,\n  Asset Request List Doctor Side");
        AssetTransferInitiated initiate =  new AssetTransferInitiated(test);
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void initiatedAssetListing()
    {
        InitiatedAssetListing assetlisting = new InitiatedAssetListing(test);
        assetlisting.testGetInitiatedAssets();
        extent.flush();
    }
    @AfterTest
    public void assetTransferRevoke()
    {
        AssetTransferRevoke initrevoke = new AssetTransferRevoke(test);
        initrevoke.testRevokeAsset();
    }
}
