package academy.mischok.Karteikarten.controller.repository;

import academy.mischok.Karteikarten.SolveAttemptsLearn;
import academy.mischok.Karteikarten.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolveRepository extends JpaRepository<SolveAttemptsLearn,Long> {

List<SolveAttemptsLearn> findAll();

    @Modifying
    @Query(value = "insert into wrongcards (stapel_id,karte_id, falsch) values (stapelId,karteId, falsch);", nativeQuery = true)
    void speichern(@Param("stapelId")int stapelid,@Param("karteId") int id , @Param("falsch") Boolean falsch);
}
