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

    loadCreditCards();


    $scope.edit = function (creditcard) {
        $scope.ccEditForm.ccNumber = creditcard.ccNumber;
        $scope.ccEditForm.ccType = creditcard.ccType;
        $scope.ccEditForm.expiryDate = creditcard.expiryDate;
    }


    $scope.cancel = function () {
            $scope.ccEditForm = {};
     };

    $scope.saveCreditCard = function () {
          $http({
              method: 'POST',
              url: '/api/payment-system/creditcard/',
              data: $scope.ccEditForm,
          }).then(function (success){
                $scope.errors = {};
                $scope.successMsg = "Credit card created / modified successfully"
                loadCreditCards();
          },function (error){
                $scope.errors = error;
                $scope.errorMsg = "Form error, please check your input and try again.";
                                if (error != null && error.data != null && error.data.defaultMessage != null) {
                                    $scope.errorMsg = error.data.defaultMessage;
                                } else if (error != null && error.data != null && error.data.message != null) {
                                    $scope.errorMsg = error.data.message;
                                }
          })
    };

      $scope.cancel = function () {
          $modalInstance.dismiss('cancel');
      };

     /**
       * Wrapper function to show alert in settings page
       */
      function loadCreditCards(){

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

      }


}]);
