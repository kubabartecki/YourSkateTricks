package pl.sk8.trickslist.user;

import java.util.List;

public record UserCreationDTO(String name, String password, List<String> roles) {
}
