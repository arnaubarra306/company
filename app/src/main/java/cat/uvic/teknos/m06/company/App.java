package cat.uvic.teknos.m06.company;

import cat.uvic.teknos.m06.company.utilities.xml.SchemaLoader;
import cat.uvic.teknos.m06.company.utilities.xml.SingleLineCommandSchemaLoader;
import cat.uvic.teknos.m06.company.utilities.xml.XmlSchemaLoader;

public class App {
    public static void main(String[] args)  {

        loadSchema(new SingleLineCommandSchemaLoader("company", null));
        loadSchema(new XmlSchemaLoader(""));
    }

    private static void loadSchema(SchemaLoader schemaloader) {
       schemaloader.load();
    }
}




