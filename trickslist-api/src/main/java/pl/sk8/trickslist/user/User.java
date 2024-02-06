package pl.sk8.trickslist.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.sk8.trickslist.current_trick.CurrentTrick;
import pl.sk8.trickslist.role.Role;

import java.util.Set;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NonNull
    @Column
    private String username;

    @NonNull
    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<CurrentTrick> currentTricks;

    @NonNull
    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_junction",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    public User (String username, String password, Set<Role> roles){
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    public boolean correctPassword(String password) {
        return this.password.equals(password);
    }
}
