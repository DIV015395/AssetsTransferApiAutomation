package org.testcase;

import org.example.AssetRequestAccept;
import org.example.AssetTransferInitiated;
import org.example.AssetTransferInitiatedRevoke;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssetTransferInitiatedRequestAccept
{
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        AssetTransferInitiated initiate =  new AssetTransferInitiated();
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void RequestAccept()
    {
        AssetRequestAccept assetrequestaccept = new AssetRequestAccept();
        assetrequestaccept.testAssetRequestAccept();
    }
    @AfterTest
    public void assetTransferRevoke()
    {
        AssetTransferInitiatedRevoke initrevoke = new AssetTransferInitiatedRevoke();
        initrevoke.testRevokeAsset();
    }
}
