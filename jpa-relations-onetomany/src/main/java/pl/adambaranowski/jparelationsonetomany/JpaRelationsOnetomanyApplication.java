package pl.adambaranowski.jparelationsonetomany;

import org.aspectj.weaver.ast.Or;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adambaranowski.jparelationsonetomany.dao.ClientDao;
import pl.adambaranowski.jparelationsonetomany.dao.OrderDao;
import pl.adambaranowski.jparelationsonetomany.dao.ProductDao;
import pl.adambaranowski.jparelationsonetomany.model.Client;
import pl.adambaranowski.jparelationsonetomany.model.Order;
import pl.adambaranowski.jparelationsonetomany.model.Product;

@SpringBootApplication
public class JpaRelationsOnetomanyApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(JpaRelationsOnetomanyApplication.class, args);

//        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
//        ClientDao clientDao = ctx.getBean(ClientDao.class);
//        clientDao.save(client);
//        //System.out.println(client);
//
//        Order order = new Order( "42', dostawa do domu");
//        order.setClient(client);
//        OrderDao orderDao = ctx.getBean(OrderDao.class);
//        orderDao.save(order);
//
//        Order getOrder = orderDao.get(1L);
//        System.out.println(getOrder);
//
//        Client getClient = clientDao.get(1L);
//        System.out.println(getClient);
//
//
//        //MANY TO MANY//
//
//        Order order1 = new Order("z dostawą do domu");
//        order1.setClient(client);
//        orderDao.save(order1);
//
//        Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
//        Product product2 = new Product("Telefon APple iPhone SE", 2200.0, "pokrowiec gratis");
//        ProductDao productDao = ctx.getBean(ProductDao.class);
//        productDao.save(product1);
//        productDao.save(product2);
//
//        orderDao.addProductsToOrder(order1.getId(), product1, product2);

        //OPERACJE KASKADOWE//

        System.out.println("######");

        Client client = new Client("Jan", "Kowalski", "Krakowskie przedmieście 23, Warszawa");
        Order order = new Order("z dostawą do domu");
        Product product1 = new Product("Telewizor LG 42'", 4800.0, "dolby surround");
        Product product2 = new Product("Telefon Apple iPhone SE", 2200.0, "pokrowiec gratis");
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        client.addOrder(order);

        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);

        Client getClient = clientDao.get(client.getId());
        System.out.println(getClient);
        System.out.println("######");

        ProductDao productDao = ctx.getBean(ProductDao.class);

        System.out.println(productDao.getAll());

        System.out.println("oooo");
        System.out.println(productDao.getByName("Telewizor LG 42'"));
        System.out.println("oooo");

        clientDao.remove(client);

        ctx.close();
    }

}
