package course.service.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import course.error.ErrorCode;
import course.error.ErrorMessage;
import course.exception.ServiceRuntimeException;
import course.mode.UserMode;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserServiceFactory {
    private final StudentService studentService;
    private final TeacherService teacherService;

    public UserService createUser(UserMode mode) {
        if (UserMode.STUDENT.equals(mode)) {
            return studentService;
        } else if (UserMode.TEACHER.equals(mode)) {
            return teacherService;
        } else {
            throw new ServiceRuntimeException(
                    HttpStatus.BAD_REQUEST,
                    ErrorCode.USER_E006,
                    String.format(ErrorMessage.USER_E006 + ", mode: #%s", mode)
            );
        }
    }
}
