package pl.sk8.trickslist.current_trick;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.sk8.trickslist.trick.Trick;
import pl.sk8.trickslist.user.User;

@Entity
@Table(name="current_trick")
@Data
@NoArgsConstructor
public class CurrentTrick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trick_id", nullable = false)
    private Trick trick;

    @Column(name = "is_done")
    private boolean isDone;

    @Column(name = "want_to_learn")
    private boolean wantToLearn;
}
