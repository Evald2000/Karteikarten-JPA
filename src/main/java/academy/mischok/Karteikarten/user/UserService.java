package academy.mischok.Karteikarten.user;


import academy.mischok.Karteikarten.controller.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
//    private final UserRepo UserRepository;

    public User getUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return user;
    }
    public User createUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }
}