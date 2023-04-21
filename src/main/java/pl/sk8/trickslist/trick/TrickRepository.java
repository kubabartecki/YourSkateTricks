package pl.sk8.trickslist.trick;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrickRepository extends JpaRepository<Trick, Long> {
}
