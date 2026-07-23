package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	static Properties properties;
	static String path = "src/test/resources/config.properties";

    static {

        try(FileInputStream file = new FileInputStream(path)) {

            properties = new Properties();
            properties.load(file);

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String getProperty(String key) {

        return properties.getProperty(key);

    }
}