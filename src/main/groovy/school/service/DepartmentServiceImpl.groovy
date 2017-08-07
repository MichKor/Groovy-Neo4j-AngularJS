package school.service

import school.domain.Department

class DepartmentServiceImpl extends GenericService<Department> implements DepartmentService {

    @Override
    Class<Department> getEntityType() {
        return Department.class
    }
}
