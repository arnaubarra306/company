package cat.uvic.teknos.m06.company.domain.repositories;

import cat.uvic.teknos.m06.company.domain.models.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerRepository implements Repository<Customer, Integer>{
    private static final String INSERT = "insert into products (name) values (?)";
    private static final String UPDATE = "update products set name = ? where id = ?";
    private static final String SELECT_ALL = "select id, name from products";
    private static final int worker = 1000;
    private static final List<Customer> Customer = null;
    private static Customer customer;
    private final Connection connection;

    public JdbcCustomerRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Customer worker) {
        if (worker == null) {
            throw new RepositoryException("The products is null!");
        }
        if (worker.getCode() <= 0) {
            insert(JdbcCustomerRepository.customer);
        } else {
            update(worker);
        }
    }


    private void update(Customer customer) {
        try (var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(1, customer.setCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + customer, e);
        }

    }

    private void insert(Customer customer) {
        try (var preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.executeUpdate();
            var generatedKeysResultSet = preparedStatement.getGeneratedKeys();
            if (!generatedKeysResultSet.next()) {
                throw new RepositoryException("Exception while inserting: id not generated" + customer);
            }
            customer.setCode();
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + customer, e);
        }
    }

    public void delete(Customer customer) {}

    @Override
    public Customer getById(Integer id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        var products = new ArrayList<Customer>();
        try (var statement = connection.createStatement()) {
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                var cust = new Customer();
                cust.setCode();
                cust.setName(resultSet.getString("SURNAME"));
                cust.addS(cust);
            }

            return Customer;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing get all");
        }
    }
}