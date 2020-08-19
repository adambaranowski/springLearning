package pl.adambaranowski.jparelations.dao;

import pl.adambaranowski.jparelations.model.User;

public interface UserDao {
    public void save(User user);
    public User get(Long id);
    public void update(User user);
    public void delete(User user);
}
