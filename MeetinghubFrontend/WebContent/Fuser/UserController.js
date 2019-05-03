myApp.controller('UserController',function($scope,$http,$location,$rootScope,$cookieStore)
	{
	
	$scope.User={'username':'','password':'','customername':'','emailid':'','status':'','role':'','isonline':'','mobileno':''};
	
	$cookieStore.put($rootScope.currentUser);
	$scope.register=function()
	{
		console.log('I am in Register Function');
		
		$scope.User.role='student';
		$scope.User.status='Approve';
		$scope.User.isonline='ON';
		
		console.log('User details are :');
		console.log($scope.User);
		
		$http.post('http://localhost:8082/Middleware/registeruser',$scope.User)
		.then(function(response){
		
			console.log('Registered');
			if(response.status==200)
	    	{
	    	
	    	$location.path('/login');
	    	}
			
		});
		
	}
	
	$scope.checklogin=function()
	{
		console.log('I am in Login Function');
		
		$http.post('http://localhost:8082/Middleware/checklogin',$scope.User)
		.then(function(response){
			console.log('Login Checked')
			$scope.User=response.data;
			$rootScope.currentUser=response.data;
			console.log($rootScope.currentUser);
			$cookieStore.put('Userinfo',$rootScope.currentUser);
			$location.path('/userhome')
		});
				
	}
	
	$scope.logout=function()
	{
		console.log('I am in Logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('Userinfo');
		$location.path('/logout');
	}
	
	});

