package pl.sk8.trickslist.trick;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrickRepository extends JpaRepository<Trick, Integer> {
    List<Trick> findByName(String name);
    Optional<Trick> findById(int id);

    List<Trick> findByDifficultyId(int id);

    @Query("""
    select new pl.sk8.trickslist.trick.TrickDTO(t.id, t.name, t.difficulty.name) from Trick t
    where lower(t.name) like lower(concat('%', :query, '%'))
    """)
    Page<TrickDTO> searchTricksJPQL(String query, Pageable pageable);

    // code above can be replaced by code below (works for simpler attributes)

    Page<TrickDTO> findByNameContainsIgnoreCase(String query, Pageable pageable);
}
