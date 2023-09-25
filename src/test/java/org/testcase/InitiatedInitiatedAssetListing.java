package org.testcase;

import org.example.AssetTransferInitiated;
import org.example.AssetTransferInitiatedRevoke;
import org.example.InitiatedAssetListing;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InitiatedInitiatedAssetListing {
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        AssetTransferInitiated initiate =  new AssetTransferInitiated();
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void initiatedAssetListing()
    {
        InitiatedAssetListing assetlisting = new InitiatedAssetListing();
        assetlisting.testGetInitiatedAssets();

    }
    @AfterTest
    public void assetTransferRevoke()
    {
        AssetTransferInitiatedRevoke initrevoke = new AssetTransferInitiatedRevoke();
        initrevoke.testRevokeAsset();
    }
}
