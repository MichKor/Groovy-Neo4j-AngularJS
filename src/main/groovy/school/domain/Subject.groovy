package school.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.neo4j.ogm.annotation.Relationship

class Subject extends Entity {

    @JsonProperty("name")
    String name

    String code

    @JsonIgnore
    @Relationship(type = "CURRICULUM", direction = Relationship.INCOMING)
    Department department

    @Relationship(type = "TAUGHT_BY")
    Set<Teacher> teachers

    @Relationship(type = "SUBJECT_TAUGHT", direction = "INCOMING")
    Set<Course> courses

    Subject(String name, String code) {
        this()
        this.name = name
        this.code = code
    }

    Subject() {
        this.teachers = new HashSet<>()
        this.courses = new HashSet<>()
    }

    @Override
    String toString() {
        return "Subject{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", department=" + department +
                ", teachers=" + teachers.size() +
                '}'
    }
}
