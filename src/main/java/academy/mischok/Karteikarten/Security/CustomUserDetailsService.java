//package academy.mischok.Karteikarten.Security;
//
//import academy.mischok.Karteikarten.controller.repository.UserRepository;
//import academy.mischok.Karteikarten.user.User;
//
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private UserRepository userRepo;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepo.findUserByEmail(email);
//        if(user == null){
//            throw new UsernameNotFoundException("No user found with email");
//        }
//        List<String> roles = Arrays.asList(user.getRole());
//        UserDetails userDetails =
//                org.springframework.security.core.userdetails.User.builder()
//                        .username(user.getEmail())
//                        .password(user.getPassword())
//                        .roles("USER")
//                        .build();
//
//        return userDetails;
//    }
//
//}