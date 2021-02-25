package course.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartialCourseResponseDto {
    @ApiModelProperty(name = "Course ID", example = "1")
    private Integer id;
    @ApiModelProperty(name = "Course name", example = "Spring Boot Fundamental")
    private String name;
    @ApiModelProperty(name = "Hanoi CS1", example = "Hanoi CS1")
    private String location;
    @ApiModelProperty(name = "Teacher who teach courses", example = "Vu Van B")
    private String teacherName;
}
