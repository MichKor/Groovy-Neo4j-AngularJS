'use strict';

angular.module('registrarApp')
    .factory('Subject', function ($resource) {

        var url = 'api/subjects/:id';

        return $resource(url, {}, {
            'query': {
                method: 'GET', isArray: true,
                transformResponse: function (data) {
                    return JSOG.parse(data);
                }
            },
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'},
            'post': {method: 'POST'},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    return JSOG.parse(data);
                }
            }
        });
    });
