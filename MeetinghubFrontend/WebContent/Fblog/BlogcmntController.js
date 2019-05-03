myApp.controller('BlogcmntController',function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.blogcmnt={'cmntid':'0','blogid':'0','cmnttext':'','cmntdate':'','username':''};
	
	$scope.blogcmnts;
	$rootScope.currentUser;
	$rootScope.bloginfo;
	
	$scope.addblogcmnt=function()
	{
		console.log('Adding Blogcmnt')
		$scope.blogcmnt.blogid=$rootScope.bloginfo.blogid;
		$scope.blogcmnt.username=$rootScope.currentUser.username;
		
		$http.post('http://localhost:8082/Middleware/addblogcmnt',$scope.blogcmnt)
		.then(function(response){
			if(response.status==200)
	    	{
	    	
	    	$location.path('/showblog');
	    	}
			
		});
	}
	function loadblogcmnts()
	{
		console.log('Loading Blog Comments');
		$http.get('http://localhost:8082/Middleware/listblogcmnts/'+$rootScope.bloginfo.blogid)
		.then(function(response){
			
			$scope.blogcmnts=response.data;
		});
	}
	
	$scope.deletecmnt=function(cmntid)
	{
		console.log('Deleting Comment')
		$http.get('http://localhost:8082/Middleware/deleteblogcmnt/'+cmntid)
		.then(function(response){
			if(response.status==200)
	    	{
	    	
	    	$location.path('/showblog');
	    	}
			
		});
		
	}
	
	
	loadblogcmnts();
	
	
		});
