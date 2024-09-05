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

                    <form action="submitServices?vvid=${visitID}" method="post">
                    
                        <c:forEach var="ServiceEntry" items="${servicesMap}">
                            <!-- Main Service Checkbox -->
                            <input type="checkbox" id="mainService-${ServiceEntry.key.msid}" 
                                   onclick="toggleSubServices(this, 'subService-${ServiceEntry.key.msid}')" />
                            <label for="mainService-${ServiceEntry.key.msid}"><h5>${ServiceEntry.key.msname}</h5></label>
                            <br />
                            
                            <!-- Display SubServices -->
                            <c:forEach var="subService" items="${ServiceEntry.value}">
                                <input type="checkbox" class="subService-${ServiceEntry.key.msid}" name="selectedSubServices"
                                    value="${subService.ssid}" />
                                ${subService.ssname} - ${subService.ssprice}<br />
                            </c:forEach>
                            <br />
                        </c:forEach>
                        <button type="submit" class="btn btn-success" >Submit</button>
                    </form>
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