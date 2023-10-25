package org.loadtesting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.AssetInventoryFilter;
import org.example.ExtentManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed number of threads
        int numThreads = 500; // You can adjust this based on your requirements
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        ExtentReports extent;
        ExtentTest test;
        extent = ExtentManager.getInstance();
        test = extent.createTest("I.T Asset Inventory Filter And Search", "I.T Asset Inventory Filter And Search");
        for (int i = 0; i < numThreads; i++) {
            executorService.submit(() -> {
                AssetInventoryFilter obj = new AssetInventoryFilter(test);
                obj.inventoryListingFilterStatusDamaged();
                obj.inventoryListingFilterStatusWorking();
                obj.inventoryListingSearchByCode();
                obj.inventoryListingSearchByName();
                obj.inventoryListingSearchBySerial();
                obj.inventoryListingUsingFilterCategory();
                extent.flush();
            });
        }
        executorService.shutdown();
    }
}
