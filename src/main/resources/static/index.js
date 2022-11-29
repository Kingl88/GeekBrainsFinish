/** Описание создаваемого модуля, принимает 3 параметра:
 1. Название модуля (market-frontApp)
 2. Набор других модулей в вите строкового массива. от которых данный модуль зависит
 3. Конфигурационные настройки модуля (необязательный параметр)

 controller(name, constructor): создает контроллер
 - appController - имя контроллера
 - function ($scope, $http), где
 - $scope - сервис через который контроллер передает данные в предстваление
 - $http - сервис для взаимодействия с удаленным HTTP-сервром через JSON

 **/

angular.module('student-frontApp', []).controller('appController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8081/';

    $scope.loadProducts = function () {
        $http({
            url: contextPath + 'students',
            method: 'GET',
        }).then(function (response) {
            console.log(response);
            $scope.studentsPage = response.data;
        });
    }

    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath + 'students/' + studentId).then(function (response) {
            $scope.loadProducts();
        });
    }
    $scope.createStudent = function () {
        window.location= "create_and_update_student/createAndUpdate.html";
    }
    $scope.updateStudent = function (studentId) {
        window.location= "create_and_update_student/createAndUpdate.html?id=" + studentId;
    }
    $scope.loadProducts();

});