//package academy.mischok.Karteikarten.Security;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.boot.web.servlet.DispatcherType;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.password.NoOpPasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
////import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
////@EnableWebSecurity
////@EnableMethodSecurity
//public class SecurityConfig{
//
//    private final CustomUserDetailsService userDetailsService;
//
//    public SecurityConfig(CustomUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, NoOpPasswordEncoder noOpPasswordEncoder)
//            throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(noOpPasswordEncoder);
//        return authenticationManagerBuilder.build();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//
//            http
//                    .authorizeRequests(authorize -> authorize
//                            .anyRequest().permitAll()
//                    )
//                    .formLogin(form -> form
//                            .loginPage("/login")
//                                    .permitAll()
//                            );
//        return http.build();
//    }
////    .formLogin(authize ->authize
////            .loginPage("/login.html")
////            .defaultSuccessUrl("/", true)
////                    .failureUrl("/login.html?error=true"));
//
//    @SuppressWarnings("deprecation")
//    @Bean
//    public NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//
//
//}
