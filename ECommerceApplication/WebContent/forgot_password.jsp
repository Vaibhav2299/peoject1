<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>

<!--css-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
}
</style>

</head>
<body>
	
	<!--navbar-->
	<%@include file="normal_navbar.jsp"%>
	

	<main
		class="d-flex align-items-center primary-background banner-background"
		style="height: 70vh">
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">

					<div class="card">
						<div class="card-header primary-background text-white text-center">
							<p>Forgot Your Password</p>
						</div>

						<div class="card-body">
							<form action="ForgotPassword" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label> <input
										name="email" required type="email" class="form-control"
										id="exampleInputEmail1" aria-describedby="emailHelp"
										placeholder="Enter Your Registered Email" autofocus>
								</div>
								
								<div class="form-group">
									<label for="exampleInputPassword1">New Password</label> <input
										name="npassword" required type="password" class="form-control"
										id="exampleInputPassword" placeholder="New Password">
								</div>
								
								<div class="form-group">
									<label for="exampleInputPassword1">Confirm Password</label> <input
										name="cpassword" required type="password" class="form-control"
										id="exampleInputPassword1" placeholder="Confirm Password">
									<span id='message'></span>
								</div>
																
								<div class="container text-center">
									<button type="submit" class="btn btn-primary">Set Password</button>
								</div>
							</form>

						</div>


					</div>



				</div>


			</div>

		</div>

	</main>





	<!--javascripts-->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript"></script>
	
	
	
	<!-- script code -->
	
	<script>
	$('#exampleInputPassword, #exampleInputPassword1').on('keyup', function () {
		  if ($('#exampleInputPassword').val() == $('#exampleInputPassword1').val()) {
		    $('#message').html('Matching').css('color', 'green');
		  } else 
		    $('#message').html('Not Matching').css('color', 'red');
		});
		
	</script>
	
</body>
</html>