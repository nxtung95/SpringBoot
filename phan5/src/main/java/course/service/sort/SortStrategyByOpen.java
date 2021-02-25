package course.service.sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import course.dto.CourseResponseDto;

@Service
@Lazy
public class SortStrategyByOpen implements SortStrategy {
    
    @Override
    public List<CourseResponseDto> sort(List<CourseResponseDto> courses) {
        return courses.stream()
                .sorted(Comparator.comparing(CourseResponseDto::getOpened).reversed())
                .collect(Collectors.toList());
    }

}
