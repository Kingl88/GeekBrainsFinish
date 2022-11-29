angular.module('studentCreateAndUpdate', []).controller('createUserController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081/students';
    let studentId = document.location.search.split('=')[1];
    console.log(studentId);
    $scope.createNewUser = function () {
        if ($scope.new_student == null) {
            alert("The form is not completed to the end");
            return;
        }
        if(studentId == null){
            $http.post(contextPath, $scope.new_student)
                .then(function successCallback(response) {
                    $scope.new_student = null;
                    window.location = "/index.html";
                }, function failCallback() {
                });
        } else {
            let student = $scope.new_student;
            student.id = studentId;
            $http.put(contextPath, student)
                .then(function successCallback(response) {
                    $scope.new_student = null;
                    window.location = "/index.html";
                }, function failCallback() {
                });
        }

    }
});
