package org.testcase;

import org.example.AssetInventoryListing;
import org.example.DoctorSideAssetListing;
import org.testng.annotations.Test;

public class DoctorSideAssetListingTest {
    @Test
    public void testStatusCodeReponseBody()
    {
        DoctorSideAssetListing list = new DoctorSideAssetListing();
        list.testDoctorSideAssetListing();

    }
}
