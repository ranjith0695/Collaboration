myApp.controller('ForumController',function($scope,$http,$location,$rootScope,$cookieStore)
  {
	
	$scope.forum={'forumname':'','forumcontent':'','username':'','status':''};
	$scope.loadforum;
	$scope.forumdata;
	
	function loadforum()
	{
		console.log('Loading All Forums');
		   $http.get('http://localhost:8082/Middleware/listforums')
		   .then(function(response)
			{
			   console.log('Loading Forum');
			   $scope.forumdata=response.data;
			   console.log($scope.forumdata);
			});	
	}
	
	 $scope.addforum=function()
	   {
		   console.log('Adding Forum Function');
		   
		   $scope.forum.username=$rootScope.currentUser.username;
		   $scope.forum.status='Approve';
		   $http.post('http://localhost:8082/Middleware/addforum',$scope.forum)
		   .then(function(response)
		    {
			    console.log('Forum Added');
			    if(response.status==200)
		    	{		    	
		    	$location.path('/home');
		    	}
			    
			    
			    console.log(response.data);
			});
	   }
	 
	 	   
	   $scope.rejectforum=function(forumid)
	   {
		   console.log('Rejecting forum');
		   $http.get('http://localhost:8082/Middleware/rejectforum/'+forumid)
		   .then(function(response){
			   
		   });
	   }
	   
	   $scope.deleteforum=function(forumid)
	   {
		   console.log('Deleting forum');
		   $http.get('http://localhost:8082/Middleware/deleteforum/'+forumid)
		   .then(function(response){
			   if(response.status==200)
		    	{		    	
		    	$location.path('/adminhome');
		    	}
		   });
	   }
	   
	loadforum();
	
  });