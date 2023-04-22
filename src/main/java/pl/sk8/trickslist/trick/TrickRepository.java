package pl.sk8.trickslist.trick;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrickRepository extends JpaRepository<Trick, Long> {
    public List<Trick> findByName(String name);
    public Optional<Trick> findById(int id);
}
