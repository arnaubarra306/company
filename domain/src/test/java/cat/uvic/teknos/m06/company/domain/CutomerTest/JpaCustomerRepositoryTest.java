package cat.uvic.teknos.m06.company.domain.CutomerTest;

import cat.uvic.teknos.m06.company.domain.models.Customer;
import cat.uvic.teknos.m06.company.domain.repositories.JpaCustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class JpaCustomerRepositoryTest {
    public static final int MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static JpaCustomerRepository repository;

    @BeforeAll
    static void setUp(){
        entityManagerFactory = Persistence.createEntityManagerFactory("company_mysql");
        repository = new JpaCustomerRepository(entityManagerFactory);


    }
    @Test
     void save(){
        var entityManagerFactory = Persistence.createEntityManagerFactory("company");
        var repository = new JpaCustomerRepository(entityManagerFactory);

        var customer = new Customer();
        customer.setName("Arnau");

        assertDoesNotThrow(() -> {
            repository.save(customer);
        });

        assertTrue(customer.getId() >0);

    }

    @Test
    void saveUpdate() {
        var cust = new Customer();
        cust.setId(1);
        cust.setName("Arnau");

        assertDoesNotThrow(() -> {
            repository.save(cust);
        });

        var entityManager = entityManagerFactory.createEntityManager();
        var modifiedCompany = entityManager.find(Customer.class,1 );

        assertEquals("Arnau", modifiedCompany.getName());
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
        var cust = repository.getById(2);

        assertNotNull(cust);
    }
    @Test
    void getAll(){
        var cust = repository.getAll();

        assertNotNull(cust);
        assertTrue(cust.size() >0);
    }


}
