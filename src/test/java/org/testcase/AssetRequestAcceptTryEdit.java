package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssetRequestAcceptTryEdit
{
    public ExtentReports extent;
    public ExtentTest test;
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Initiate asset , Rquest Accept , Edit , Revoke", "Initiate asset , Rquest Accept , Edit , Revok");
        AssetTransferInitiated initiate =  new AssetTransferInitiated(test);
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void RequestAccept()
    {
        AssetRequestAccept assetrequestaccept = new AssetRequestAccept(test);
        assetrequestaccept.testAssetRequestAccept();
    }
    @Test(priority = 3)
    public void assetRequestEdit()
    {
        AssetTransferEdit initedit =  new AssetTransferEdit(test);
        initedit.assetTransferEdit();
    }
    @Test(priority = 4)
    public void assetTransferRevoke()
    {
        AssetTransferRevoke initrevoke = new AssetTransferRevoke(test);
        initrevoke.testRevokeAsset();
        extent.flush();
    }
}
