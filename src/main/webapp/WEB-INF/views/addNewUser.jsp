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

<link type="text/css" rel="stylesheet"
	href="/CarGarageApplicationMVC/URLToReachResourceFolder/css/mycss.css" />

<title>Hello, world!</title>
</head>
<body>
	<div class="container">
		<h1>Add Update User</h1>
		<div class="searchform">
			<form:form class="row g-3" action="processform" method="POST">

				<div class="namecontact"
					style="display: flex; justify-content: space-between;">

					<div class="col-md-6" style="flex-basis: 30%;">
						<label for="inputName4" class="form-label">Name</label> <input
							type="text" class="form-control" id="inputName4" name="username"
							placeholder="Enter Name here" value="${userinfo.username}">
					</div>
					<div class="col-md-6" style="flex-basis: 30%;">
						<label for="inputContact" class="form-label">Contact</label> <input
							type="text" class="form-control" id="inputContact4"
							name="usercontact" placeholder="Enter Contact here"
							value="${userinfo.usercontact}"> <span
							id="validationMessage"
							style="color: blue; justify-content: center;"></span>
					</div>

					<div class="col-md-6" style="flex-basis: 30%;">
						<label for="inputEmail4" class="form-label">Email</label> <input
							type="email" class="form-control" id="inputEmail4"
							name="useremail" placeholder="Enter Email here"
							value="${userinfo.useremail}"> <span
							id="emailValidationMessage"
							style="color: blue; justify-content: center;"></span>
					</div>

				</div>

				<div class="col-12" style="flex-basis: 31%;">
					<label for="inputAddress" class="form-label">Address</label> <input
						type="text" class="form-control" id="inputAddress"
						name="useraddress" placeholder="Enter Address here"
						value="${userinfo.useraddress}">
				</div>

				<div class="btns" style="display: flex;">
					<div class="col-12" style="flex-basis: 20%; margin-top: 10px;">
						<button type="submit" class="btn btn-success">Save</button>
					</div>

					<div class="col-12" style="flex-basis: 20%; margin-top: 10px;">
						<button type="submit" class="btn btn-success">Update Data</button>
					</div>

				</div>
			</form:form>
		</div>

		<div class="disptable" style="margin-top: 30px;">
			<table class="table" style="border: 1px solid black;">
				<thead>
					<tr class=" table-success">
						<th scope="col">Sr no.</th>
						<th scope="col">Vehicle Model</th>
						<th scope="col">Registered Vehicle Number</th>
						<th scope="col">Vehicle Running in KMs</th>
						<th scope="col">Entry Date</th>
					</tr>
				</thead>
				<tbody>
					<%
					int count = 0;
					%>
					<c:forEach var="vehicle" items="${vehicles }">
						<tr>
							<td><button type="button" data-bs-toggle="modal"
									data-bs-target="#modal${vehicle.vehicleid}">

									<%=++count%></button></td>
							<td>${vehicle.vehiclemodel }</td>
							<td>${vehicle.vehiclenplate }</td>
							<td>${vehicle.vehiclerun }</td>
							<td>${vehicle.vehicledate }</td>
						</tr>

						<!-- Modal -->
						<div class="modal fade" id="modal${vehicle.vehicleid}" tabindex="-1"
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
										<a href="updateSave?userID=${vehicle.vehicleid}"><button
												type="button" class="btn btn-primary"
												data-bs-dismiss="modal">Update</button></a>
										<button type="button" class="btn btn-danger"
											data-bs-toggle="modal"
											data-bs-target="#modaldelete${vehicle.vehicleid}">Delete</button>
									</div>
								</div>
							</div>
						</div>

						<!--Delete Modal -->
						<div class="modal fade" id="modaldelete${vehicle.vehicleid}"
							tabindex="-1" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Sure! Do
											you want to Delete?</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<a href="deleteUser?userID=${vehicle.vehicleid}"><button
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