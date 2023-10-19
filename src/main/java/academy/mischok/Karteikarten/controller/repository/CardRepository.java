package academy.mischok.Karteikarten.controller.repository;

import academy.mischok.Karteikarten.card.Card;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Integer>, JpaSpecificationExecutor<Card> {

Card findCardById(int id);

    @Query("SELECT MAX(e.id) FROM Card e WHERE e.stapelId = :stapelId")
    Integer findTopByOrderByIdDesc(int stapelId);

    @Query("SELECT MIN(e.id) FROM Card e WHERE e.stapelId = :stapelId")
    Integer findBotByOrderByIdAsc(int stapelId);
//    @Modifying
//    @Transactional
//    @Query("UPDATE Card c SET c.question = :answer WHERE c.id = :id")
//    void updateCardQuestionById(Integer id,String question);
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE Card c SET c.answer = :answer WHERE c.id = :id")
//    void updateCardAnswerById(Integer id, String answer);


    List<Card>findAllCardsByStapelId(int StackId);



    @Query("SELECT DISTINCT e.tags FROM Card e")
    List<String> findAllTags();



    List<Card> findAllByTags(String tag);

    List<Card> findAllByTagsAndStapelId(String tags,Long ids);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Card c SET c.question = :newQuestion WHERE c.id = :cardId")
    void updateCardQuestionById(Long cardId, String newQuestion);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Card c SET c.answer = :newAnswer WHERE c.id = :cardId")
    void updateCardAnswerById(Long cardId, String newAnswer);


}

