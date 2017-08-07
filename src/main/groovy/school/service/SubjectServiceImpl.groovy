package school.service

import school.domain.Subject

class SubjectServiceImpl extends GenericService<Subject> implements SubjectService {

    @Override
    Class<Subject> getEntityType() {
        return Subject.class
    }
}
