package pl.sk8.trickslist;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sk8.trickslist.difficulty.Difficulty;
import pl.sk8.trickslist.difficulty.DifficultyRepository;
import pl.sk8.trickslist.role.RoleService;
import pl.sk8.trickslist.trick.Trick;
import pl.sk8.trickslist.trick.TrickRepository;
import pl.sk8.trickslist.user.UserRepository;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final DifficultyRepository difficultyRepository;
    private final TrickRepository trickRepository;


    @Override
    public void run(String... args) throws Exception {
        roleService.saveBasicRoles();
        Difficulty easy = difficultyRepository.save(new Difficulty(1, "Easy"));
        difficultyRepository.save(new Difficulty(2, "Medium"));
        difficultyRepository.save(new Difficulty(3, "Hard"));
        trickRepository.save(new Trick( 1, "Ollie1", easy));
        trickRepository.save(new Trick( 2, "Ollie2", easy));
        trickRepository.save(new Trick( 3, "Ollie3", easy));
        trickRepository.save(new Trick( 4, "Ollie4", easy));
        trickRepository.save(new Trick( 5, "Ollie5", easy));
    }
}
