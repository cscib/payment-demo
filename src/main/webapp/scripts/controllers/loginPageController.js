controllers.controller("LoginPageController", ['$rootScope', '$scope', '$http', '$location', function ($rootScope, $scope, $http, $location) {

   $scope.model = {};

//      $http.get("/ws/users/groups/links").success(function(data) {
//          $scope.model = data;
//      });

//      $scope.editedUser = user;

      $scope.saveUser = function () {

          $http({
              method: 'POST',
              url: '/api/payment-system/clients/',
              data: $scope.editedUser,
          }).then(function (error){
              $scope.errors = error;
          },function (success){
              $scope.errors = {};
              $modalInstance.dismiss('cancel');
              onSuccess();
          })
      };

      $scope.cancel = function () {
          $modalInstance.dismiss('cancel');
      };

}]);