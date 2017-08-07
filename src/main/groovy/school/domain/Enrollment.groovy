package school.domain

import org.neo4j.ogm.annotation.EndNode
import org.neo4j.ogm.annotation.RelationshipEntity
import org.neo4j.ogm.annotation.StartNode
import org.neo4j.ogm.annotation.typeconversion.DateLong

@RelationshipEntity(type = "ENROLLED")
class Enrollment {

    Long id

    @StartNode
    Student student

    @EndNode
    Course course

    @DateLong
    Date enrolledDate

    Enrollment() {
    }

    Enrollment(Student student, Course course) {
        this.student = student
        this.course = course
        this.enrolledDate = new Date()
    }
}
