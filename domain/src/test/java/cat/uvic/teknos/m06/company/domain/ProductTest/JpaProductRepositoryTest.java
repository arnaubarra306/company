package cat.uvic.teknos.m06.company.domain.ProductTest;

import cat.uvic.teknos.m06.company.domain.models.Product;
import cat.uvic.teknos.m06.company.domain.repositories.JpaProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class JpaProductRepositoryTest {
    public static final int MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static JpaProductRepository repository;
    private Product product;

    @BeforeAll
    static void setUp(){
        entityManagerFactory = Persistence.createEntityManagerFactory("company_mysql");
        repository = new JpaProductRepository(entityManagerFactory);


    }
    @Test
     void save(){
        var entityManagerFactory = Persistence.createEntityManagerFactory("company");
        var repository = new JpaProductRepository(entityManagerFactory);

        var customer = new Product();
        customer.setDescription("This product is made with...");

        assertDoesNotThrow(() -> {
            repository.save(product);
        });

        assertTrue(customer.getId() >0);

    }

    @Test
    void saveUpdate() {
        var dept = new Product();
        dept.setId(1);
        dept.setDescription("This product is made with...");

        assertDoesNotThrow(() -> {
            repository.save(dept);
        });

        var entityManager = entityManagerFactory.createEntityManager();
        var modifiedCompany = entityManager.find(Product.class,1 );

        assertEquals("This product is made with...", modifiedCompany.getDescription());
        entityManager.close();
    }

    @Test
    void delete(){

        var pop = repository.getById(MODEL_TO_DELETE);

        assertNotNull(pop);

        assertDoesNotThrow(() -> {
                repository.delete(MODEL_TO_DELETE);
        });

        pop = repository.getById(MODEL_TO_DELETE);

        assertNull(pop);



    }

    @Test
    void getById(){
        var product = repository.getById(2);

        assertNotNull(product);
    }
    @Test
    void getAll(){
        var product = repository.getAll();

        assertNotNull(product);
        assertTrue(product.size() >0);
    }


}
