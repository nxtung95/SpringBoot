package course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import course.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsEmailByEmail(String email);
    
    @Query("SELECT new course.entity.User(u.id, u.email, u.password) from User u WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);
}
