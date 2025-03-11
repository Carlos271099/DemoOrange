package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {



    public static String getProperty(String key) throws IOException {
        //String rootPath = Thread.currentThread().getContextClassLoader().getResource("//resources//").getPath();
        //String configPath = rootPath + "application.properties";

        String path = "org/example/resources/application.properties";
        InputStream is = ReadProperties.class.getClassLoader().getResourceAsStream(path);

        Properties props = new Properties();
        props.load(is);
        //props.load(new FileInputStream("application.properties"));

        return props.getProperty(key);
    }

    public static String getUserApp() throws IOException {
        return getProperty("user.name");
    }

    public static String getUserPass() throws IOException {
        return getProperty("user.pass");
    }
}
