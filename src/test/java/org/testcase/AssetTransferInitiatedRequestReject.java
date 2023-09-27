package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssetTransferInitiatedRequestReject
{
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
    public void RequestAccept()
    {
        AssetRequestReject assetrequestreject = new AssetRequestReject(test);
        assetrequestreject.testAssetRequestReject();
    }
    @AfterTest
    public void assetTransferRevoke()
    {
        AssetTransferInitiatedRevoke initrevoke = new AssetTransferInitiatedRevoke(test);
        initrevoke.testRevokeAsset();
    }

}
