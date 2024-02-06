package pl.sk8.trickslist.trick;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class TrickDTO {
    private int id;
    private String name;
    private String difficulty;
}
