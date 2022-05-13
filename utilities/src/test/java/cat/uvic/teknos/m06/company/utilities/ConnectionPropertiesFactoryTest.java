package cat.uvic.teknos.m06.company.utilities;

import cat.uvic.teknos.m06.company.utilities.xml.ConnectionProperties;
import cat.uvic.teknos.m06.company.utilities.xml.ConnectionPropertiesFactory;
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
        properties.setPassword(("null"));

        var factory = new ConnectionPropertiesFactory();
        factory.save(properties);

        assertTrue(new File("src/test/resources/connectionProperties.xml").exists());
    }
}