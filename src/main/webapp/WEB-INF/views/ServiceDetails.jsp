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

				<a href="clientpannel" style="text-decoration: none; margin: 0 auto"><button
						class="nav-link  m-2 " id="v-pills-home-tab" data-bs-toggle="pill"
						data-bs-target="#v-pills-home" type="button" role="tab"
						aria-controls="v-pills-home" aria-selected="true">Customer
						Section</button></a> <a href="cardetails"
					style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link  m-2" id="v-pills-profile-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-profile"
						type="button" role="tab" aria-controls="v-pills-profile"
						aria-selected="false">Car Section</button></a> <a
					href="servicedetailspage"
					style="text-decoration: none; margin: 0 auto"><button
						class="nav-link active m-2" id="v-pills-settings-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-settings"
						type="button" role="tab" aria-controls="v-pills-settings"
						aria-selected="false">Servicing Section</button></a>

				<button class="nav-link m-2" id="v-pills-settings-tab"
					data-bs-toggle="pill" data-bs-target="#v-pills-settings"
					type="button" role="tab" aria-controls="v-pills-settings"
					aria-selected="false">Spare Parts Section</button>

				<a href="techiepage" style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link m-2" id="v-pills-settings-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-settings"
						type="button" role="tab" aria-controls="v-pills-settings"
						aria-selected="false">Technician Section</button></a>
			</div>





			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="v-pills-profile"
					role="tabpanel" aria-labelledby=v-pills-profile-tab>

				<!-- 	<div class="col-12"
						style="text-align: center; margin-bottom: 15px;">
						<a href="addnewvehicle">
							<button type="button" class="btn btn-success" style="width: 50%">Add Main Service</button>
						</a>
					</div> -->

					<div class="searchform" style="width: 100%;">
						<form:form class="row g-3" action="searchcarbynplate" method="POST"
							modelAttribute="carDetails">

							<!-- Add Car Details Button on a new line -->

							<h4 style="margin-bottom: 15px;">Search Car for Service Allocation</h4>

							<div class="namecontact"
								style="display: flex; flex-wrap: wrap; justify-content: space-between;">

								<div class="col-md-6"
									style="flex-basis: 30%; margin-bottom: 15px;">
									<label for="inputContact4" class="form-label">Vehicle
										Number Plate</label> <input type="text" class="form-control"
										id="inputContact4" name="vehiclenplate"
										placeholder="Enter Number here"
										value="${carinfo.vehiclenplate}"> <span
										id="validationMessage"
										style="color: blue; justify-content: center;"></span>
								</div>

							</div>
							<!-- Search Button on a new line -->
							<div class="col-12" style="text-align: center; margin-top: 15px;">
								<button type="submit" class="btn btn-success"
									style="width: 15%;">Search</button>
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
									<th scope="col">Technician</th>
								</tr>
							</thead>
							<tbody>
								<%
								int count = 0;
								%>
								<c:forEach var="vehicle" items="${vehicles }">
									<tr>
										<td><a href="allocateservice?VisitID=${vehicle.vehicleid}"
											type="button" class="btn btn-info btn-sm"> <%=++count%></a></td>
										<td>${vehicle.vehiclemodel }</td>
										<td>${vehicle.vehiclenplate }</td>
										<td>${vehicle.visitVrun }</td>
										<td>${vehicle.visitVentryDate }</td>
										<td>${vehicle.tname}</td>
									</tr>
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
	<!-- <script type="text/javascript"
		src="/CarGarageApplicationMVC/URLToReachResourceFolder/js/myjs.js" /> -->
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