package pl.sk8.trickslist.difficulty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sk8.trickslist.trick.Trick;
import pl.sk8.trickslist.trick.TrickRepository;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/difficulties")
public class DifficultyController {

    @Autowired
    DifficultyRepository difficultyRepository;

    @Autowired
    TrickRepository trickRepository;

    @PostMapping
    public ResponseEntity addDifficulty(@RequestBody Difficulty difficultyBody){
        Optional<Difficulty> difficultyFormDb = difficultyRepository.findByName(difficultyBody.getName());

        if(difficultyFormDb.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        Difficulty difficultyNew = new Difficulty();
        difficultyNew.setName(difficultyBody.getName());
        Difficulty savedDifficulty = difficultyRepository.save(difficultyNew);
        return ResponseEntity.ok(savedDifficulty);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTricksByDifficulty(@PathVariable("id") int id){
        Optional<Difficulty> optionalDifficulty = difficultyRepository.findById(id);
        if(optionalDifficulty.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        List<Trick> tricks = trickRepository.findByDifficultyId(id);

        return ResponseEntity.ok(tricks);
    }
}
