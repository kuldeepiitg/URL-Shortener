<html>
<head>
<title>URL Shortener</title>

<script type="text/javascript" src="assets/vendor/jquery/jquery-2.1.4.js"></script>
<!-- script type="text/javascript" src="assets/scripts/jquery/jquery-2.1.4.min.js"></script -->

<script type="text/javascript" src="assets/vendor/angular-1.4.1/angular.js"></script>
<!-- script type="text/javascript" src="assets/scripts/angular-1.4.1/angular.js"></script -->

<script type="text/javascript" src="assets/vendor/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- script type="text/javascript" src="assets/scripts/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script -->

<link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap-3.3.5/dist/css/bootstrap.css" media="screen" />
<!-- <link rel="stylesheet" type="text/css" href="assets/scripts/bootstrap-3.3.5/dist/css/bootstrap.mi.css" media="screen" /> -->


<script type="text/javascript" src="assets/scripts/app.js"></script>

</head>
<body>
<div ng-app="urlShortenerApp">
	
	<div ng-controller="mainCtrl">
		<input type="text" ng-model="url" placeholder="Enter url to be shorten">
		<a class="btn btn-default" ng-click="getShortUrl()">Get Short URL</a>
		<a ng-href="{{shortUrl}}" >{{shortUrl}}</a>
	</div>
	
</div>
</body>
</html>
