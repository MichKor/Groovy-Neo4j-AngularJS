import asset.pipeline.ratpack.AssetPipelineHandler
import asset.pipeline.ratpack.AssetPipelineModule
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.handling.RequestLogger
import ratpack.http.Status
import school.domain.*
import school.module.SchoolModule
import school.service.*

import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json

ratpack {
    serverConfig {
    }

    bindings {
        module MarkupTemplateModule
        module SchoolModule
        module(AssetPipelineModule) { config ->
            // only matters at development time, and path is relative to the build path
            config.sourcePath ="../../../src/assets"
        }
    }

    handlers {
        all(RequestLogger.ncsa())

        get {
            render file("public/index.html")
        }


        path("api/:entity/:id") {
            def theService = getTheService(pathTokens.entity, registry)
            byMethod {
                get {
                    println "****** GET BY ID *********"
                    println "theService = $theService"

                    def entityInstance = theService.find(Long.parseLong(pathTokens.id))
                    println "entityInstance = $entityInstance"

                    render json(entityInstance)
                }
                delete {
                    def entityInstance = theService.find(Long.parseLong(pathTokens.id))
                    if (entityInstance) {
                        theService.delete(entityInstance.id)
                        context.response.status(Status.OK).send()
                    } else {
                        context.response.status(Status.of(404)).send()
                    }
                }
            }
        }

        path("api/departments") {
            DepartmentService departmentService ->
                byMethod {
                    get {
                        context.next()
                    }
                    post {
                        parse(Department).then {
                            department  -> render json(departmentService.createOrUpdate(department))
                        }
                    }
                }
        }

        path("api/students") {
            StudentService studentService ->
                byMethod {
                    get {
                        context.next()
                    }
                    post {
                        parse(Student).then {
                            student  -> render json(studentService.createOrUpdate(student))
                        }
                    }
                }
        }

        path("api/subjects") {
            SubjectService subjectService ->
                byMethod {
                    get {
                        context.next()
                    }
                    post {
                        parse(Subject).then {
                            subject  -> render json(subjectService.createOrUpdate(subject))
                        }
                    }
                }
        }

        path("api/teachers") {
            TeacherService teacherService ->
                byMethod {
                    get {
                        context.next()
                    }
                    post {
                        parse(Teacher).then {
                            teacher  -> render json(teacherService.createOrUpdate(teacher))
                        }
                    }
                }
        }

        path("api/classes") {
            ClassRegisterService classRegisterService ->
                byMethod {
                    get {
                        context.next()
                    }
                    post {
                        parse(Course).then {
                            course  -> render json(classRegisterService.createOrUpdate(course))
                        }
                    }
                }
        }

        get("api/reload") {
            def importService = new ImportService()
            importService.reload()

            render json("ok")
        }

        path("api/:entity") {
            def theService = getTheService(pathTokens.entity, registry)
            byMethod {
                get {
                    render json(theService.findAll())
                }
            }
        }

        all(AssetPipelineHandler)

    }
}


static def getTheService(String entityName, def registry) {
    //TODO: May not want to lookup any random service in this manner. Restrict accordingly.
    switch (entityName) {
        case 'classes':
            return registry.get(Class.forName("school.service.ClassRegisterService"))
        default:
            return registry.get(Class.forName("school.service.${entityName[0..-2]?.capitalize()}Service"))
    }
}
