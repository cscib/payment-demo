controllers.controller("HomeController",
    ['$scope', '$http',function ( $scope, $http) {

   // $scope.$storage = $sessionStorage;


    $scope.model = {};


        $http({
                method: 'GET',
                url: '/api/payment-system/auth/',
                params: {}
            }).then(function (success){
                  $scope.errors = {};
                  $scope.errorMsg = null;
                $scope.model.authdetails = success.data;
            },function (error){
                $scope.model.authdetails = null;
            })

        $http({
                method: 'GET',
                url: '/api/payment-system/clients/creditcarddetails/',
                params: {}
            }).then(function (success){
                  $scope.errors = {};
                  $scope.errorMsg = null;
                $scope.model.ccdetails = success.data;
            },function (error){
                $scope.errors = error;
                if (error.data != null && error.data != undefined) {
                    $scope.errorMsg = "Error on adding credit card details: " + error.data.message;
                }
            })


    $scope.saveCreditCard = function () {

          $http({
              method: 'POST',
              url: '/api/payment-system/creditcard/',
              data: $scope.ccEditForm,
          }).then(function (success){
                $scope.errors = {};
                //onSuccess();
          },function (error){
                $scope.errors = error;
          })
    };

      $scope.cancel = function () {
          $modalInstance.dismiss('cancel');
      };
}]);
