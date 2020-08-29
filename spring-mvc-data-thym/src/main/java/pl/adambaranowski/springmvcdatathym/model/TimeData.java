package pl.adambaranowski.springmvcdatathym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TimeData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int hours;
    private int minutes;
    private int seconds;

    public TimeData() {
    }

    @Override
    public String toString() {
        return "TimeData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }

    public TimeData(String firstName, String lastName, int hours, int minutes, int seconds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeData timeData = (TimeData) o;
        return id == timeData.id &&
                hours == timeData.hours &&
                minutes == timeData.minutes &&
                seconds == timeData.seconds &&
                Objects.equals(firstName, timeData.firstName) &&
                Objects.equals(lastName, timeData.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, hours, minutes, seconds);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
