'use strict';

angular.module('registrarApp')
    .controller('DepartmentController', function ($scope, $state, Department) {
        $scope.departments = [];
        $scope.loadAll = function() {
            Department.query(function(result) {
               $scope.departments = result;
               console.log($scope.departments);
            });
        };

        $scope.loadAll();
        $scope.create = function () {
            console.log("saving department");
            console.log($scope.department);

            Department.save($scope.department,
                function () {
                    $('#saveDepartmentModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.department = Department.get({id: id});
            $('#saveDepartmentModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.department = Department.get({id: id});
            $('#deleteDepartmentConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Department.delete({id: id},
                function () {
                    var popup = $('#deleteDepartmentConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.go('department');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.department = {};
        };
    });
