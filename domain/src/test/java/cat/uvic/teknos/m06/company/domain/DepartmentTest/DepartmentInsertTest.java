package cat.uvic.teknos.m06.company.domain.DepartmentTest;
import cat.uvic.teknos.m06.company.domain.models.Department;
import cat.uvic.teknos.m06.company.domain.repositories.JdbcCustomerRepository;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DepartmentInsertTest {
    @Test void DepartmentInsertTest() throws SQLException {
            var Department = new Department();
            Department.setName("Sellers");
            Department.setDeptNo(Integer.valueOf("12123"));
            var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root",null);
            var jdbcEmployeeRepository = new JdbcCustomerRepository(connection);
            jdbcEmployeeRepository.save(Department);
    }
}
