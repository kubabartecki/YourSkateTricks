package pl.sk8.trickslist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// leave this exception unused due to issue (not passing message) with MyErrorController
@ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
public class LackOfBasicRecordsInDatabase extends RuntimeException{
    public LackOfBasicRecordsInDatabase(String message){
        super(message);
    }
}
