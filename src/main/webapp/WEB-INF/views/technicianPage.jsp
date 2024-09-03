<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<link type="text/css" rel="stylesheet"
	href="/CarGarageApplicationMVC/URLToReachResourceFolder/css/mycss.css" />
<title>Admin Panel</title>
<link rel="icon" type="image/x-icon"
	href="/CarGarageApplicationMVC/URLToReachResourceFolder/Images/repair-shop.png" />

<style type="text/css">
.container {
	background-color: #e0fbfc;
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

.nav {
	width: 100%;
}

.nav .navbar {
	width: 100%;
	background-color: #3d5a80;
}

.menubar {
	display: flex;
	width: 100%;
	flex-grow: 1;
}

.nav-pills {
	flex-basis: 20%;
	background-color: #293241;
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
				<a href="clientpannel" style="text-decoration: none; margin: 0 auto"><button
						class="nav-link  m-2" id="v-pills-home-tab" data-bs-toggle="pill"
						data-bs-target="#v-pills-home" type="button" role="tab"
						aria-controls="v-pills-home" aria-selected="true">Customer
						Section</button></a> <a href="cardetails"
					style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link m-2" id="v-pills-profile-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-profile"
						type="button" role="tab" aria-controls="v-pills-profile"
						aria-selected="false">Car Section</button></a>
				<button class="nav-link m-2" id="v-pills-settings-tab"
					data-bs-toggle="pill" data-bs-target="#v-pills-settings"
					type="button" role="tab" aria-controls="v-pills-settings"
					aria-selected="false">Servicing Section</button>
				<button class="nav-link m-2" id="v-pills-settings-tab"
					data-bs-toggle="pill" data-bs-target="#v-pills-settings"
					type="button" role="tab" aria-controls="v-pills-settings"
					aria-selected="false">Spare Parts Section</button>
				<a href="techiepage" style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link active m-2" id="v-pills-settings-tab"
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
							<!-- 							<a href="addnewtechie"><button type="button"
									class="btn btn-success" style="width: 50%;">Add New
									Technician</button></a> -->

							<!-- Button to Open the Modal -->
							<button type="button" class="btn btn-success"
								data-bs-toggle="modal" data-bs-target="#techModal">
								Add Technician Details</button>

							<!-- The Modal -->
							<div class="modal fade" id="techModal" tabindex="-1"
								aria-labelledby="vehicleModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<!-- Modal Header -->
										<div class="modal-header">
											<h5 class="modal-title" id="vehicleModalLabel">Technician
												Details</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>

										<!-- Modal Body -->
										<div class="modal-body">
											<form:form action="submitformfortechie" method="POST"
												modelAttribute="techieDetail">

												<input name="tid" type="hidden" value="" />

												<div class="mb-3">
													<label for="inputVehicleModel5" class="form-label">Technician
														Name</label> <input type="text" class="form-control"
														id="inputVehicleModel5" name="tname"
														placeholder="Enter Name here" value="">
												</div>

												<!-- Modal Footer -->
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Save
														changes</button>
												</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<form:form class="row g-3" action="processformfortechie"
							method="POST" modelAttribute="techieDetail">
							<h4>Search Technician Details</h4>
							<div class="namecontact"
								style="display: flex; flex-wrap: wrap; justify-content: space-between;">
								<div class="col-md-6"
									style="flex-basis: 30%; margin-bottom: 15px;">
									<label for="inputName4" class="form-label">Name</label> <input
										type="text" class="form-control" id="inputName4" name="tname"
										placeholder="Enter Name here" value="${techieinfo.tname}">
								</div>
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
								<tr class="table-success">
									<th scope="col">Sr no.</th>
									<th scope="col">Technician Name</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
								int count = 0;
								%>
								<c:forEach var="techie" items="${techies}">
									<tr>
										<td><a href="updateTechie?tID=${techie.tid}"
											type="button" class="btn btn-info btn-sm"><%=++count%></a></td>
										<td>${techie.tname}</td>
										<td><button type="button" class="btn btn-danger btn-sm"
												data-bs-toggle="modal"
												data-bs-target="#modaldelete${techie.tid}">Delete</button></td>
									</tr>

									<!--Delete Modal -->
									<div class="modal fade" id="modaldelete${techie.tid}"
										tabindex="-1" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Do you
														want to Delete Technician?</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Close</button>
													<a href="deleteTechie?tID=${techie.tid}"><button
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

	<!-- Optional JavaScript; choose one of the two! -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
		integrity="sha384-ZcbIMZojZhxot2cA+CnN2z5F3aVG9S6dQLHOB+DQTF+f9v7HWxIO4n8CdyGr68/Ei"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGhrtS3bZg3Skvjy1TdxCx2gY/5cnlg78LVXL2/5gplF8KcQ17W9R+zxD8pP"
		crossorigin="anonymous"></script>
</body>
</html>
