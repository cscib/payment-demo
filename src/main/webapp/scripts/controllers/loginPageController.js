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
          }).then(function (success){
              $scope.errors = {};
              $scope.errorMsg = null;
              $scope.successMsg = "User create successfully, please login"
          },function (error){
               $scope.errors = error;
               $scope.successMsg = null;
               if (error.data != null && error.data != undefined) {
                $scope.errorMsg = "Error on adding user: " + error.data.message;
               }
          })
      };

      $scope.cancel = function () {
          $modalInstance.dismiss('cancel');
      };

}]);