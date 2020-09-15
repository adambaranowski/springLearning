package pl.adambaranowski.devicerent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String pesel;
    @Column(name = "id_number")
    private String idNumber;

    @ManyToMany()
    @JoinTable(name = "customer_devices",
            joinColumns = {
                    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")},
            inverseJoinColumns = {
                    @JoinColumn(name = "device_id", referencedColumnName = "id_device")
            }

    )
    private List<Device> devices = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String lastName, String pesel, String idNumber, List<Device> devices) {
        this.firstName = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.idNumber = idNumber;
        this.devices = devices;
    }

    public Customer(String firstName, String lastName, String pesel, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.idNumber = idNumber;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", devices=" + devices +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(pesel, customer.pesel) &&
                Objects.equals(idNumber, customer.idNumber) &&
                Objects.equals(devices, customer.devices);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstName, lastName, pesel, idNumber, devices);
//    }
}
