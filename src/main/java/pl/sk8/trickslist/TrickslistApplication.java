package pl.sk8.trickslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sk8.trickslist.role.RoleService;


@SpringBootApplication
public class TrickslistApplication {

    @Autowired
    private RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(TrickslistApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        // todo check why sometimes it inserts 2 of them and other time second is updating st
        roleService.saveBasicRoles();
        return args -> {
            System.out.println("Hello (⌐■_■)");
        };
    }
}
