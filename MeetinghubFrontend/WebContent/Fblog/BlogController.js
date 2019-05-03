myApp.controller('BlogController',function($scope,$http,$location,$rootScope,$cookieStore)
	{
	
	   $scope.blog={'blogname':'','blogcontent':'','username':'','status':'','likes':0,'dislikes':0};
	   $scope.blogdata;
	   $scope.loadblog;
	   $rootScope.bloginfo;
	   
	   $scope.addblog=function()
	   {
		   console.log('Adding Blog Function');
		   
		   $scope.blog.username=$rootScope.currentUser.username;
		   $scope.blog.status='NotApprove';
		   $http.post('http://localhost:8082/Middleware/addblog',$scope.blog)
		   .then(function(response)
		    {
			    console.log('Blog Added');
			    if(response.status==200)
			    	{
			    	
			    	$location.path('/showblog');
			    	}
			    console.log(response.data);
			});
		   
		   
	   }
	   
	   function loadblog()
	   {
		   console.log('Loading All Blogs');
		   $http.get('http://localhost:8082/Middleware/listblogs')
		   .then(function(response)
			{
			   console.log('Loading Blog');
			   $scope.blogdata=response.data;
			   console.log($scope.blogdata);
			});	
	   }
	   
	   $scope.incrementlikes=function(blogid)
	   {
		   console.log('Increment Likes');
		   $scope.isDisabled = true;
		   $http.get('http://localhost:8082/Middleware/incrementlikes/'+blogid)
		   .then(function(response){
			   
		   });
	   }
	   
	   $scope.incrementdislikes=function(blogid)
	   {
		   console.log('Increment DisLikes');
		   $http.get('http://localhost:8082/Middleware/incrementdislikes/'+blogid)
		   .then(function(response){
			   
		   });
	   }
	   
	   $scope.approveblog=function(blogid)
	   {
		   console.log('Approving Blog');
		   $http.get('http://localhost:8082/Middleware/approveblog/'+blogid)
		   .then(function(response){
			   
		   });
	   }
	   
	   $scope.rejectblog=function(blogid)
	   {
		   console.log('Rejecting Blog');
		   $http.get('http://localhost:8082/Middleware/rejectblog/'+blogid)
		   .then(function(response){
			   
		   });
	   }
	   
	   $scope.deleteblog=function(blogid)
	   {
		   console.log('Deleting Blog');
		   $http.get('http://localhost:8082/Middleware/deleteblog/'+blogid)
		   .then(function(response){
			   if(response.status==200)
		    	{
		    	
		    	$location.path('/addblog');
		    	}
						   
		   });
	   }
	   
	   $scope.showblog=function(blogid)
	   {
		   console.log('Showing Blog Details');
		   $http.get('http://localhost:8082/Middleware/getblog/'+blogid)
		   .then(function(response){
			  $rootScope.bloginfo=response.data;
			  console.log($rootScope.bloginfo);
			  $location.path('/blogdetail');
		   });
		   
	   }
	   
	   $scope.editblog=function(blogid)
	   {
		   console.log('Editing Blog');
		   $http.get('http://localhost:8082/Middleware/getblog/'+blogid)
		   .then(function(response){
			  $rootScope.bloginfo=response.data;
			  console.log($rootScope.bloginfo);
			  $location.path('/updatebloginfo');
		   });
		   
	   }
	   
	   $scope.updateblog=function()
	   {
		   console.log('Updating Blog');
		   $scope.blog=$rootScope.bloginfo;
		   $http.post('http://localhost:8082/Middleware/updateblog',$scope.blog)
		   .then(function(response){
			  console.log('Blog Is Updated');
			  $location.path('/showblog');
		   });
		   
	   }
	   
	   loadblog();
	   	
    });