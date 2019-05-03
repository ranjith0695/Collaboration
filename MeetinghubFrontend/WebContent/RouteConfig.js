var myApp=angular.module("myApp",['ngRoute','ngCookies']);
myApp.config(function($routeProvider)
		{
			
			$routeProvider.when("/login",{templateUrl:"Fuser/Login.html"})
			.when("/home",{templateUrl:"Meetinghub/Home.html"})
			.when("/userhome",{templateUrl:"Fuser/UserHome.html"})
			.when("/myCarousel",{templateUrl:"Fuser/UserHome.html"})
			.when("/register",{templateUrl:"Fuser/Register.html"})
			.when("/aboutus",{templateUrl:"Meetinghub/Aboutus.html"})
			.when("/adminhome",{templateUrl:"Meetinghub/AdminHome.html"})
			.when("/addblog",{templateUrl:"Fblog/Blog.html"})
			.when("/showblog",{templateUrl:"Fblog/ShowBlog.html"})
			.when("/manageblog",{templateUrl:"Fblog/ManageBlog.html"})
			.when("/blogdetail",{templateUrl:"Fblog/BlogDetails.html"})
			.when("/updatebloginfo",{templateUrl:"Fblog/UpdateBlog.html"})
			.when("/profilepic",{templateUrl:"Fuser/ProfilePicture.html"})
			.when("/friendlist",{templateUrl:"F_friend/FriendList.html"})
			.when("/showjobs",{templateUrl:"Fjob/Job.html"})
			.when("/managejobs",{templateUrl:"Fjob/ManageJob.html"})
			.when("/updatejob",{templateUrl:"Fjob/UpdateJob.html"})
			.when("/forum",{templateUrl:"F_forum/Forum.html"})
			.when("/manageforum",{templateUrl:"F_forum/ManageForum.html"})
			.when("/chat",{templateUrl:"Fchat/Chat.html"});
			

		});

myApp.run(function($rootScope,$cookieStore){
	       console.log('I am in Run Function');
	       
	       console.log($rootScope.currentUser);
	       
	       if($rootScope.currentUser==undefined)
	    	   {
	    	      console.log($cookieStore.get('Userinfo'));
	    	      $rootScope.currentUser=$cookieStore.get('Userinfo');
	    	      
	    	   }
	
		});
	