package cat.uvic.teknos.m06.company.domain.CutomerTest;

import cat.uvic.teknos.m06.company.domain.repositories.JdbcCustomerRepository;
import org.junit.jupiter.api.Test;
import cat.uvic.teknos.m06.company.domain.models.Customer;
import org.junit.jupiter.api.Test;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerInsertTest {
    @Test void CustomerInsertTest() throws SQLException {
            var Customer = new Customer();
            Customer.setName("Arnau Barra");
            Customer.setCustomerCode(12123);
            var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root",null);
            var JdbcustomerRepository = new JdbcCustomerRepository(connection);
        JdbcustomerRepository.save(Customer);
    }
}
