package academy.mischok.Karteikarten;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Service
@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wrongcards")
public class SolveAttemptsLearn {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @Column(name="karte_id")
    int karteId;
    @Column(name="stapel_id")
    int stapelId;
    @Column(name="falsch")
    boolean falsch;

    public int getKarte_id() {
        return karteId;
    }

    public void setKarte_id(int karte_id) {
        this.karteId = karte_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStapel_id() {
        return stapelId;
    }

    public void setStapel_id(int stapel_id) {
        this.stapelId = stapel_id;
    }

    public boolean isFalsch() {
        return falsch;
    }

    public void setFalsch(boolean falsch) {
        this.falsch = falsch;
    }
}
