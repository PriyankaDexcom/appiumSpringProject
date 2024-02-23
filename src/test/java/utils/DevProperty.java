package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DevProperty {

    public Properties getDevProperty() throws IOException {
        Properties properties;
        properties = getPropertyFile("dev.properties");
        return properties;
    }

    Properties getPropertyFile(String fileName) throws IOException {
        Properties properties = new Properties();
        // Obtain InputStream for the file using the current thread's context class loader
        InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        if (stream!=null){
            try {
                properties.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                stream.close();
            }
        } else {
            System.out.println("File Not Found : " + fileName);
        }

        return properties;
    }

}
