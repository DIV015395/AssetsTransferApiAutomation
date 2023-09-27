package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetRequestAccept;
import org.example.AssetTransferInitiated;
import org.example.AssetTransferRevoke;
import org.example.ExtentManager;
import org.testng.annotations.Test;

public class AssetTransferInitiatedRequestAccept
{
    public ExtentReports extent;
    public ExtentTest test;
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Initiate asset , Request Accept , Revoke", "Initiate asset , Request Accept , Revoke");
        AssetTransferInitiated initiate =  new AssetTransferInitiated(test);
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void RequestAccept()
    {
        AssetRequestAccept assetrequestaccept = new AssetRequestAccept(test);
        assetrequestaccept.testAssetRequestAccept();
        extent.flush();
    }
    @Test(priority = 3)
    public void assetTransferRevoke()
    {
        AssetTransferRevoke initrevoke = new AssetTransferRevoke(test);
        initrevoke.testRevokeAsset();

    }

}
