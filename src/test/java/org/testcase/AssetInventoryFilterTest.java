package org.testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.AssetInventoryFilter;
import org.example.ExtentManager;
import org.testng.annotations.Test;

public class AssetInventoryFilterTest
{
  public ExtentReports extent;
  public ExtentTest test;
@Test
  public void assetInventoryFilterTest()
  {
    extent = ExtentManager.getInstance();
    test = extent.createTest("I.T Asset Inventory Filter And Search", "I.T Asset Inventory Filter And Search");
    AssetInventoryFilter obj = new AssetInventoryFilter(test);
    obj.inventoryListingFilterStatusDamaged();
    obj.inventoryListingFilterStatusWorking();
    obj.inventoryListingSearchByCode();
    obj.inventoryListingSearchByName();
    obj.inventoryListingSearchBySerial();
    obj.inventoryListingUsingFilterCategory();
    extent.flush();
   }
}
