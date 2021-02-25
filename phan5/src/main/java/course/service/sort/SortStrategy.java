package course.service.sort;

import java.util.List;

import course.dto.CourseResponseDto;

public interface SortStrategy {
    public List<CourseResponseDto> sort(List<CourseResponseDto> courses);
}
