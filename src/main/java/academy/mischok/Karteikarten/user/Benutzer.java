package academy.mischok.Karteikarten.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Benutzer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="ROLE")
    private String role;

    public Benutzer(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.role=role;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
