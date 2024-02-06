package pl.sk8.trickslist.trick;

import org.springframework.stereotype.Component;

@Component
public class TrickMapper {
    public TrickDTO toDTO(Trick trick){
        return new TrickDTO(trick.getId(), trick.getName(), trick.getDifficulty().getName());
    }
}
