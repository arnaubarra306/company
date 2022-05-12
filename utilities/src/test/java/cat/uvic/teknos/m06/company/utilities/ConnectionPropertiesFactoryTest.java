package cat.uvic.teknos.m06.company.utilities;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionPropertiesFactoryTest {

    @Test
    void get() {
    }

    @Test
    void save() {
        var file = new File("src/test/resources/connectionProperties.xml");
        if (file.exists()) {
            file.delete();
        }

        var properties = new ConnectionProperties();
        properties.setUrl("jdbc:....");
        properties.setUsername("root");
        properties.setPassword(("1qaz2wsx"));

        var factory = new ConnectionPropertiesFactory();
        factory.save(properties);

        assertTrue(new File("src/test/resources/connectionProperties.xml").exists());
    }
}