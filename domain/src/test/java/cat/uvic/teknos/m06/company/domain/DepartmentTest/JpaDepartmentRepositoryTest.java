package cat.uvic.teknos.m06.company.domain.DepartmentTest;

import cat.uvic.teknos.m06.company.domain.models.Department;
import cat.uvic.teknos.m06.company.domain.repositories.JpaDepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class JpaDepartmentRepositoryTest {
    public static final int MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static JpaDepartmentRepository repository;
    private Department department;

    @BeforeAll
    static void setUp(){
        entityManagerFactory = Persistence.createEntityManagerFactory("company_mysql");
        repository = new JpaDepartmentRepository(entityManagerFactory);


    }
    @Test
     void save(){
        var entityManagerFactory = Persistence.createEntityManagerFactory("company");
        var repository = new JpaDepartmentRepository(entityManagerFactory);

        var customer = new Department();
        customer.setName("Arnau");

        assertDoesNotThrow(() -> {
            repository.save(department);
        });

        assertTrue(customer.getId() >0);

    }

    @Test
    void saveUpdate() {
        var dept = new Department();
        dept.setId(1);
        dept.setName("Office");

        assertDoesNotThrow(() -> {
            repository.save(dept);
        });

        var entityManager = entityManagerFactory.createEntityManager();
        var modifiedCompany = entityManager.find(Department.class,1 );

        assertEquals("Office", modifiedCompany.getName());
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
        var dept = repository.getById(2);

        assertNotNull(dept);
    }
    @Test
    void getAll(){
        var dept = repository.getAll();

        assertNotNull(dept);
        assertTrue(dept.size() >0);
    }


}
