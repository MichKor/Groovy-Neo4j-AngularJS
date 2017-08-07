'use strict';

angular.module('registrarApp')
    .factory('Teacher', function ($resource) {

        var url = 'api/teachers/:id';

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
