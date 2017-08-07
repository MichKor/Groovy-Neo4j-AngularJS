package school.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.neo4j.ogm.annotation.Relationship

class Teacher extends Entity {

    @JsonProperty("name")
    String name

    String lastName
    String academic_title
    String pesel

    @Relationship(type = "TEACHES_CLASS")
    Set<Course> courses

    @JsonIgnore
    @Relationship(type = "DEPARTMENT_MEMBER", direction = Relationship.INCOMING)
    Department department

    @Relationship(type = "TAUGHT_BY", direction = Relationship.INCOMING)
    Set<Subject> subjects

    Teacher(String name, String lastName, String academic_title, String pesel) {
        this.name = name
        this.lastName = lastName
        this.academic_title = academic_title
        this.pesel = pesel
    }

    Teacher() {
        this.courses = new HashSet<>()
        this.subjects = new HashSet<>()
    }

    @Override
    String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", academic_title='" + academic_title + '\'' +
                ", pesel='" + pesel + '\'' +
                ", courses=" + courses +
                ", department=" + department +
                ", subjects=" + subjects +
                '}';
    }
}
