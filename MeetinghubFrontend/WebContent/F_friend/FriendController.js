myApp.controller('FriendController',function($scope,$http,$location,$rootScope)
  { 
	
	$scope.friend={'friendid':'','username':'','friendname':'','status':''};
	$scope.User={'username':'','password':'','customername':'','emailid':'','status':'','role':'','isonline':'','mobileno':''};
	
	$scope.friendlist;
	$scope.pendingfriendlist;
	$scope.suggestedfriendlist;
	$rootScope.currentUser;
	$scope.friend;
	
	function showfriendlist()
	{
		console.log('Showing FriendList')
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8082/Middleware/listfriends/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.friendlist=response.data;
			console.log($scope.friendlist);
		});
	}
	
	function showpendingfriendlist()
	{
		console.log('Showing Pending Friend List')
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8082/Middleware/pendingfriendrequest/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.pendingfriendlist=response.data;
			console.log($scope.pendingfriendlist);
		});
		
	}
	
	function showsuggestedfriendlist()
	{
		console.log('Showing suggested Friend List')
		console.log($rootScope.currentUser.username);
		$http.get('http://localhost:8082/Middleware/suggestedfriends/'+$rootScope.currentUser.username)
		.then(function(response){
			$scope.suggestedfriendlist=response.data;
			console.log($scope.suggestedfriendlist);
		});
		
	}
	
	$scope.unfriend=function(friendid)
	{
		console.log('Unfriending');
		$http.get('http://localhost:8082/Middleware/deletefriendrequest/'+friendid)
		.then(function(response){
			 if(response.status==200)
		    	{		    	
		    	$location.path('/userhome');
		    	}
			    
			$scope.log('Friend Deleted');
		});
		
	}
	
	$scope.acceptrequest=function(friendid)
	{
		console.log('Accepting Friend Request');
		$http.get('http://localhost:8082/Middleware/acceptfriendrequest/'+friendid)
		.then(function(response){
			if(response.status==200)
	    	{		    	
	    	$location.path('/userhome');
	    	}
			$scope.log('Friend Request Accepted');
		});
		
	}
	
	$scope.sendrequest=function(frndname)
	{
		$scope.friend.username=$rootScope.currentUser.username;
		$scope.friend.friendname=frndname;
		$http.post('http://localhost:8082/Middleware/sendfriendrequest',$scope.friend)
		.then(function(response){
			if(response.status==200)
	    	{		    	
	    	$location.path('/userhome');
	    	}
			$scope.log('Friend Request Sent');
		});
		
	}
	
	  
	    showfriendlist();
	    showpendingfriendlist();
	    showsuggestedfriendlist();
	
	});