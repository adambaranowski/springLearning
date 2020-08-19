package com.adambaranowski.jpaspringboot.dao;

import com.adambaranowski.jpaspringboot.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(Long id);
    public void update(Book book);
    public void remove(Long bookId);
}
