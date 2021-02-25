package course.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResponseDto {
    private Integer id;
    private String name;
    private String location;
    private String teacherName;
    private Date opened;
}
