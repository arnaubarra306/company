package cat.uvic.teknos.m06.company.domain.WorkerTest;

import cat.uvic.teknos.m06.company.domain.models.Worker;
import cat.uvic.teknos.m06.company.domain.repositories.JpaWorkerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class JpaWorkerRepositoryTest {
    public static final int MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static JpaWorkerRepository repository;

    @BeforeAll
    static void setUp(){
        entityManagerFactory = Persistence.createEntityManagerFactory("company_mysql");
        repository = new JpaWorkerRepository(entityManagerFactory);


    }
    @Test
     void save(){
        var entityManagerFactory = Persistence.createEntityManagerFactory("company");
        var repository = new JpaWorkerRepository(entityManagerFactory);

        var worker = new Worker();
        worker.setSurname("Barra");

        assertDoesNotThrow(() -> {
            repository.save(worker);
        });

        assertTrue(worker.getId() >0);

    }

    @Test
    void saveUpdate() {
        var worker = new Worker();
        worker.setId(1);
        worker.setSurname("Barra");

        assertDoesNotThrow(() -> {
            repository.save(worker);
        });

        var entityManager = entityManagerFactory.createEntityManager();
        var modifiedCompany = entityManager.find(Worker.class,1 );

        assertEquals("Barra", modifiedCompany.getSurname());
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
        var worker = repository.getById(2);

        assertNotNull(worker);
    }
    @Test
    void getAll(){
        var worker = repository.getAll();

        assertNotNull(worker);
        assertTrue(worker.size() >0);
    }


}
