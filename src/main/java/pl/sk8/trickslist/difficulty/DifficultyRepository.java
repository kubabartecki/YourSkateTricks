package pl.sk8.trickslist.difficulty;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
    Optional<Difficulty> findById(int id);
}
