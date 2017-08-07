package school.domain

import org.neo4j.ogm.annotation.Relationship

class Student extends Entity {

    String firstName
    String lastName
    String pesel

    @Relationship(type = "ENROLLED")
    Set<Enrollment> enrollments = new HashSet<>()

    Student() {
        this.enrollments = new HashSet<>()
    }

    Student(String firstName, String lastName, String pesel) {
        this.firstName = firstName
        this.lastName = lastName
        this.pesel = pesel
    }

    @Override
    String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", enrollments=" + enrollments +
                '}';
    }
}
