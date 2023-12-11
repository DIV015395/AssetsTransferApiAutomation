package org.storedatainpropertiesfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader
{
    private static Properties properties = new Properties();
    static String propertiesFilePath = "C:\\Users\\ManjeetSharma\\Downloads\\AssetsTransferApiAutomation\\resources\\jwt.properties";
    public static void saveTokenToProperties(String objectname ,String jwtToken)
    {
        try (FileInputStream input = new FileInputStream(propertiesFilePath))
        {
            properties.load(input);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        properties.setProperty(objectname, jwtToken);
        try (FileOutputStream output = new FileOutputStream(propertiesFilePath))
        {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
