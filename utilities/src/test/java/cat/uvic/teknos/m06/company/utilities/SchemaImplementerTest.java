package cat.uvic.teknos.m06.company.utilities;

import cat.uvic.teknos.m06.company.utilities.xml.SchemaImplementer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchemaImplementerTest {

    @Test
    void load() {
        var schemaImplementer=new SchemaImplementer();
        schemaImplementer.load();
    }
}