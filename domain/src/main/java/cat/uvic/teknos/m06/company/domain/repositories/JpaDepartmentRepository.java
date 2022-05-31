package cat.uvic.teknos.m06.company.domain.repositories;

import cat.uvic.teknos.m06.company.domain.models.Department;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaDepartmentRepository implements Repository<Department,Integer>{
    private final EntityManagerFactory entityManagerFactory;

    public JpaDepartmentRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Department dept) {
        if(dept.getId() <= 0){
            insert(dept);
        }else{
            update(dept);
        }

    }

    private void update(Department dept) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(dept);
        entityManager.getTransaction().commit();
    }

    private void insert(Department dept) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(dept);
        entityManager.getTransaction().commit();
    }


    @Override
    public void delete(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        var dept = entityManager.find(Department.class, id);
        if(dept != null) {
            entityManager.remove(dept);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Department getById(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        var dept = entityManager.find(Department.class, id);
        entityManager.close();
        return  entityManager.find(Department.class, id);
    }

    @Override
    public List<Department> getAll() {
        var entityManager = entityManagerFactory.createEntityManager();
        var query = entityManager.createQuery("SELECT dept FROM Department dept");
        return query.getResultList();
    }


}
