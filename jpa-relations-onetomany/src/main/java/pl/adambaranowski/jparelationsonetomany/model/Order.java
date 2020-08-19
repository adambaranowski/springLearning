package pl.adambaranowski.jparelationsonetomany.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
//    @Column(nullable = false)
//    private String product;
    @Column(name = "details", length = 512)
    private String orderDetails;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany(fetch = FetchType.EAGER,
    cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "order_products",
    joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id_order")},
    inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id_product")})
    private List<Product> products = new ArrayList<>();

    Order() {
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
    }
//    public Order(String product, String orderDetails) {
//        this.product = product;
//        this.orderDetails = orderDetails;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDetails='" + orderDetails + '\'' +
                ", client=" + client.getFirstName() +
                ", products=" + products +
                '}';
    }
}
