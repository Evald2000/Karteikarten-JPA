package academy.mischok.Karteikarten;

import org.springframework.stereotype.Service;

@Service
public class FalscheKarten {

    int id;
    int karte_id;

    public int getId() {
        return id;
    }

    public int getKarte_id() {
        return karte_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKarte_id(int karte_id) {
        this.karte_id = karte_id;
    }
}
