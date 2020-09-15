package pl.adambaranowski.devicerent.dao;

import pl.adambaranowski.devicerent.model.Category;

public interface CategoryDao {
    void create(Category category);
    Category read(Long id);
    void update(Category category);
    void delete(Category category);
}
