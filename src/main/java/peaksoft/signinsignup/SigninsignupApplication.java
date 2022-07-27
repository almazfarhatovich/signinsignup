package peaksoft.signinsignup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import peaksoft.signinsignup.enums.Role;
import peaksoft.signinsignup.models.User;
import peaksoft.signinsignup.repositories.UserRepository;

@SpringBootApplication
public class SigninsignupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigninsignupApplication.class, args);
        System.out.println("Welcome Kuba Tashkozhoev!");
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User();
            user.setFirstName("Kuba");
            user.setLastName("Abdurasilov");
            user.setEmail("kuba@gmail.com");
            user.setRole(Role.ADMIN);
            user.setPassword(passwordEncoder.encode("1234"));
            userRepository.save(user);
        };
    }
}
