'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('teacher', {
                parent: 'entity',
                url: '/teachers',
                views: {
                    'content@': {
                        templateUrl: 'teachers.html',
                        controller: 'TeacherController'
                    }
                }
            })
            .state('teacherDetail', {
                parent: 'entity',
                url: '/teachers/:id',
                views: {
                    'content@': {
                        templateUrl: 'teacher-detail.html',
                        controller: 'TeacherDetailController'
                    }
                }
            });
    });
