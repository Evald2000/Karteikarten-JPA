package academy.mischok.Karteikarten.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Benutzer,Long> {

    Benutzer findUserByEmail(String email);
}
