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
    @Column(name="subject")
    String subject;



    public Stapel() {
        this.subject=subject;
        this.name = name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


