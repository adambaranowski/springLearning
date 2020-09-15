package pl.adambaranowski.devicerent.dao;

import pl.adambaranowski.devicerent.model.Customer;

public interface CustomerDao {
    void create(Customer customer);
    Customer read(Long id);
    void update(Customer customer);
    void delete(Customer customer);
}
