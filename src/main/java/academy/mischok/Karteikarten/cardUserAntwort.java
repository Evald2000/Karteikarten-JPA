package academy.mischok.Karteikarten;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Service
@Entity
public class cardUserAntwort {
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name="card_id")
   private int cardId ;
    @Column(name="quiz_id")
   private int quizId ;
   private String user_antwort;
  private String url;
  private int stapel_id;
  private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCard_id() {
      return cardId;
   }

   public String getUser_antwort() {
      return user_antwort;
   }

   public int getId() {
      return id;
   }

   public void setCard_id(int card_id) {
      this.cardId = card_id;
   }

   public void setUser_antwort(String user_antwort) {
      this.user_antwort = user_antwort;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getQuiz_id() {
      return quizId;
   }

   public void setQuiz_id(int quiz_id) {
      this.quizId = quiz_id;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

    public int getStapel_id() {
        return stapel_id;
    }

    public void setStapel_id(int stapel_id) {
        this.stapel_id = stapel_id;
    }
}
