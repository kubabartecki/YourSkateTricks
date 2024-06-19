package pl.sk8.trickslist.user;

import java.util.Set;

public record UserDTO(String username, Set<String> roles) {
}
