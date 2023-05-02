package pl.sk8.trickslist.trick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.sk8.trickslist.difficulty.Difficulty;
import pl.sk8.trickslist.difficulty.DifficultyRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tricks")
public class TrickController {

    @Autowired
    TrickRepository trickRepository;

    @Autowired
    DifficultyRepository difficultyRepository;

    @PostMapping
    public ResponseEntity addTrick(@RequestBody Trick trickBody){
        Trick trickNew = new Trick(trickBody.getName());
        List<Trick> tricksFromDb = trickRepository.findByName(trickBody.getName());

        if(trickBody.getName() == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        if(!tricksFromDb.isEmpty())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        if(trickBody.getDifficulty() != null){
            Optional<Difficulty> difficulty = difficultyRepository.
                    findById(trickBody.getDifficulty().getId());
            difficulty.ifPresent(trickNew::setDifficulty);
        }

        trickNew.setName(trickBody.getName());
        Trick savedTrick = trickRepository.save(trickNew);

        return ResponseEntity.ok(savedTrick);
    }

    @GetMapping
    public ResponseEntity getTrick(){
        List<Trick> tricks = trickRepository.findAll();
        return ResponseEntity.ok(tricks);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTrickById(@PathVariable("id") int id){
        Optional<Trick> trick = trickRepository.findById(id);

        if(trick.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(trick);
    }
}
