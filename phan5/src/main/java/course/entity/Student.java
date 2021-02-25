package course.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "id")
@Getter
@Setter
@NoArgsConstructor
public class Student extends User {
    private int year;

    public Student(String name, String email, String password, int year) {
        super(name, email, password);
        this.year = year;
    }
}
