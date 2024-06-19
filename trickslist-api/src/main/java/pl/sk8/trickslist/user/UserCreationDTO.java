package pl.sk8.trickslist.user;

import java.util.Set;

public record UserCreationDTO(String username, String password, Set<String> roles) {
}
