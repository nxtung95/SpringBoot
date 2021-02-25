package course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import course.dto.CourseResponseDto;
import course.dto.PartialCourseResponseDto;
import course.service.course.CourseService;
import course.service.mapper.MapperService;
import course.service.sort.SortService;
import course.service.sort.SortStrategyFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final SortService sortService;
    private final SortStrategyFactory sortStrategyFactory;
    
    private final MapperService<CourseResponseDto, PartialCourseResponseDto> mapperService;

    @GetMapping("api/v1/courses")
    @ApiOperation("Search courses by name or opened")
    @ApiResponses({ @ApiResponse(code = 200, message = "Search courses successfully"), })
    public ResponseEntity<List<PartialCourseResponseDto>> searchCourses(
            @ApiParam(value = "Search course by name", example = "Spring") @RequestParam(required = false, name = "keyword") String keyWord,
            @ApiParam(value = "Sort course by name or opened", example = "name") @RequestParam(required = false, name = "sortBy") String sortBy
    ) {
        List<CourseResponseDto> courses = courseService.findAllCourseByKeywordName(keyWord);
        if (sortBy != null) {
            sortService.setSortStrategy(sortStrategyFactory.createSortStrategy(sortBy));
            courses = sortService.sort(courses);
        }
        List<PartialCourseResponseDto> response = mapperService.mappingTypeObjectList(courses,
                PartialCourseResponseDto.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
