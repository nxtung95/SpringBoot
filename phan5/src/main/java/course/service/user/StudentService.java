package course.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import course.dto.UserRequestDto;
import course.dto.UserResponseDto;
import course.entity.Student;
import course.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class StudentService implements UserService {

    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        String name = userRequestDto.getName();
        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();
        int year = userRequestDto.getStudent().getYear();
        Student student = new Student(name, email, password, year);
        Student saveStudent = studentRepository.save(student);

        return modelMapper.map(saveStudent, UserResponseDto.class);
    }

}
