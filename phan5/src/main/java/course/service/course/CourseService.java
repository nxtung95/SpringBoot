package course.service.course;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import course.dto.CourseResponseDto;
import course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    @Cacheable(value = "courses", key = "#keyword", condition = "#keyword != null") // Caching data when client finds all courses
    public List<CourseResponseDto> findAllCourseByKeywordName(String keyword) {
        Optional<String> nameOption = Optional.ofNullable(keyword);
        keyword = nameOption.isPresent() ? nameOption.get() : "";
        List<CourseResponseDto> courses = courseRepository.findAllByNameContaining(keyword);
        return courses;
    }
}
