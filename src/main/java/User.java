import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private SuperHero superHeroes;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_car",
            joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car>  cars;

    public User(String name, SuperHero superHeroes, List<Car> cars) {
        this.name = name;
        this.superHeroes = superHeroes;
        this.cars = cars;
    }
}
