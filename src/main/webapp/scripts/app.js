var app = angular.module('myApp',
    [
        'services',
        'controllers',
        'ui.router',
        'ngRoute'
    ]
);

var controllers = angular.module('controllers', ['services']);
var services = angular.module('services', []);

app.config(function ($routeProvider, $httpProvider) {

    $routeProvider.when('/', {
        templateUrl: '/views/home.html',
        controller: 'HomeController',
        controllerAs: 'controller',
        activeTab: 'home'
    }).when('/login', {
        templateUrl: 'login.html',
        controller: 'LoginPageController',
        controllerAs: 'controller',
        activeTab: 'login'
    })
    .otherwise('/');
    });