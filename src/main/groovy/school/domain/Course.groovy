package school.domain

import com.fasterxml.jackson.annotation.JsonProperty
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity(label = "Class")
class Course extends Entity {

    @JsonProperty("year")
    String year

    String direction
    String institute

    @JsonProperty("subject")
    @Relationship(type = "SUBJECT_TAUGHT", direction = Relationship.INCOMING)
    Subject subject

    @JsonProperty("student")
    @Relationship(type = "STUDENT", direction = Relationship.OUTGOING)
    Set<Student> students

    @Relationship(type = "ENROLLED", direction = Relationship.INCOMING)
    Set<Enrollment> enrollments = new HashSet<>()

    @Override
    String toString() {
        return "Course{" +
                "id=" + getId() +
                ", year='" + year + '\'' +
                ", direction='" + direction + '\'' +
                ", institute='" + institute + '\'' +
                ", student=" + students +
                ", subject=" + subject +
                ", students=" + enrollments.size() +
                '}'
    }
}
