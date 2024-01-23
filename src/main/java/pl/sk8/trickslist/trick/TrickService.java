package pl.sk8.trickslist.trick;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TrickService {

    @Autowired
    private final TrickRepository trickRepository;

    @Transactional
    public TricksDTO getTricks(Integer page) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNumber, 3, Sort.Direction.DESC, "id");
        return new TricksDTO(trickRepository.findAll(pageable));
    }
}
