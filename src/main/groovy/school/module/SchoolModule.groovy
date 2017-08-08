package school.module

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import school.service.*

class SchoolModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DepartmentService.class).to(DepartmentServiceImpl.class).in(Scopes.SINGLETON)
        bind(SchoolService.class).to(SchoolServiceImpl.class).in(Scopes.SINGLETON)
        bind(ClassRegisterService.class).to(CourseServiceImpl.class).in(Scopes.SINGLETON)
        bind(StudentService.class).to(StudentServiceImpl.class).in(Scopes.SINGLETON)
        bind(SubjectService.class).to(SubjectServiceImpl.class).in(Scopes.SINGLETON)
        bind(TeacherService.class).to(TeacherServiceImpl.class).in(Scopes.SINGLETON)
    }
}
