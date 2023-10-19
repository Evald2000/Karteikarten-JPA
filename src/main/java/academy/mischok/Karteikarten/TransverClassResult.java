package academy.mischok.Karteikarten;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransverClassResult {
    private String stapels;

    private String tags;
    private int rictigeAntworte;
    private int gesamteFrage;
    private int quizId;

    public TransverClassResult(String stapels, String tags, int rictigeAntworte, int gesamteFrage, int quizId) {
        this.stapels = stapels;
        this.tags = tags;
        this.rictigeAntworte = rictigeAntworte;
        this.gesamteFrage = gesamteFrage;
        this.quizId = quizId;
    }

    public String getStapels() {
        return stapels;
    }

    public void setStapels(String stapels) {
        this.stapels = stapels;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getRictigeAntworte() {
        return rictigeAntworte;
    }

    public void setRictigeAntworte(int rictigeAntworte) {
        this.rictigeAntworte = rictigeAntworte;
    }

    public int getGesamteFrage() {
        return gesamteFrage;
    }

    public void setGesamteFrage(int gesamteFrage) {
        this.gesamteFrage = gesamteFrage;
    }

    public int getQuiz_Id() {
        return quizId;
    }

    public void setQuiz_Id(int quizId) {
        this.quizId = quizId;
    }
}


