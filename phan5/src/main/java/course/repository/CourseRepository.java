package course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import course.dto.CourseResponseDto;
import course.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<CourseResponseDto> findAllByNameContaining(String name);
}
