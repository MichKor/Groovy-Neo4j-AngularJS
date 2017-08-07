'use strict';

angular.module('registrarApp')
    .controller('TeacherController', function ($scope, $state, Teacher) {
        $scope.teachers = [];
        $scope.loadAll = function() {
            Teacher.query(function(result) {
                $scope.teachers = result;
                console.log($scope.teachers);
            });
        };

        $scope.loadAll();
        $scope.create = function () {
            console.log("saving teacher");
            console.log($scope.teacher);

            Teacher.save($scope.teacher,
                function () {
                    $('#saveTeacherModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.teacher = Teacher.get({id: id});
            $('#saveTeacherModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.teacher = Teacher.get({id: id});
            $('#deleteTeacherConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Teacher.delete({id: id},
                function () {
                    var popup = $('#deleteTeacherConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.go('teacher');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.teacher = {};
        };
    });
