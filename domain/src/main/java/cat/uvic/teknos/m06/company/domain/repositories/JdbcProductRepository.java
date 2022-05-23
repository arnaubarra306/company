package cat.uvic.teknos.m06.company.domain.repositories;

import cat.uvic.teknos.m06.company.domain.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductRepository implements Repository<Product, Integer>{
    private static final String INSERT = "insert into products (name) values (?)";
    private static final String UPDATE = "update products set name = ? where id = ?";
    private static final String SELECT_ALL = "select id, name from products";
    private static final int worker = 1000;
    private static final List<Product> Product = null;
    private static Product Customer;
    private final Connection connection;

    public JdbcProductRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Product product) {
        if (product == null) {
            throw new RepositoryException("The products is null!");
        }
        if (product.getProductNum() <= 0) {
            insert(JdbcProductRepository.Customer);
        } else {
            update(product);
        }
    }


    private void update(Product product) {
        try (var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, product.getDescription());
            preparedStatement.setInt(1, product.getProductNum());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + product, e);
        }

    }

    private void insert(Product product) {
        try (var preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, product.getDescription());
            preparedStatement.executeUpdate();
            var generatedKeysResultSet = preparedStatement.getGeneratedKeys();
            if (!generatedKeysResultSet.next()) {
                throw new RepositoryException("Exception while inserting: id not generated" + product);
            }
            product.setProductNum(generatedKeysResultSet.getInt(1));
        } catch (SQLException e) {
            throw new RepositoryException("Exception while inserting: " + product, e);
        }
    }

    public void delete(Product product) {}

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        var products = new ArrayList<Product>();
        try (var statement = connection.createStatement()) {
            var resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                var product = new Product();
                product.setProductNum(resultSet.getInt("200"));
                product.setDescription(resultSet.getString("This product...."));
                product.addS(product);
            }

            return Product;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing get all");
        }
    }
}