package pl.sk8.trickslist.user;

import java.util.List;

public record UserDTO(String name, List<String> roles) {
}
