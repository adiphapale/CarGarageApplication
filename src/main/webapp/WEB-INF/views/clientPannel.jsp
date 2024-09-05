<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link type="text/css" rel="stylesheet"
	href="/CarGarageApplicationMVC/URLToReachResourceFolder/css/mycss.css" />

<title>adminPannel</title>


<link rel="icon" type="image/x-icon"
	href="/CarGarageApplicationMVC/URLToReachResourceFolder/Images/repair-shop.png" />


<style type="text/css">
.container {
	background-color: #e0fbfc;
	display: flex;
	flex-direction: column;
	min-height: 100vh; /* Ensure it covers the full viewport height */
}

.nav {
	width: 100%;
}

.nav .navbar {
	width: 100%;
	/* background-color: #eeeedd; */
	background-color: #3d5a80;
}

.menubar {
	display: flex;
	width: 100%;
	flex-grow: 1; /* Let it grow to fill available space */
}

.nav-pills {
	flex-basis: 20%;
	background-color: #293241;
	/* No height specified, it will grow with the container */
}

.tab-content {
	flex-basis: 80%;
	padding-top: 15px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="nav">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="#" style="color: white"><i
						class="fa-solid fa-car-on"></i> GoGarage AutoMobs</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-end"
						id="navbarNav">
						<form class="d-flex ms-auto">
							<button class="btn btn-outline-light" type="submit">Logout</button>
						</form>
					</div>
				</div>
			</nav>
		</div>

		<div class="menubar">
			<div class="nav flex-column nav-pills me-3" id="v-pills-tab"
				role="tablist" aria-orientation="vertical">
				<!-- <a href="newcustvehicle"
					style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link m-2" id="v-pills-messages-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-messages"
						type="button" role="tab" aria-controls="v-pills-messages"
						aria-selected="false">Add New Customer/Vehicle</button></a> -->



				<a href="clientpannel" style="text-decoration: none; margin: 0 auto"><button class="nav-link active m-2 " id="v-pills-home-tab"
					data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button"
					role="tab" aria-controls="v-pills-home" aria-selected="true">Customer
					Section</button></a>
					
				<a href="cardetails" style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link m-2" id="v-pills-profile-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-profile"
						type="button" role="tab" aria-controls="v-pills-profile"
						aria-selected="false">Car Section</button></a>

				<a
					href="servicedetailspage"
					style="text-decoration: none; margin: 0 auto"><button class="nav-link m-2" id="v-pills-settings-tab"
					data-bs-toggle="pill" data-bs-target="#v-pills-settings"
					type="button" role="tab" aria-controls="v-pills-settings"
					aria-selected="false">Servicing Section</button></a>

				<button class="nav-link m-2" id="v-pills-settings-tab"
					data-bs-toggle="pill" data-bs-target="#v-pills-settings"
					type="button" role="tab" aria-controls="v-pills-settings"
					aria-selected="false">Spare Parts Section</button>
					
				<a href="techiepage" style="margin: 0 auto; text-decoration: none;"><button class="nav-link m-2" id="v-pills-settings-tab"
					data-bs-toggle="pill" data-bs-target="#v-pills-settings"
					type="button" role="tab" aria-controls="v-pills-settings"
					aria-selected="false">Technician Section</button></a>
			</div>

			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="v-pills-home"
					role="tabpanel" aria-labelledby="v-pills-home-tab">

					<div class="searchform" style="width: 100%;">

						<div class="col-12"
							style="text-align: center; margin-bottom: 15px;">
							<a href="addnewcustomer">
								<button type="button" class="btn btn-success"
									style="width: 50%;">Add New Customer</button>
							</a>
						</div>
						<form:form class="row g-3" action="processform" method="POST"
							modelAttribute="userDetails">

							<h4>Search Customer Details</h4>

							<div class="namecontact"
								style="display: flex; flex-wrap: wrap; justify-content: space-between;">

								<div class="col-md-6"
									style="flex-basis: 30%; margin-bottom: 15px;">
									<label for="inputName4" class="form-label">Name</label> <input
										type="text" class="form-control" id="inputName4"
										name="username" placeholder="Enter Name here"
										value="${userinfo.username}">
								</div>

								<div class="col-md-6"
									style="flex-basis: 30%; margin-bottom: 15px;">
									<label for="inputContact" class="form-label">Contact</label> <input
										type="text" class="form-control" id="inputContact4"
										name="usercontact" placeholder="Enter Contact here"
										value="${userinfo.usercontact}"> <span
										id="validationMessage"
										style="color: blue; justify-content: center;"></span>
								</div>

								<div class="col-md-6"
									style="flex-basis: 30%; margin-bottom: 15px;">
									<label for="inputEmail4" class="form-label">Email</label> <input
										type="email" class="form-control" id="inputEmail4"
										name="useremail" placeholder="Enter Email here"
										value="${userinfo.useremail}"> <span
										id="emailValidationMessage"
										style="color: blue; justify-content: center;"></span>
								</div>

							</div>

							<div class="col-12" style="flex-basis: 31%; margin-bottom: 15px;">
								<label for="inputAddress" class="form-label">Address</label> <input
									type="text" class="form-control" id="inputAddress"
									name="useraddress" placeholder="Enter Address here"
									value="${userinfo.useraddress}">
							</div>

							<div class="col-12" style="text-align: center; margin-top: 15px;">
								<button type="submit" class="btn btn-success"
									style="width: 15%;">Search</button>
							</div>

						</form:form>
					</div>

					<div class="disptable" style="margin-top: 30px; width: 100%;">
						<table class="table" style="border: 1px solid black;">
							<thead>
								<tr class=" table-success">
									<th scope="col">Sr no.</th>
									<th scope="col">Name</th>
									<th scope="col">Contact</th>
									<th scope="col">Email</th>
									<th scope="col">Address</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									int count = 0;
									%>
								<c:forEach var="user" items="${users }">
									<tr>
										<%-- <td><button type="button" data-bs-toggle="modal"
												data-bs-target="#modal${user.userid}">

												<%=++count%></button></td> --%>
										<td><a href="updateSave?userID=${user.userid}"
											type="button" class="btn btn-info btn-sm"><%=++count %></a></td>
										<td>${user.username }</td>
										<td>${user.usercontact }</td>
										<td>${user.useremail }</td>
										<td>${user.useraddress }</td>
										<td><button type="button" class="btn btn-danger btn-sm"
												data-bs-toggle="modal"
												data-bs-target="#modaldelete${user.userid}">Delete</button></td>
									</tr>

									<%-- <!-- Modal -->
									<div class="modal fade" id="modal${user.userid}" tabindex="-1"
										aria-labelled by="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Do You
														Want to Update or Delete</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>

												<div class="modal-footer">
													<a href="updateSave?userID=${user.userid}"><button
															type="button" class="btn btn-primary"
															data-bs-dismiss="modal">Update</button></a>
													<button type="button" class="btn btn-danger"
														data-bs-toggle="modal"
														data-bs-target="#modaldelete${user.userid}">Delete</button>
												</div>
											</div>
										</div>
									</div> --%>

									<!--Delete Modal -->
									<div class="modal fade" id="modaldelete${user.userid}"
										tabindex="-1" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Do you
														want to Delete?</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>

												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Close</button>
													<a href="deleteUser?userID=${user.userid}"><button
															type="button" class="btn btn-danger">Delete</button></a>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>

			</div>
		</div>
	</div>


	</div>

	<!-- Optional JavaScript; choose one of the two! -->
	<script type="text/javascript"
		src="/CarGarageApplicationMVC/URLToReachResourceFolder/js/myjs.js" />
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>

</body>
</html>