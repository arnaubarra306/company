package cat.uvic.teknos.m06.company.utilities;
import cat.uvic.teknos.m06.company.utilities.xml.ConnectionProperties;
import cat.uvic.teknos.m06.company.utilities.xml.SingleLineCommandSchemaLoader;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SingleLineCommandSchemaLoaderTest {

    @Test
    void load() {
        var connectionProperties = new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUsername("root");

        var schemaLoader = new SingleLineCommandSchemaLoader("src/test/resources/singleLineSchema.txt", connectionProperties);

        assertDoesNotThrow(() -> {
            schemaLoader.load();
        });
    }
}