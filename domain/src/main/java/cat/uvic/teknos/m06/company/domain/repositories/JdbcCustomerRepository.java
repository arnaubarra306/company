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
    private static final int cust = 1000;
    private static final List<Customer> Cust = null;
    private static cat.uvic.teknos.m06.company.domain.models.Customer Customer;
    private final Connection connection;

    public JdbcCustomerRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Customer cust) {
        if (cust == null) {
            throw new RepositoryException("The products is null!");
        }
        if (cust.getSalary() <= 0) {
            insert(JdbcCustomerRepository.Customer);
        } else {
            update(cust);
        }
    }


    private void update(Customer cust) {
        try (var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, cust.getSurname());
            preparedStatement.setInt(1, cust.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + cust, e);
        }

    }

    private void insert(Customer cust) {
        try (var preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, cust.getSurname());
            preparedStatement.executeUpdate();
            var generatedKeysResultSet = preparedStatement.getGeneratedKeys();
            if (!generatedKeysResultSet.next()) {
                throw new RepositoryException("Exception while inserting: id not generated" + cust);
            }
            cust.setSalary(generatedKeysResultSet.getInt(1));
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + cust, e);
        }
    }

    public void delete(Customer cust) {}

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
                cust.setSalary(resultSet.getInt("SALLARY"));
                cust.setSurname(resultSet.getString("SURNAME"));
                cust.addS(cust);
            }

            return Cust;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing get all");
        }
    }
}