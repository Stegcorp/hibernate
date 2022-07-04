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
public class DriveLicense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private String series;

    public DriveLicense(String series) {
        this.series = series;
    }
}
