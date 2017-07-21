controllers.controller("HomeController",
    ['$scope', '$http', '$sessionStorage',function ( $scope, $http, $sessionStorage) {

    $scope.$storage = $sessionStorage;

    $scope.model = {};

    $http({
            method: 'GET',
            url: '/api/payment-system/clients/{username}/creditcarddetails/',
            params: {}
        }).then(function (success){
              $scope.errors = {};
              $scope.errorMsg = null;
            $scope.model.ccdetails = success.data;
        },function (error){
            $scope.errors = error;
            if (error.data != null && error.data != undefined) {
                $scope.errorMsg = "Error on adding credit card details: " + success.data.message;
            }
        })

    $scope.saveCreditCard = function () {

          $http({
              method: 'POST',
              url: '/api/payment-system/creditcard/',
              data: $scope.ccEditForm,
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
