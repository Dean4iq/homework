package ua.den;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringAppExecution {
    public static void main(String[] args) {
        SpringApplication.run(SpringAppExecution.class, args);
    }
}
