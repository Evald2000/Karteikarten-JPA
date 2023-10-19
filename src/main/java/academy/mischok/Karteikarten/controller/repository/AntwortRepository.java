package academy.mischok.Karteikarten.controller.repository;

import academy.mischok.Karteikarten.cardUserAntwort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AntwortRepository extends JpaRepository<cardUserAntwort,Long> {

    List<cardUserAntwort> findAllByQuizId(Integer id);
}
