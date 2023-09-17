package pl.sk8.trickslist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE, reason = "why is this exception not working??????????????????????????????????")
public class LackOfBasicRecordsInDatabase extends RuntimeException{
    public LackOfBasicRecordsInDatabase(String message){
        super(message);
    }
}
