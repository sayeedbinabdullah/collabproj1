var app=angular.module("myApp",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	console.log('entering configuration')		
	$routeProvider
	.when('/login',{		
		controller:'UserRestController',
		templateUrl:'_user/login.html'
	})	
	.when('/register',{ // $scope.user, $scope.register() -- local for this page
		controller:'UserRestController',
		templateUrl:'_user/register.html'
	})
	.when('/displayUsers',{
		controller:'UserRestController',
		templateUrl:'_user/displayusers.html'
	})	
	.when('/home',{
		controller:'UserRestController',
		templateUrl:'_home/home.html'
	})
	.when('/postjob',{
		controller:'JobsRestController',
		templateUrl:'_job/createJob.html'
	})	
	.when('/getAllJobs',{		
		controller:'JobsRestController',
		templateUrl:'_job/displayjobs1.html'
	})	
	.when('/reqAddBlog',{		
		controller:'BlogRestController',
		templateUrl:'_blog/addBlog.html'
	})	
	.when('/reqDisplayBlogs',{		
		controller:'BlogRestController',
		templateUrl:'_blog/displayBlogs.html'
	})	
	.when('/reqDisplaynewBlogs',{		
		controller:'BlogRestController',
		templateUrl:'_blog/displaynew.html'
	})	
	.when('/uploadPicture',{	
		templateUrl:'_user/uploadPicture.html'
	})		
	.when("/chat",
	{
		templateUrl:"_chat/chat.html",
	controller:'ChatController'
	})
	.otherwise({
		templateUrl:'_default/default.html'
	})
	
})



app.run(function($cookieStore,$rootScope,$location,UserService){  //entry point
	
	if($rootScope.presentUser==undefined)
		$rootScope.presentUser=$cookieStore.get('presentUser')
		
	$rootScope.logoff=function(){
		console.log('logout function')
		delete $rootScope.presentUser;
		$cookieStore.remove('presentUser')
		UserService.logout()
		.then(function(response){
			console.log("logged out successfully..");
			$rootScope.message="Logged out Successfully";
			$location.path('/login')
		},
		function(response){
			console.log(response.status);
		})
		
	}	
})









/*

.when('/logout',{		
		controller:'UserController',
		templateUrl:'_user/login.html'
	})	*/