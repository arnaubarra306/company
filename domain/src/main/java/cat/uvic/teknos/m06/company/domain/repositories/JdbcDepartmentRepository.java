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
    public void save(Department worker) {
        if (worker == null) {
            throw new RepositoryException("The products is null!");
        }
        if (worker.getDeptNo() <= 0) {
            insert(JdbcDepartmentRepository.Customer);
        } else {
            update(worker);
        }
    }


    private void update(Department worker) {
        try (var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, worker.getName());
            preparedStatement.setInt(1, worker.getDeptNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + worker, e);
        }

    }

    private void insert(Department worker) {
        try (var preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, worker.getName());
            preparedStatement.executeUpdate();
            var generatedKeysResultSet = preparedStatement.getGeneratedKeys();
            if (!generatedKeysResultSet.next()) {
                throw new RepositoryException("Exception while inserting: id not generated" + worker);
            }
            worker.setDeptNo(generatedKeysResultSet.getInt(1));
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + worker, e);
        }
    }

    public void delete(Department worker) {}

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
                var cust = new Department();
                cust.setDeptNo(resultSet.getInt("10"));
                cust.setName(resultSet.getString("Office"));
                cust.addS(cust);
            }

            return Department;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing get all");
        }
    }
}