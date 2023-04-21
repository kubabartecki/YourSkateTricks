package pl.sk8.trickslist.current_trick;

import jakarta.persistence.*;


import lombok.NonNull;
import pl.sk8.trickslist.trick.Trick;
import pl.sk8.trickslist.user.User;

@Entity
@Table(name="current_trick")
public class CurrentTrick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "trick_id")
    private Trick trick;

    @Column(name = "is_done")
    private boolean isDone;

    @Column(name = "want_to_learn")
    private boolean wantToLearn;
}
