package course.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import course.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean checkExistEmail(String email) {
        return userRepository.existsEmailByEmail(email);
    }
}
