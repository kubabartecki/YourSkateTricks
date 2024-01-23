package pl.sk8.trickslist.trick;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class TrickDTO {
    private List<Trick> data;
    private int totalElements;
    private int totalPages;
    private int currentPage;
    private boolean isFirst;
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public TrickDTO(Page<Trick> trickPage) {
        this.setData(trickPage.getContent());
        this.setTotalElements(trickPage.getNumberOfElements());
        this.setTotalPages(trickPage.getTotalPages());
        this.setCurrentPage(trickPage.getNumber());
        this.setFirst(trickPage.isFirst());
        this.setLast(trickPage.isLast());
        this.setHasNext(trickPage.hasNext());
        this.setHasPrevious(trickPage.hasPrevious());
    }
}
