//initiated => Edit ==> Revoke

package org.testcase;
import org.example.AssetTransferEdit;
import org.example.AssetTransferInitiated;
import org.example.AssetTransferInitiatedRevoke;
import org.testng.annotations.Test;

public class InitiatedEditRevoke {
    @Test(priority = 1)
    public void assetTransferInitiated()
    {
        AssetTransferInitiated initiate =  new AssetTransferInitiated();
        initiate.testAssetTransfer();
    }
    @Test(priority = 2)
    public void assetTransferEdit()
    {
        AssetTransferEdit initedit =  new AssetTransferEdit();
        initedit.assetTransferEdit();

    }
    @Test(priority = 3)
    public void assetTransferRevoke()
    {
        AssetTransferInitiatedRevoke initrevoke = new AssetTransferInitiatedRevoke();
        initrevoke.testRevokeAsset();

    }

}
