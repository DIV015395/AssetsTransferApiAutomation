package org.testcase;

import org.example.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssetRequestRejectTryEdit
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
    @Test(priority = 3)
    public void assetRequestEdit()
    {
        AssetTransferEdit initedit =  new AssetTransferEdit();
        initedit.assetTransferEdit();
    }
    @AfterTest
    public void assetTransferRevoke()
    {
        AssetTransferInitiatedRevoke initrevoke = new AssetTransferInitiatedRevoke();
        initrevoke.testRevokeAsset();
    }
}
