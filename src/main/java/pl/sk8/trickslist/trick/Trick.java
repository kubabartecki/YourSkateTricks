package pl.sk8.trickslist.trick;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import pl.sk8.trickslist.current_trick.CurrentTrick;
import pl.sk8.trickslist.difficulty.Difficulty;

import java.util.Set;

@Entity
@Table(name = "trick")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Trick {

    public Trick(int id, String name, Difficulty difficulty) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "difficulty_id", nullable = false)
    private Difficulty difficulty;
}
