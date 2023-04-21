package pl.sk8.trickslist.difficulty;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.sk8.trickslist.trick.Trick;

import java.util.Set;

@Entity
@Table(name = "difficulty")
@Data
@NoArgsConstructor
public class Difficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column
    private String name;

    @OneToMany(mappedBy = "difficulty")
    private Set<Trick> tricks;

}
