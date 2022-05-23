package cat.uvic.teknos.m06.company.domain.repositories;

import cat.uvic.teknos.m06.company.domain.models.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDepartmentRepository implements Repository<Department, Integer>{
    private static final String INSERT = "insert into products (name) values (?)";
    private static final String UPDATE = "update products set name = ? where id = ?";
    private static final String SELECT_ALL = "select id, name from products";
    private static final int worker = 1000;
    private static final List<Department> Department = null;
    private static Department Customer;
    private final Connection connection;

    public JdbcDepartmentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Department department) {
        if (department == null) {
            throw new RepositoryException("The products is null!");
        }
        if (department.getDeptNo() <= 0) {
            insert(JdbcDepartmentRepository.Customer);
        } else {
            update(department);
        }
    }


    private void update(Department department) {
        try (var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(1, department.getDeptNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + department, e);
        }

    }

    private void insert(Department department) {
        try (var preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();
            var generatedKeysResultSet = preparedStatement.getGeneratedKeys();
            if (!generatedKeysResultSet.next()) {
                throw new RepositoryException("Exception while inserting: id not generated" + department);
            }
            department.setDeptNo(generatedKeysResultSet.getInt(1));
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + department, e);
        }
    }

    public void delete(Department department) {}

    @Override
    public Department getById(Integer id) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        var products = new ArrayList<Department>();
        try (var statement = connection.createStatement()) {
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                var department = new Department();
                department.setDeptNo(resultSet.getInt("10"));
                department.setName(resultSet.getString("Office"));
                department.addS(department);
            }

            return Department;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing get all");
        }
    }
}