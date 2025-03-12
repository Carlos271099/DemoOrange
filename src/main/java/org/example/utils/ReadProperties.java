package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties = new Properties();


    public static String getProperty(String key) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get("src/main/java/org/example/resources/config.properties"));
        properties.load(inputStream);

        return properties.getProperty(key);
    }

    public static String getUserName() throws IOException {
        return getProperty("userName");
    }

    public static String getUserPass() throws IOException {
        return getProperty("userPass");
    }
}
