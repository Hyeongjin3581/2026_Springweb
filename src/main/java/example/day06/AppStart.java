package example.day06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class AppStart {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AppStart.class);
        application.setAdditionalProfiles("day06");
        application.run(args);
    }
}
