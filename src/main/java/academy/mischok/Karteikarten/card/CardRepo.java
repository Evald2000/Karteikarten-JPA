//package academy.mischok.Karteikarten.card;
//
//
//import academy.mischok.Karteikarten.card.Card;
//import academy.mischok.Karteikarten.controller.repository.CrudRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//import academy.mischok.Karteikarten.mapper.CarddRowMapper;
//
//import java.util.List;
//
//
//@Service
//public class CardRepo implements CrudRepo<Card, Integer> {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Card save(Card card) {
//        String sql = "INSERT INTO karte(karte_frage, karte_antwort,karte_tag,stapel_id,wrong_counter) VALUES(?,?,?,?,?)";
//        int rows = jdbcTemplate.update(sql, card.getQuestion(), card.getAnswer(), card.getTags(), card.getStapel_id(), 1);
//        if (rows > 0) {
//            System.out.println("A new row has been inserted.");
//        }
//        return card;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        String sql = "DELETE FROM karte WHERE karte_id=" + id + ";";
//        int rows = jdbcTemplate.update(sql);
//        if (rows > 0) {
//            System.out.println("A new row has been deleted.");
//        }
//    }
//
//    @Override
//    public void update(Card entity) {
//    }
//
//    @Override
//    public List<Card> findAll() {
//        String sql = "SELECT * FROM karte;";
//
//        return jdbcTemplate.query(sql, new CarddRowMapper());
//    }
//
//    @Override
//    public Card findBYId(Integer integer) {
//        String sql = "SELECT * FROM karte WHERE karte_id =" + integer + ";";
//
//        return jdbcTemplate.queryForObject(sql, new CarddRowMapper());
//    }
//
//    public Integer findHighestId(int stapelId) {
//        String sql = "SELECT MAX(karte_id) from karte where stapel_id = " + stapelId + ";";
//        return jdbcTemplate.queryForObject(sql, Integer.class);
//    }
//
//    public Integer findLowestId(int stapelId) {
//        String sql = "SELECT MIN(karte_id) from karte where stapel_id = " + stapelId + ";";
//        return jdbcTemplate.queryForObject(sql, Integer.class);
//    }
//
//    public List<Card> findAllFromStack(int id) {
//        String sql = "SELECT * FROM karte where stapel_id = " + id + ";";
//        return jdbcTemplate.query(sql, new CarddRowMapper());
//    }
//
//    public void questionUpdate(String question, Integer id) {
//        String sql = "UPDATE karte SET karte_frage=? WHERE karte_id=" + id + ";";
//        int rows = jdbcTemplate.update(sql, question);
//        if (rows > 0) {
//            System.out.println("A new row has been Updated.");
//        }
//    }
//
//    public void answerUpdate(String answer, Integer id) {
//        String sql = "UPDATE karte SET karte_antwort=? WHERE karte_id=" + id + ";";
//        int rows = jdbcTemplate.update(sql, answer);
//        if (rows > 0) {
//            System.out.println("A new row has been Updated.");
//        }
//    }
//
//    public List<String> findAllTags() {
//        String sql = "SELECT DISTINCT karte_tag FROM KARTE ;";
//        return jdbcTemplate.queryForList(sql, String.class);
//    }
//
//    public List<Card> findCardForQuiz(List<Integer> stapelID, List<String> tagList) {
//        String sql = "SELECT * FROM karte WHERE stapel_id IN (";
//        for (int i = 0; i < stapelID.size(); i++) {
//            sql += stapelID.get(i);
//            if (i < stapelID.size() - 1) {
//                sql += ", ";
//            }
//        }
//        sql += ") AND karte_tag IN(";
//        for (int i = 0; i < tagList.size(); i++) {
//            sql += "'" + tagList.get(i) + "'";
//            if (i < tagList.size() - 1) {
//                sql += ", ";
//            }
//        }
//        sql += ")";
//        return jdbcTemplate.query(sql, new CarddRowMapper());
//    }
//}
//
//
