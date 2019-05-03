
myApp.controller("ChatController",function($scope,$rootScope,chatService)
{
	console.log('Starting Chat Controller')
	
	$scope.messages=[];
	$scope.message="";
	$scope.max=140;
	
	$scope.addmessage=function()
	{
		console.log('Adding Message Method');
		chatService.send($rootScope.currentUser.username+":"+$scope.message);
		$scope.message="";
	};
	
	chatService.receive().then(null,null,function(message){
		console.log('Receive Method');
		$scope.messages.push(message);
	});
	
});
