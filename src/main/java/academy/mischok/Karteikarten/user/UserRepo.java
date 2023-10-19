//package academy.mischok.Karteikarten.user;
//
//import academy.mischok.Karteikarten.controller.repository.CrudRepo;
//import academy.mischok.Karteikarten.user.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//
//@Service
//public class UserRepo implements CrudRepo<User, Integer> {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public User save(User user) {
//
//        String sql = "INSERT INTO users(email,password) VALUES(?,?)";
//
//        int rows = jdbcTemplate.update(sql, user.getEmail(), user.getPassword());
//        if (rows > 0) {
//            System.out.println("A new row has been inserted.");
//        }
//        return user;
//    }
//
//
//    @Override
//    public User findBYId(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public List<User> findAll() {
//        String sql = "SELECT * FROM users;";
//
//        return jdbcTemplate.query(sql, new UsersMapper());
//    }
//
//    public User findBYEmail(String email) {
//        String sql = "SELECT * FROM users WHERE email = ('" + email + "');";
//
//        return jdbcTemplate.queryForObject(sql, new UsersMapper());
//    }
//
//    @Override
//    public void delete(Integer integer) {
//
//    }
//
//    @Override
//    public void update(User entity) {
//
//    }
//
//
//}
