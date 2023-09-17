package pl.sk8.trickslist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserCreationDTO userCreationDTO) {
        Optional<User> userFromDb = userRepository.findByUsername(userCreationDTO.username());

        if (userFromDb.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        if (userCreationDTO.password() == null
                || userCreationDTO.username() == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        User user = userMapper.toUser(userCreationDTO);
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity getUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb.isEmpty() || !user.correctPassword(userFromDb.get().getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.ok().build();
    }
}
