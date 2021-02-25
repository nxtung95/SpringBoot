package course.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "teacher_id", referencedColumnName = "id")
@Getter
@Setter
@NoArgsConstructor
public class Teacher extends User {
    private String phone;
    private int experiences;

    public Teacher(String name, String email, String password, String phone, int experiences) {
        super(name, email, password);
        this.phone = phone;
        this.experiences = experiences;
    }
}
