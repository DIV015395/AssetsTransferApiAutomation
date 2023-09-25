package org.testcase;

import org.example.AssetInventoryListing;
import org.testng.annotations.Test;

public class AssetInventoryListingTest {
    @Test
    public void testStatusCodeReponseBody()
    {
        AssetInventoryListing obj = new AssetInventoryListing();
        obj.testInventoryListing();
    }
}
