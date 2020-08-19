package pl.adambaranowski.jparelationsonetomany.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional
public abstract class GenericDao<T, K> {
    @PersistenceContext
    public EntityManager entityManager;
    private Class<T> type;

    @SuppressWarnings("unchecked")
    GenericDao(){
        type = (Class<T>)((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void save(T entity){
        if(entityManager != null)
            System.out.println("generic Entity manager != null");
        entityManager.persist(entity);
    }

    public T get(K key){
        T find = entityManager.find(type, key);
        return find;
    }

    public void remove(T entity){
        T managedEntity = entityManager.merge(entity);
        entityManager.remove(managedEntity);
    }
}
