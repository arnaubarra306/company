package cat.uvic.teknos.m06.company.utilities;

import org.junit.jupiter.api.Test;

import cat.uvic.teknos.m06.company.utilities.xml.XmlSchemaLoader;

import static org.junit.jupiter.api.Assertions.*;

class XmlSchemaLoaderTest {

    @Test
    void load() {
        var schemaLoader = new XmlSchemaLoader("src/test/resources/schema.xml");

        assertDoesNotThrow(() -> {
            schemaLoader.load();
        });
    }
}