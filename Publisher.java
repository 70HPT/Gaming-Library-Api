import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long gameId;
    private String name;

    public Publisher(Long gameId, String name, double price) {
        this.gameId = gameId;
        this.name = name;
    }

    public Publisher() {

    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setName(String name) {
        this.name = name;
    }


}