//initiated => Edit ==> Revoke

package org.testcase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetTransferEdit;
import org.example.AssetTransferInitiated;
import org.example.AssetTransferRevoke;
import org.example.ExtentManager;
import org.testng.annotations.Test;

public class InitiatedEditRevoke {
    private ExtentReports extent;
    private ExtentTest test;
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Initiate => Edit => Revoke ", "Transfer Initiated by I.T user, \nEdit By I.T User ,\nRevoke by I.T user");
        AssetTransferInitiated initiate =  new AssetTransferInitiated(test);
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void assetTransferEdit()
    {
        AssetTransferEdit initedit =  new AssetTransferEdit(test);
        initedit.assetTransferEdit();

    }
    @Test(priority = 3)
    public void assetTransferRevoke()
    {
        AssetTransferRevoke initrevoke = new AssetTransferRevoke(test);
        initrevoke.testRevokeAsset();
        extent.flush();

    }

}
