package pl.sk8.trickslist.trick;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.sk8.trickslist.current_trick.CurrentTrick;
import pl.sk8.trickslist.difficulty.Difficulty;

import java.util.Set;

@Entity
@Table(name = "trick")
@Data
@NoArgsConstructor
public class Trick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    @OneToMany(mappedBy = "trick")
    private Set<CurrentTrick> currentTricks;// = new HashSet<CurrentTrick>();
}
