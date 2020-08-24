package pl.adambaranowski.jparelationsonetomany.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.adambaranowski.jparelationsonetomany.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class ProductDao extends GenericDao<Product, Long>{

    public List<Product> getAll() {
        TypedQuery<Product> getAllQuery =
                entityManager.createNamedQuery("Product.findAll", Product.class);
        List<Product> resultList = getAllQuery.getResultList();
        return resultList;

    }

    public List<Product> findByName(String name){
        TypedQuery<Product> find = entityManager
                .createNamedQuery(Product.FIND_BY_NAME, Product.class);
        find.setParameter(Product.PARAM_NAME, "imie do wyszukania");
        List<Product> result = find.getResultList();
        return result;
    }

    public void deleteAll() {
        Query deleteAllQuery = entityManager.createNamedQuery("Product.deleteAll");
        deleteAllQuery.executeUpdate();
    }

    public List<Product> getByName(String name){
        TypedQuery<Product> query =
                entityManager.createNamedQuery("Product.findByName", Product.class);
        query.setParameter("name", name);
        List<Product> resultList = query.getResultList();
        return resultList;
    }

}
