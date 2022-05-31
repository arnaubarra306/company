package cat.uvic.teknos.m06.company.domain.repositories;
import cat.uvic.teknos.m06.company.domain.models.Worker;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class JdbcWorkerRepository implements Repository<Worker, Integer>{
    private static final String INSERT = "insert into products (name) values (?)";
    private static final String UPDATE = "update products set name = ? where id = ?";
    private static final String SELECT_ALL = "select id, name from products";
    private static final int worker = 1000;
    private static final List<Worker> Worker = null;
    private static Worker Customer;
    private final Connection connection;

    public JdbcWorkerRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Worker worker) {
        if (worker == null) {
            throw new RepositoryException("The products is null!");
        }
        if (worker.getSalary() <= 0) {
            insert(JdbcWorkerRepository.Customer);
        } else {
            update(worker);
        }
    }

    @Override
    public void delete(Integer model) {

    }


    private void update(Worker worker) {
        try (var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, worker.getSurname());
            preparedStatement.setInt(1, worker.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + worker, e);
        }

    }

    private void insert(Worker worker) {
        try (var preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, worker.getSurname());
            preparedStatement.executeUpdate();
            var generatedKeysResultSet = preparedStatement.getGeneratedKeys();
            if (!generatedKeysResultSet.next()) {
                throw new RepositoryException("Exception while inserting: id not generated" + worker);
            }
            worker.setSalary(generatedKeysResultSet.getInt(1));
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + worker, e);
        }
    }

    public void delete(int worker) {}

    @Override
    public Worker getById(Integer id) {
        return null;
    }

    @Override
    public List<Worker> getAll() {
        var products = new ArrayList<Worker>();
        try (var statement = connection.createStatement()) {
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                var cust = new Worker();
                cust.setSalary(resultSet.getInt("SALLARY"));
                cust.setSurname(resultSet.getString("SURNAME"));
                cust.addS(cust);
            }

            return Worker;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing get all");
        }
    }
}