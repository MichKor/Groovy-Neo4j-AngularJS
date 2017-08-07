'use strict';

angular.module('registrarApp')
    .controller('SubjectController', function ($scope, $state, Subject) {
        $scope.Subjects = [];
        $scope.loadAll = function() {
            Subject.query(function(result) {
                $scope.subjects = result;
                console.log($scope.subjects);
            });
        };

        $scope.loadAll();
        $scope.create = function () {
            console.log("saving subject");
            console.log($scope.subject);

            Subject.save($scope.subject,
                function () {
                    $('#saveSubjectModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.subject = Subject.get({id: id});
            $('#saveSubjectModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.subject = Subject.get({id: id});
            $('#deleteSubjectConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Subject.delete({id: id},
                function () {
                    var popup = $('#deleteSubjectConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.go('subject');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.subject = {};
        };
    });
