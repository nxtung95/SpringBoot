package course.service.sort;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import course.dto.CourseResponseDto;

@Service
public class SortService {
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public List<CourseResponseDto> sort(List<CourseResponseDto> courses) {
        Optional<SortStrategy> optionalSortStrategy = Optional.ofNullable(this.sortStrategy);
        if (!optionalSortStrategy.isPresent()) {
            return courses;
        }
        return sortStrategy.sort(courses);
    }
}
