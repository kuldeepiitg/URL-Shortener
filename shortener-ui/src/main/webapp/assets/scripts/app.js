/**
 * AngularJS application for url shortener
 */
var shortenerApp = angular.module('urlShortenerApp', []);

/**
 * Main controller
 */
shortenerApp.controller('mainCtrl', function($scope, $log, $http, _utils) {
	
	/**
	 * Get short url
	 */
	$scope.getShortUrl = function() {
		
		$http.get("rest/shortener/shorten/?url="+$scope.url).success(function(data){
			$log.info(data);
			
			$servlet = _utils.getServletPath();
			
			$scope.shortUrl = $servlet + data;
		});
	}
	
});

shortenerApp.factory('_utils', function ($location) {
	var getServletPath = function () {
		return $location.protocol() + "://" + $location.host() + ":" + $location.port() + "/shortener-ui/rest/shortener/expand?url=" + $location.path();
	};
	
	return {
		getServletPath : getServletPath
	}
});