package pl.adambaranowski.jparelationsonetomany.dao;

import org.springframework.stereotype.Repository;
import pl.adambaranowski.jparelationsonetomany.model.Order;
import pl.adambaranowski.jparelationsonetomany.model.Product;

import javax.transaction.Transactional;


@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {
//    @Override
//    public Order get(Long key) {
//        Order geted = super.get(key);
//        //geted.getClient();
//        return geted;
//    }
    public void addProductsToOrder(Long orderId, Product... products){
        Order order = get(orderId);
        if(order!=null){
            for (Product product : products){
                order.getProducts().add(product);
            }
        }
    }
}
