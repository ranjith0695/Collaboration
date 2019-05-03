myApp.controller('JobController',function($scope,$http,$location,$rootScope,$cookieStore)
 {
	 
	$scope.job={'designation':'','jobdesc':'','qualification':'','Status':''};
	$scope.loadjobs;
	$scope.jobdata;
	$rootScope.jobdetail
	
	$scope.addjob=function()
	   {
		   console.log('Adding Job');
		   		   
		   $scope.job.status='Approve';
		   $http.post('http://localhost:8082/Middleware/addjob',$scope.job)
		   .then(function(response)
		    {
			    console.log('Job Added');
			    if(response.status==200)
		    	{		    	
		    	$location.path('/adminhome');
		    	}
			    
			});
	   }
	
	$scope.deletejob=function(jobid)
	   {
		   console.log('Deleting job');
		   $http.get('http://localhost:8082/Middleware/deletejob/'+jobid)
		   .then(function(response){
			   if(response.status==200)
		    	{		    	
		    	$location.path('/adminhome');
		    	}
			   
		   });
	   }
	
	 function loadjobs()
	   {
		   console.log('Loading All Jobs');
		   $http.get('http://localhost:8082/Middleware/listjobs')
		   .then(function(response)
			{
			   console.log('Loading Job');
			   $scope.jobdata=response.data;
			   console.log($scope.jobdata);
			});	
	   }
	 
	 $scope.editjob=function(jobid)
	   {
		   console.log('Editing job');
		   $http.get('http://localhost:8082/Middleware/getjob/'+jobid)
		   .then(function(response){
			  $rootScope.jobdetail=response.data;
			  console.log($rootScope.jobdetail);
			  $location.path('/updatejob');
		   });
		   
	   }
	   
	   $scope.updatejob=function()
	   {
		   console.log('Updating job');
		   $scope.job=$rootScope.jobdetail;
		   $http.post('http://localhost:8082/Middleware/updatejob',$scope.job)
		   .then(function(response){
			  console.log('job Is Updated');
			  $location.path('/managejobs');
		   });
	   }
	    
         loadjobs();
	
  });