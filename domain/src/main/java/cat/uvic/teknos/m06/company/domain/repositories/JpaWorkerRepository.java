package cat.uvic.teknos.m06.company.domain.repositories;

import cat.uvic.teknos.m06.company.domain.models.Worker;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaWorkerRepository implements Repository<Worker,Integer>{
    private final EntityManagerFactory entityManagerFactory;

    public JpaWorkerRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Worker worker) {
        if(worker.getId() <= 0){
            insert(worker);
        }else{
            update(worker);
        }

    }

    private void update(Worker worker) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(worker);
        entityManager.getTransaction().commit();
    }

    private void insert(Worker worker) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(worker);
        entityManager.getTransaction().commit();
    }


    @Override
    public void delete(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var worker = entityManager.find(Worker.class, id);
        if(worker != null) {
            entityManager.remove(worker);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Worker getById(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        var product = entityManager.find(Worker.class, id);
        entityManager.close();
        return  entityManager.find(Worker.class, id);
    }

    @Override
    public List<Worker> getAll() {
        var entityManager = entityManagerFactory.createEntityManager();
        var query = entityManager.createQuery("SELECT worker FROM Worker worker");
        return query.getResultList();
    }


}
