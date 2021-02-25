package course.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import course.entity.User;
import course.error.ErrorCode;
import course.error.ErrorMessage;
import course.exception.ServiceRuntimeException;
import course.jwt.JwtPrincipalUserDetail;
import course.repository.UserRepository;

@Service
public class LoginUserService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ServiceRuntimeException(
                HttpStatus.BAD_REQUEST,
                ErrorCode.USER_E008,
                String.format(ErrorMessage.USER_E008 + ", email: %s", email)
            );
        }
        return new JwtPrincipalUserDetail(user);
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
           () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new JwtPrincipalUserDetail(user);
    }
}
