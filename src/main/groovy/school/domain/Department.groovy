package school.domain

import org.neo4j.ogm.annotation.Relationship

class Department extends Entity {

    String name
    String description

    @Relationship(type = "STAFF", direction = Relationship.OUTGOING)
    Set<Teacher> teachers

    @Relationship(type = "CLASSES", direction = Relationship.OUTGOING)
    Set<Course> courses

    @Relationship(type = "DEPARTAMENT", direction = Relationship.INCOMING)
    School school

    Department() {
        this.teachers = new HashSet<>()
        this.courses = new HashSet<>()
    }

    Department(String name, String description) {
        this.name = name
        this.description = description
    }

    @Override
    String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teachers=" + teachers +
                ", course=" + courses +
                '}'
    }
}
