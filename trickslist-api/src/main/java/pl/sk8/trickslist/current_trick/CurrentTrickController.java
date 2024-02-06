package pl.sk8.trickslist.current_trick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrentTrickController {

    @Autowired
    CurrentTrickRepository currentTrickRepository;

    /*
    @GetMapping("/want")
    public ResponseEntity getWantList(@RequestHeader("username") String username){

    }

    @PostMapping("want/{id}")
    public ResponseEntity getWantById(@PathVariable("id") int id){

    }

     */
}
