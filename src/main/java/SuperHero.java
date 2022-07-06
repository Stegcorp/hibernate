import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SuperHero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String superhero;
    @Enumerated(EnumType.STRING)
    private Side side;

    public SuperHero(String superhero, Side side) {
        this.superhero = superhero;
        this.side = side;
    }
}
