package school.service

import school.domain.Teacher

class TeacherServiceImpl extends GenericService<Teacher> implements TeacherService {

    @Override
    Class<Teacher> getEntityType() {
        return Teacher.class
    }
}
