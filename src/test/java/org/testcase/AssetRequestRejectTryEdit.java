package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssetRequestRejectTryEdit
{
    private ExtentReports extent;
    private ExtentTest test;
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Initiate asset => Request Reject => Revoke", "Transfer Initiated by I.T user, \nRejected By Doctor ,\nRevoke by I.T user");
        AssetTransferInitiated initiate =  new AssetTransferInitiated(test);
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void requestReject()
    {
        AssetRequestReject assetrequestreject = new AssetRequestReject(test);
        assetrequestreject.testAssetRequestReject();
    }
    @Test(priority = 3)
    public void assetTransferRevoke()
    {
        AssetTransferRevoke initrevoke = new AssetTransferRevoke(test);
        initrevoke.testRevokeAsset();
        extent.flush();
    }
}
