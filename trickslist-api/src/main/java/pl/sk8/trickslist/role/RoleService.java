package pl.sk8.trickslist.role;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RoleService {

    private static final Set<Role> ROLE_SET = Stream.of(
            new Role(1, "ROLE_USER"),
            new Role(2, "ROLE_ADMIN"))
            .collect(Collectors.toSet());

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Optional<Role> getRole(String role){
        return roleRepository.findByAuthority(role);
    }

    public void saveBasicRoles(){
        System.out.println(ROLE_SET.toString());
        roleRepository.saveAll(ROLE_SET);
    }


}
