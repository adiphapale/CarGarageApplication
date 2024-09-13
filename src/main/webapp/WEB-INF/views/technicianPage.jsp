<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet"
	href="/CarGarageApplicationMVC/URLToReachResourceFolder/css/styleadmin.css" />


<style type="text/css">

/* Container for the entire form */
.form-container {
	width: 100%;
	padding: 20px;
	background-color: #fff;
	border-radius: 12px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
	margin: 20px 0;
}

/* General styling for form fields */
.form-group {
	margin-bottom: 20px;
}

.form-group label {
	font-size: 16px;
	font-weight: 500;
	color: #333;
	margin-bottom: 5px;
	display: block;
}

.form-group input[type="text"], .form-group input[type="date"],
	.form-group input[type="date"], .form-group textarea {
	width: 100%;
	padding: 10px 15px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 16px;
	transition: border-color 0.3s ease;
}

.form-group select {
	width: 100%;
	padding: 10px 15px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 16px;
	transition: border-color 0.3s ease;
}

.form-group input:focus, .form-group textarea:focus {
	border-color: #0A2558;
	outline: none;
}

/* Button styling */
.button-container {
	display: flex;
	justify-content: center;
}

.button-container button {
	background-color: #0A2558;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 6px;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.button-container button:hover {
	background-color: #0d3073;
}

/* Error messages */
#validationMessage, #emailValidationMessage {
	color: blue;
	text-align: center;
	display: block;
	margin-top: 5px;
}

/* Overall sales-boxes styling */
.sales-boxes {
	margin-top: 20px;
	font-family: 'Arial', sans-serif;
}

/* Recent sales box styling */
.sales-boxes .recent-sales.box {
	background-color: #fff;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
}

/* Table container for scrollable table */
.sales-boxes .table-responsive {
	overflow-x: auto;
	-webkit-overflow-scrolling: touch;
	border-radius: 10px;
}

/* Table styling */
.sales-boxes .table {
	width: 100%;
	border-collapse: collapse;
	font-size: 16px;
	text-align: left;
	background-color: #f9f9f9;
	margin-bottom: 20px;
}

/* Table header styling */
.sales-boxes .table thead {
	background-color: #4CAF50;
	color: white;
	font-weight: bold;
}

.sales-boxes .table thead th {
	padding: 12px 15px;
	font-size: 18px;
}

/* Table body rows */
.sales-boxes .table tbody tr {
	border-bottom: 1px solid #ddd;
}

.sales-boxes .table tbody tr:hover {
	background-color: #f1f1f1;
}

/* Table cell padding */
.sales-boxes .table tbody td {
	padding: 12px 15px;
}

/* Link in table cell */
.sales-boxes .table tbody td a {
	text-decoration: none;
	color: #007bff;
	font-weight: 500;
}

.sales-boxes .table tbody td a:hover {
	color: #0056b3;
	text-decoration: underline;
}

/* Button styling */
.sales-boxes .table .btn-info {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 6px 12px;
	border-radius: 4px;
	transition: background-color 0.3s ease;
}

.sales-boxes .table .btn-info:hover {
	background-color: #0056b3;
}

.sales-boxes .table .btn-danger {
	background-color: #dc3545;
	color: white;
	border: none;
	padding: 6px 12px;
	border-radius: 4px;
	transition: background-color 0.3s ease;
}

.sales-boxes .table .btn-danger:hover {
	background-color: #c82333;
}

/* Modal styling (optional for consistency) */
.modal-content {
	border-radius: 8px;
	border: 1px solid #dee2e6;
}

.modal-header {
	background-color: #f8f9fa;
	border-bottom: 1px solid #dee2e6;
	padding: 10px 15px;
}

.modal-footer .btn-danger {
	background-color: #dc3545;
	border: none;
}

.modal-footer .btn-secondary {
	background-color: #6c757d;
	border: none;
}
	flex-basis: 20%;
	background-color: #293241;
}

.tab-content {
	flex-basis: 80%;
	padding-top: 15px;
}

/* Mobile View Adjustments */
@media ( max-width : 768px) {
	/* Add scroll behavior for tables */
	.sales-boxes .table-responsive {
		overflow-x: auto;
	}
	.sales-boxes .table {
		font-size: 14px;
	}

	/* Reduce padding for mobile view */
	.sales-boxes .table thead th, .sales-boxes .table tbody td {
		padding: 10px 8px;
	}

	/* Buttons smaller on mobile */
	.sales-boxes .table .btn-info, .sales-boxes .table .btn-danger {
		padding: 4px 8px;
	}
}
</style>
</head>
<body>
	<div class="sidebar">
		<div class="logo-details">
			<i class='bx bxs-car-garage'></i> <span class="logo_name">GoGarage
				AutoMobs</span>
		</div>
		<ul class="nav-links">
			<li><a href="#"> <i class="bx bx-grid-alt"></i> <span
					class="links_name">Dashboard</span>
			</a></li>

			<li><a href="adminside"> <i class='bx bxs-group'></i> <span
					class="links_name">Customers Section</span>
			</a></li>

			<li><a href="carpage"> <i class='bx bxs-car-mechanic'></i> <span
					class="links_name">Cars Section</span>
			</a></li>




			<li><a href="servicedetailspage"> <i class='bx bxs-cart-add'></i><span
					class="links_name">Services</span>
			</a></li>

			<li><a href="#"> <i class="bx bx-pie-chart-alt-2"></i> <span
					class="links_name">Spare Parts</span>
			</a></li>
			<li><a href="#" class="active"> <i class="bx bx-coin-stack"></i>
					<span class="links_name">Billings</span>
			</a></li>
			<li><a href="#"> <i class="bx bx-book-alt"></i> <span
					class="links_name">Total order</span>
			</a></li>

			<li><a href="#"> <i class="bx bx-message"></i> <span
					class="links_name">Messages</span>
			</a></li>
			<li><a href="#"> <i class="bx bx-heart"></i> <span
					class="links_name">Favrorites</span>
			</a></li>
			<li><a href="#"> <i class='bx bxs-spreadsheet'></i> <span
					class="links_name">Reports</span>
			</a></li>
			<li class="log_out"><a href="logoutbtn"> <i
					class="bx bx-log-out"></i> <span class="links_name">Log out</span>
			</a></li>
		</ul>
	</div>
	<section class="home-section">
		<nav>
			<div class="sidebar-button">
				<i class="bx bx-menu sidebarBtn"></i> <span class="dashboard">Car
					Dashboard</span>
			</div>
			<!-- <div class="search-box">
          <input type="text" placeholder="Search..." />
          <i class="bx bx-search"></i>
        </div> -->
			<div class="profile-details">
				<img src="" alt="" /> <span class="admin_name">Kartik&Vikram</span>
				<!-- <i class="bx bx-chevron-down"></i> -->
			</div>
		</nav>
		<div class="home-content">
			<div class="overview-boxes">
				<div class="box">
					<div class="right-side">
						<div class="box-topic">Search Panel</div>

					</div>
				</div>
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
								data-bs-toggle="modal" data-bs-target="#techModal">Add
								Technician Details</button>

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
</section>
<script>		
<a href="cardetails" style="margin: 0 auto; text-decoration: none;"><button
				class="nav-link m-2" id="v-pills-profile-tab" data-bs-toggle="pill"
				data-bs-target="#v-pills-profile" type="button" role="tab"
				aria-controls="v-pills-profile" aria-selected="false">Car
				Section</button></a> <!-- Optional JavaScript; choose one of the two! -->
			<script
				src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
				integrity="sha384-ZcbIMZojZhxot2cA+CnN2z5F3aVG9S6dQLHOB+DQTF+f9v7HWxIO4n8CdyGr68/Ei"
				crossorigin="anonymous"> 
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
				integrity="sha384-cVKIPhGhrtS3bZg3Skvjy1TdxCx2gY/5cnlg78LVXL2/5gplF8KcQ17W9R+zxD8pP"
				crossorigin="anonymous"></script></body>
</html>