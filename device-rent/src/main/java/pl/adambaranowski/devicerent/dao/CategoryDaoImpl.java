package pl.adambaranowski.devicerent.dao;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.devicerent.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category read(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public void delete(Category category) {
        Category toRemove = entityManager.find(Category.class, category.getId());
        entityManager.remove(toRemove);
    }
}
