package school.domain

import org.neo4j.ogm.annotation.Relationship

class School extends Entity {

    String name

    @Relationship(type = "DEPARTMENT")
    Set<Department> departments

    @Relationship(type = "STAFF")
    Set<Teacher> teachers

    @Relationship(type = "HEAD_TEACHER")
    Teacher headTeacher

    @Relationship(type = "STUDENT")
    Set<Student> students

    School() {
        this.departments = new HashSet<>()
        this.teachers = new HashSet<>()
        this.students = new HashSet<>()
    }

    School(String name) {
        this()
        this.name = name
    }

    @Override
    String toString() {
        return "School{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", departments=" + departments.size() +
                ", teachers=" + teachers.size() +
                ", students=" + students.size() +
                '}'
    }
}

