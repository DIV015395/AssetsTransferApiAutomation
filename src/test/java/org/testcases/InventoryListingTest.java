package org.testcases;
import org.testng.annotations.Test;
public class InventoryListingTest
{
    @Test
    public void inventoryListing()
    {
      org.testcases.InventoryListings obj = new org.testcases.InventoryListings();
       obj.inventory();
    }
}
