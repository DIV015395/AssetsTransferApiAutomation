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
    public ExtentReports extent;
    public ExtentTest test;
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Initiate , Edit , Revoke all action by I.T ", "Initiate , Edit , Revoke all action by I.T");
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
