package pl.sk8.trickslist.role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    private String authority;
    public static final String DEFAULT_USER_AUTHORITY = "ROLE_USER";

    public Role(){
        super();
    }

    public Role(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority){
        this.authority = authority;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
}
