package models;

import javax.persistence.*;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

@Entity
public class Owner implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "carId")
    private Car car;

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public Owner(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
