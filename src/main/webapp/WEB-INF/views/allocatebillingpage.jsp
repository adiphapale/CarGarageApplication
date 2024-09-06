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



 <title>GoGarage Automobs Invoice</title>
    <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    

<style type="text/css">


        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .invoice-container {
            background-color: #fff;
            max-width: 800px;
            margin: 0 auto;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: relative;
            z-index: 1;
        }

        .logo-section {
            text-align: center;
            margin-bottom: 40px;
        }

        .logo {
            max-width: 150px;
            height: auto;
            display: block;
            margin: 0 auto;
        }

        .logo-section h1 {
            margin-top: 10px;
            font-size: 28px;
        }

        .invoice-container::before {
            content: 'GoGarage Automobs';
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%) rotate(-45deg); /* Diagonal rotation */
            font-size: 80px;
            color: rgba(0, 0, 0, 0.05); /* Light text for subtle background */
            z-index: 0;
            white-space: nowrap;
        }

        h1 {
            text-align: center;
            font-size: 24px;
            margin-bottom: 30px;
            z-index: 1;
        }

        .row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 30px;
        }

        .column {
            flex: 48%;
            z-index: 1;
        }

        .contact-info, .bill-info, .customer-info, .vehicle-info, .totals {
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
            z-index: 1;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 15px;
            text-align: left;
        }

        thead {
            background-color: #f4f4f4;
        }

        .totals {
            text-align: right;
        }

        .totals strong {
            font-size: 18px;
        }

        .print-btn {
            text-align: center;
            margin-top: 40px;
        }

        .print-btn button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        .print-btn button:hover {
            background-color: #45a049;
        }
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
<script>
	// Function to select or deselect all subservices based on main service checkbox
	function toggleSubServices(mainServiceCheckbox, subServiceClass) {
		var checkboxes = document.getElementsByClassName(subServiceClass);
		for (var i = 0; i < checkboxes.length; i++) {
			checkboxes[i].checked = mainServiceCheckbox.checked;
		}
	}
</script>
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
						<form class="d-flex ms-auto" action="logoutbtn">
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
						class="nav-link m-2" id="v-pills-settings-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-settings"
						type="button" role="tab" aria-controls="v-pills-settings"
						aria-selected="false">Servicing Section</button></a> <a
					href="sparePartspage"
					style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link m-2" id="v-pills-settings-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-settings"
						type="button" role="tab" aria-controls="v-pills-settings"
						aria-selected="false">Spare Parts Section</button></a> <a
					href="techiepage" style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link m-2" id="v-pills-settings-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-settings"
						type="button" role="tab" aria-controls="v-pills-settings"
						aria-selected="false">Technician Section</button></a> <a
					href="billingPage" style="margin: 0 auto; text-decoration: none;"><button
						class="nav-link active m-2" id="v-pills-settings-tab"
						data-bs-toggle="pill" data-bs-target="#v-pills-settings"
						type="button" role="tab" aria-controls="v-pills-settings"
						aria-selected="false">Billing Section</button></a>
			</div>

			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="v-pills-profile"
					role="tabpanel" aria-labelledby=v-pills-profile-tab>

					<h2 class="text-center mb-4">Total Bill</h2>
					<div class="invoice-container">
						<div class="logo-section">

							<h1>
								<i class="fa-solid fa-car-on"></i>GoGarage Automobs
							</h1>
						</div>

						<div class="row">
							<div class="column">
								<div class="contact-info">
									<p>
										<strong>Contact:</strong> 8208309995
									</p>
									<p>
										<strong>Address:</strong> Near Warje Bridge Pune 411058 
									</p>
								</div>
							</div>
							<div class="column">
								<div class="bill-info">
									<p>
										<strong>Bill No:</strong> 00123
									</p>
									<p>
										<strong>Date:</strong> 01/09/2024
									</p>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="column">
								<div class="customer-info">
									<p>
										<strong>Customer Name:</strong> John Doe
									</p>
									<p>
										<strong>Customer Contact:</strong> 9876543210
									</p>
								</div>
							</div>
							<div class="column">
								<div class="vehicle-info">
									<p>
										<strong>Vehicle No:</strong> XYZ 1234
									</p>
									<p>
										<strong>Vehicle Model:</strong> Honda City
									</p>
									<p>
										<strong>Vehicle Technician:</strong> Mark
									</p>
								</div>
							</div>
						</div>

						<table>
							<thead>
								<tr>
									<th>Sr.No</th>
									<th>Services</th>
									<th>Price</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Oil Change</td>
									<td>$50</td>
									<td>$50</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Brake Replacement</td>
									<td>$200</td>
									<td>$200</td>
								</tr>
							</tbody>
						</table>

						<table>
							<thead>
								<tr>
									<th>Sr.No</th>
									<th>Spare Parts</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Brake Pads</td>
									<td>$100</td>
									<td>2</td>
									<td>$200</td>
								</tr>
							</tbody>
						</table>

						<div class="totals">
							<p>
								<strong>Subtotal (Services):</strong> $250
							</p>
							<p>
								<strong>Subtotal (Spare Parts):</strong> $200
							</p>
							<p>
								<strong>GST (9%):</strong> $40.5
							</p>
							<p>
								<strong>CGST (9%):</strong> $40.5
							</p>
							<p>
								<strong>Final Bill:</strong> $531
							</p>
						</div>

						<div class="print-btn">
							<button onclick="window.print()">Print Bill</button>
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
