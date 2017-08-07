'use strict';

angular.module('registrarApp')
    .controller('ClassController', function ($scope, $state, Class) {
        $scope.classes = [];
        $scope.loadAll = function() {
            Class.query(function(result) {
                $scope.classes = result;
                console.log($scope.classes);
            });
        };

        $scope.loadAll();
        $scope.create = function () {
            console.log("saving class");
            console.log($scope.class);

            Class.save($scope.class,
                function () {
                    $('#saveClassModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.class = Class.get({id: id});
            $('#saveClassModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.class = Class.get({id: id});
            $('#deleteClassConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Class.delete({id: id},
                function () {
                    var popup = $('#deleteClassConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.go('class');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.class = {};
        };
    });
