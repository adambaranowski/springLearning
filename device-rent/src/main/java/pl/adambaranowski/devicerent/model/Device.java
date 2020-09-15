package pl.adambaranowski.devicerent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Device implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device")
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "devices", cascade = CascadeType.PERSIST)
    private List<Customer> customers = new ArrayList<>();

    public Device() {
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCategory(Category category){
        setCategory(category);
        category.getDevices().add(this);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        customer.getDevices().add(this);
    }

    public Device(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Device(String name, String description, int quantity, double price, Category category) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.category = category;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return quantity == device.quantity &&
                Double.compare(device.price, price) == 0 &&
                Objects.equals(id, device.id) &&
                Objects.equals(name, device.name) &&
                Objects.equals(description, device.description) &&
                Objects.equals(category, device.category) &&
                Objects.equals(customers, device.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, quantity, price, category, customers);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", category=" + category +
                ", customers=" + customers +
                '}';
    }
}
