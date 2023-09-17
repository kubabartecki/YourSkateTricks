package pl.sk8.trickslist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.sk8.trickslist.role.Role;
import pl.sk8.trickslist.role.RoleService;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    public UserDTO toDto(User user) {
        String name = user.getUsername();
        Set<String> roles = user
                .getRoles()
                .stream()
                .map(Role::getAuthority)
                .collect(Collectors.toSet());
        return new UserDTO(name, roles);
    }

    public User toUser(UserCreationDTO userCreationDTO) {
        if (userCreationDTO.roles() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Lack of Roles");
        }
        Set<Role> roleSet;

        roleSet = userCreationDTO.roles()
                .stream()
                .map(roleService::getRole)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        if (roleSet.isEmpty()) { // if user passed no roles or passed wrong roles!
            Optional<Role> basicRoleOptional = roleService.getRole(Role.DEFAULT_USER_AUTHORITY);
            basicRoleOptional.ifPresentOrElse(roleSet::add, () -> {
                throw new ResponseStatusException(HttpStatus.INSUFFICIENT_STORAGE, "Basic Role not found in DB");
            });
        }

        return new User(userCreationDTO.username(),
                passwordEncoder.encode(userCreationDTO.password()),
                roleSet);
    }
}
