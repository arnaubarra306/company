package cat.uvic.teknos.m06.company.domain.repositories;
import java.util.List;

public interface Repository<T, K> {
    void save(T model );
    void delete(K model);
    T getById(K id);
    List<T> getAll();
}
