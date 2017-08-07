package school.service

import school.domain.Student

class StudentServiceImpl extends GenericService<Student> implements StudentService {

    @Override
    Class<Student> getEntityType() {
        return Student.class
    }
}
