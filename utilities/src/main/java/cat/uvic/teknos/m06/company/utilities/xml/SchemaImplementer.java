package cat.uvic.teknos.m06.company.utilities.xml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.sql.*;


public class  SchemaImplementer implements SchemaLoader {
    @Override
    public void load() {
    // First, do the connection to the database
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root",null);

    //Read the schema.sql
            Statement stmt=con.createStatement();

            var inputStream = new BufferedReader(new FileReader("resources/CommandLoader.csv", Charset.forName("utf-8")));

            while(inputStream.readLine()!= null)

            con.close();
            ResultSet rs=stmt.executeQuery("select * from emp");
        }catch(Exception e){ System.out.println(e);}


    //Do the commands on the database
    }
}
