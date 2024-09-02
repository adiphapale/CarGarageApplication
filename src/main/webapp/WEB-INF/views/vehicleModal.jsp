<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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

<title>vehiclepannel</title>

</head>
<body>
	<div class="modal fade" id="vehicleModal" tabindex="-1"
		aria-labelledby="vehicleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="vehicleModalLabel">Add Vehicle
						Details</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="vehicleForm" action="addVehicleDetails" method="POST">
						<!-- Hidden field to hold the customer ID -->
						<input type="hidden" id="customerId" name="customerId" value="">


						<div class="mb-3">
							<label for="inputVehicleModel5" class="form-label">Vehicle
								Model</label> <input type="text" class="form-control"
								id="inputVehicleModel5" name="vehiclemodel"
								placeholder="Enter Model here"
								value="${userVehicleModel.vehiclemodel}">
						</div>
						<!-- Other form fields for vehicle details -->
						<div class="mb-3">
							<label for="inputVehicleNPlate" class="form-label">Vehicle
								Number Plate</label> <input type="text" class="form-control"
								id="inputVehicleNPlate" name="vehiclenplate"
								placeholder="Enter Number here">
							<div id="vehicleNPlateError" style="color: red; display: none;">Invalid
								Vehicle Number Plate</div>
						</div>

						<div class="mb-3">
							<label for="inputVehicleKM7" class="form-label">Vehicle
								Running In KM</label> <input type="number" class="form-control"
								id="inputVehicleKM7" name="vehiclerun"
								placeholder="Enter Running here"
								value="${userVehicleModel.vehiclerun}">
						</div>

						<div class="mb-3">
							<label for="inputVehicleDate8" class="form-label">Vehicle
								Entry Date</label> <input type="date" class="form-control"
								id="inputVehicleDate8" name="vehicledate"
								value="${userVehicleModel.vehicledate}">
						</div>

						<div class="mb-3">
							<label for="selectTechnician" class="form-label">Select
								Technician</label> <select class="form-control" id="selectTechnician9"
								name="technicianId">
								<option value="" disabled selected>Select a technician</option>
								<c:forEach var="technician" items="${techies}">
									<option value="${technician.tid}">${technician.tname}</option>
								</c:forEach>
							</select>
						</div>
						<!-- Add more fields as needed -->

						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">Save
								changes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {
							const vehicleNPlateInput = document
									.getElementById('inputVehicleNPlate');
							const vehicleNPlateError = document
									.getElementById('vehicleNPlateError');

							vehicleNPlateInput
									.addEventListener(
											'input',
											function() {
												const vehicleNPlate = vehicleNPlateInput.value
														.trim();
												const vehicleNPlatePattern = /^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$/;

												if (!vehicleNPlatePattern
														.test(vehicleNPlate)) {
													vehicleNPlateError.style.display = 'block';
												} else {
													vehicleNPlateError.style.display = 'none';
												}
											});
						});
	</script>


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
</html> --%>