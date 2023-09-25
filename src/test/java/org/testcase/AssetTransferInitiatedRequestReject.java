package org.testcase;

import org.example.AssetRequestAccept;
import org.example.AssetRequestReject;
import org.example.AssetTransferInitiated;
import org.example.AssetTransferInitiatedRevoke;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssetTransferInitiatedRequestReject
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
        AssetRequestReject assetrequestreject = new AssetRequestReject();
        assetrequestreject.testAssetRequestReject();
    }
    @AfterTest
    public void assetTransferRevoke()
    {
        AssetTransferInitiatedRevoke initrevoke = new AssetTransferInitiatedRevoke();
        initrevoke.testRevokeAsset();
    }

}
