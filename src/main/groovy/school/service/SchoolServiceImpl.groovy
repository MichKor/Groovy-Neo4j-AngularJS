package school.service

import school.domain.School

class SchoolServiceImpl extends GenericService<School> implements SchoolService {

    @Override
    Class<School> getEntityType() {
        return School.class
    }
}
