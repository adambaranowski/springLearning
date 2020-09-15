package pl.adambaranowski.devicerent.dao;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.devicerent.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer read(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void delete(Customer customer) {
        Customer toRemove = entityManager.find(Customer.class, customer.getId());
        entityManager.remove(toRemove);
    }
}
