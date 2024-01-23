package pl.sk8.trickslist.trick;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class TricksDTO {
    private List<Trick> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public TricksDTO(Page<Trick> trickPage) {
        this.setData(trickPage.getContent());
        this.setTotalElements(trickPage.getTotalElements());
        this.setTotalPages(trickPage.getTotalPages());
        this.setCurrentPage(trickPage.getNumber() + 1);
        this.setFirst(trickPage.isFirst());
        this.setLast(trickPage.isLast());
        this.setHasNext(trickPage.hasNext());
        this.setHasPrevious(trickPage.hasPrevious());
    }
}
