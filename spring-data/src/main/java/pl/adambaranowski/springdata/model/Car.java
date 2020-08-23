package pl.adambaranowski.springdata.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
@NamedQueries({
        @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id=?1"),
        @NamedQuery(name = "Car.findByPriceAsc", query = "SELECT c FROM Car c WHERE c.price<:price ORDER BY c.price ASC ")
})
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private Double price;

    public Car(){}

    public Car(String name, String brand, Double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
