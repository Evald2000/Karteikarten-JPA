package academy.mischok.Karteikarten.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
 @Autowired
 UserRepository userRepository;
//    private final UserRepo UserRepository;

    public Benutzer getUserByEmail(String email){
        Benutzer user = userRepository.findUserByEmail(email);
        return user;
    }
    public Benutzer createUser(Benutzer user){
        Benutzer newUser = userRepository.save(user);
        return newUser;
    }
}