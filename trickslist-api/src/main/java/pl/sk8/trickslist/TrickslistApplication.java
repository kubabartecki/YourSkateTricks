package pl.sk8.trickslist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrickslistApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrickslistApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello (⌐■_■)");
        };
    }
}
