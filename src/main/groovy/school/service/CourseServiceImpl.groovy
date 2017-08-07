package school.service

import school.domain.Course

class CourseServiceImpl extends GenericService<Course> implements ClassRegisterService {

    @Override
    Class<Course> getEntityType() {
        return Course.class
    }
}
