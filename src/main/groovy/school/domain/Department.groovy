package school.domain

import org.neo4j.ogm.annotation.Relationship

class Department extends Entity {

    String name
    String name2

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

    Department(String name, String name2) {
        this.name = name
        this.name2 = name2
    }

    @Override
    String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                ", teachers=" + teachers +
                ", course=" + courses +
                '}'
    }
}
