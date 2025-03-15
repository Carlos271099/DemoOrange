package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadProperties {
    //This class is for read properties like usernames,passwords etc.. and we just call one method to access to some property
    //This is so helpful cause we only need to change something in there to do some modifications
    private static final Properties properties = new Properties();


    public static String getProperty(String key) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get("src/main/java/org/example/resources/config.properties"));
        properties.load(inputStream);

        return properties.getProperty(key);
    }

    public static String getUserNameAdmin() throws IOException {
        return getProperty("userNameAdmin");
    }

    public static String getUserPassAdmin() throws IOException {
        return getProperty("userPassAdmin");
    }

    public static String getEmployeeUser() throws IOException {
        return getProperty("employeeUser");
    }

    public static String getEmployeePass() throws IOException {
        return getProperty("employeePass");
    }

    public static String getEmployeeFullName() throws IOException {
        return getProperty("employeeFullName");
    }

    public static String getEmployeeName() throws IOException {
        return getProperty("employeeName");
    }


}
