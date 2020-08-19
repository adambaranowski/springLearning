package pl.adambaranowski.jparelationsonetomany.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String address;

    //gdy relacja many to one w order
    @OneToMany(mappedBy = "client",
            fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
    orphanRemoval = true)
    //gdy sama relacja one to many
    //@OneToMany
    //@JoinColumn(name = "client_id", referencedColumnName = "id_client")
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        order.setClient(this);
        getOrders().add(order);
    }

//    W przypadku relacji jednostronnej można dodatkowo zdefiniować
//    adnotację @JoinColumn określając nazwę kolumny (name),
//    która znajdzie się w tabeli właściciela relacji
//            (czyli client_order) oraz nazwę kolumny klucza
//    głównego z tabeli, w której tę relację stosujemy, czyli w
//    naszym przypadku id_client. Własność name może być więc
//    dowolna. Należy tutaj uważać na to, że tym razem posługujemy
//    się nazwami kolumn, a nie pól encji. W przypadku pominięcia
//    adnotacji @JoinColumn hibernate wygeneruje
//    dodatkową tabelę pośrednią zawierającą klucze z obu tabel.

    Client(){}

    public Client(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", orders="  + orders.size() + orders+
                '}';
    }
}
