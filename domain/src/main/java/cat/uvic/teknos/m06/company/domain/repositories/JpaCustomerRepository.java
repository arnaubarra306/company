package cat.uvic.teknos.m06.company.domain.repositories;

import cat.uvic.teknos.m06.company.domain.models.Customer;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaCustomerRepository implements Repository<Customer,Integer>{
    private final EntityManagerFactory entityManagerFactory;

    public  JpaCustomerRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Customer cust) {
        if(cust.getId() <= 0){
            insert(cust);
        }else{
            update(cust);
        }

    }

    private void update(Customer cust) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(cust);
        entityManager.getTransaction().commit();
    }

    private void insert(Customer cust) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cust);
        entityManager.getTransaction().commit();
    }


    @Override
    public void delete(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var cust = entityManager.find(Customer.class, id);
        if(cust != null) {
            entityManager.remove(cust);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Customer getById(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        var cust = entityManager.find(Customer.class, id);
        entityManager.close();
        return  cust;
    }

    @Override
    public List<Customer> getAll() {
        var entityManager = entityManagerFactory.createEntityManager();
        var query = entityManager.createQuery("SELECT cust FROM Customer cust");
        return query.getResultList();
    }


}
