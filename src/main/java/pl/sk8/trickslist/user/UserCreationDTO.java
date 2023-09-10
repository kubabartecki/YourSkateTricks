package pl.sk8.trickslist.user;

import java.util.Set;

public record UserCreationDTO(String name, String password, Set<String> roles) {
}
