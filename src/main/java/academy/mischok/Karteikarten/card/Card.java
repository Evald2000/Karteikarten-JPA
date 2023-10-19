package academy.mischok.Karteikarten.card;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Data
@Entity
@Builder
@AllArgsConstructor
@Component
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="KARTE_FRAGE")
    private String question;
    @Column(name="KARTE_ANTWORT")
    private String answer;
    @Column(name="KARTE_TAG")
    private String tags;
    private int wrong_counter;
    @Column(name="stapel_id")
    private Long stapelId;


    public int compareTo(Card other) {
        // Compare objects based on parameter1
        return Integer.compare(this.wrong_counter, other.wrong_counter);
    }

    public int getWrong_counter() {
        return wrong_counter;
    }

    public void setWrong_counter(int wrong_counter) {
        this.wrong_counter = wrong_counter;
    }





    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getTags() {
        return tags;
    }

    public Integer getId() {
        return id;
    }





    ;

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Card(String question, String answer, String tags) {
        this.question = question;
        this.answer = answer;
        this.tags = tags;
    }

    public Card(String question, String answer, int current_id) {
        this.question = question;
        this.answer = answer;
        this.id = id;

    }

    public Card() {

    }

    public Long getStapel_id() {
        return stapelId;
    }

    public void setStapel_id(Long stapel_id) {
        this.stapelId= stapel_id;
    }
}

