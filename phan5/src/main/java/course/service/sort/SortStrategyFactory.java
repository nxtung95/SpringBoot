package course.service.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SortStrategyFactory {
    @Lazy
    @Autowired
    private SortStrategyByName sortByName;
    @Lazy
    @Autowired
    private SortStrategyByOpen sortByOpened;
    @Lazy
    @Autowired
    private SortStrategyByNameOpen sortByNameOpened;

    public SortStrategy createSortStrategy(String sortName) {
        switch (sortName) {
            case "name":
                return sortByName;
            case "opened":
                return sortByOpened;
            case "name,opened":
                return sortByNameOpened;
            default:
                return null;
        }
    }
}
