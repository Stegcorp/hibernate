import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private Type type;
    private int power;
    private int price;
    private int year;

    public Car(String model, Type type, int power, int price, int year) {
        this.model = model;
        this.type = type;
        this.power = power;
        this.price = price;
        this.year = year;
    }
}
