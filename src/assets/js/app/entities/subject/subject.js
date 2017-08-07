'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('subject', {
                parent: 'entity',
                url: '/subjects',
                views: {
                    'content@': {
                        templateUrl: 'subjects.html',
                        controller: 'SubjectController'
                    }
                }
            })
            .state('subjectDetail', {
                parent: 'entity',
                url: '/subjects/:id',
                views: {
                    'content@': {
                        templateUrl: 'subject-detail.html',
                        controller: 'SubjectDetailController'
                    }
                }
            });
    });
