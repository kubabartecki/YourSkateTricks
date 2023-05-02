package pl.sk8.trickslist.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user){
        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());

        if(userFromDb.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        if(user.getPassword() == null)//todo
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        user.setRoles("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity getUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());

        if(userFromDb.isEmpty() || !user.correctPassword(userFromDb.get().getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.ok().build();
    }
}
