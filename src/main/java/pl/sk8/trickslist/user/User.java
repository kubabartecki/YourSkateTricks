package pl.sk8.trickslist.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.sk8.trickslist.current_trick.CurrentTrick;

import java.util.Set;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column
    private String username;

    @NonNull
    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<CurrentTrick> currentTricks;

    @Column
    private String roles;

    public boolean correctPassword(String password){
        return this.password.equals(password);
    }
}
