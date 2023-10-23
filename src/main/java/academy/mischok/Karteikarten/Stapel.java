package academy.mischok.Karteikarten;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Entity
@Builder
@AllArgsConstructor
@Table(name = "stapel")
public class Stapel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @Column(name="stapel_name")
    String name;




    public Stapel() {

        this.name = name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


