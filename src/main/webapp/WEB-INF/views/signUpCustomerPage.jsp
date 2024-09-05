<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up for GoGarage AutoMobs</title>
     <!-- fot website fevicon image -->
     <link
     rel="icon"
     type="image/x-icon"
     href="/Movie_Recommendation/URLToReachResourceFolder/images/website-feviicon.png"
   />
  
<style type="text/css">
 body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
      /*   border: 1px solid #000; */
      }
      .register_form_user{
     /*    border: 1px solid red; */
        height: 500pX;
        width:36%;
        margin-left: 32%;
        margin-top: 5%;
        border-radius: 6px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
      }
      h1{
         padding-top: 3%;
text-align: center;
color: #007bff;

      }
      h3{
text-align: center;
font-size: 14px;
font-weight: 700;
margin-top: 3%;
      }
      h4{
margin-top: -40px;
font-size: 14px;
font-weight: 600;
margin-left: 60%;
margin-bottom: 5vh;
      }

      input[type="text"],
      input[type="password"],
      select,
      textarea {
        width: 90%;
        height: 40px;
        padding: 10px;
        margin-top: 1px;
     margin-left: 5%;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 16px;
      } 


      input[type="submit"]
      {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
        margin-left: 8%;
      }
      input[type="reset"]
      {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
        margin-left: 1%;
      }
      input[type="checkbox"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 8px;
      margin-left: 5%;
      }
      .error-message {
        color: red;
        font-size: 14px;
        margin-top: 13px;
     margin-left: 10%;
      }
      .more-info-section-2{
    width: 100%;
  margin-top: 5%;
    /* border: 1px solid white; */
  }
  .more-info-section-2 h3{
    font-size:12px;
    /* margin-top: 20px; */
    font-family: "Poppins", sans-serif;
    font-weight: 100;
    text-align: center;
    color: black;
  }



  @media (max-width: 1024px) {
    .register_form_user{
        border: 1px solid #007bff;
        height: 500pX;
        width:60%;
        margin-left: 20%;
        margin-top: 8%;
        border-radius: 6px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
      }
  }

  @media (max-width: 480px) {
    .register_form_user{
        border: 1px solid #007bff;
        height: 450pX;
        width:90%;
        margin-left: 5%;
        margin-top:30%;
        border-radius: 6px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
      }
      h1{
text-align: center;
color: #007bff;
font-size: 20px;
      }
      h3{
text-align: center;
font-size: 10px;
font-weight: 700;
margin-top: 3%;
      }
      h4{
margin-top: 10px;
font-size: 10px;
font-weight: 600;
margin-left: 60%;
margin-bottom: 5vh;
      }

      input[type="text"],
      input[type="password"],
      select,
      textarea {
        width: 90%;
        height: 30px;
        padding: 10px;
        margin-top: 1px;
     margin-left: 5%;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 16px;
      } 


      input[type="submit"]
      {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 11px;
        /* margin-left: 8%; */
        height: 12%;
        width: 38%;
      }
      input[type="reset"]
      {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 11px;
        /* margin-left: 8%; */
        height: 12%;
        width: 38%;
      }
      input[type="checkbox"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 8px;
      /* margin-left: 7%; */
    
      }
      .error-message {
        color: red;
        font-size: 11px;
        margin-top: 13px;
     margin-left: 10%;
      }
      .more-info-section-2{
    width: 100%;
  margin-top: 16%;
    /* border: 1px solid white; */
  }
  .more-info-section-2 h3{
    font-size:11px;
    /* margin-top: 20px; */
    font-family: "Poppins", sans-serif;
    font-weight: 400;
    text-align: center;
    color: black;
  }

  }

</style>

</head>
<body>
<div class="register_form_user">
  
  
     <h1>GoGarage AutoMobs</h1>
   <h3>Create a New Account</h3>

    <form:form name="RegForm" onsubmit="return validateForm()" action="saveuser" method="Post" modelAttribute="reguser" >
      <p>
        <input
          type="text"
          id="name"
          name="user_name"
          placeholder="Enter your name:"
        />
        <span id="name-error" class="error-message"></span>
      </p>
      <p>
        <input
          type="password"
          placeholder="Enter your Contact Number:"
          id="password"
          name="user_password"
        />
        <span id="password-error" class="error-message"></span>
      </p>
      <p>
        <input
          type="text"
          id="Email"
          name="user_email" 
          placeholder="Enter your email:" maxlength="60"
        />
        <span id="emailValidationMessage" class="error-message"></span>
      </p>

      <p>
        <input
          type="text"
          id="contactnumber"
          name="user_contact"
          placeholder="Enter your Address:"
         required/>
        <span id="validationcontactMessage" class="error-message"></span>
      </p>
     
      <p>
        <input type="checkbox" id="agree" name="Agree" />
        <label for="agree">I agree the Terms& Conditions of GoGarage AutoMobs</label>
        <span id="agree-error" class="error-message"></span>
      </p>
      <p>
        <input type="submit" value="Send" name="Submit" />
        <input type="reset" value="Reset" name="Reset" />
      </p>
      <a href="userlogin"><h3>Already have an account?</h3></a>
    </form:form>
    <div class="more-info-section-2">
      <h3>All material<span>&copy; 2024 GoGarage AutoMobs company Pvt.Ltd.All Rights Reserved 2024</span> </h3>
    </div>
    
    </div>
    
     <script>
        function validateForm() {
    const name = document.getElementById("name").value;
    const address = document.getElementById("address").value;
    const email = document.getElementById("Email").value;
    const password = document.getElementById("password").value;
    const agree = document.getElementById("agree").checked;
    const nameError = document.getElementById("name-error");
    // const Contact = document.getElementById("contactnumber").value;


    const addressError = document.getElementById(
        "address-error"
    );
    const emailError = document.getElementById(
        "emailValidationMessage"
    );
    // const contactError = document.getElementById(
    //     "contact-error"
    // );
    const passwordError = document.getElementById(
        "password-error"
    );
    const agreeError = document.getElementById(
        "agree-error"
    );

    nameError.textContent = "";
    addressError.textContent = "";
    emailError.textContent = "";
    passwordError.textContent = "";
    agreeError.textContent = "";
    // contactError.textContent="";

    let isValid = true;
  

    if (name === "" || /\d/.test(name)) {
        nameError.textContent =
            "Please enter your Username properly.";
        isValid = false;
    }

    if (name.length<6 || name.length>50) {
        nameError.textContent =
           "Please enter a Username with at least 6 characters.";
        isValid = false;
    }

    if (address === "" || address.length>50) {
        addressError.textContent =
            "City name is too lengthy.";
        isValid = false;
    }

    if (email === "") {
        emailError.textContent =
            "Please enter a valid email address.";
        isValid = false;
    }

    if (password === "" || password.length < 6 || password.length > 50) {
        passwordError.textContent =
            "Please enter a password with at least 6 characters.";
        isValid = false;
    }
  

    if (!agree) {
        agreeError.textContent =
            "Please agree to the above information.";
        isValid = false;
    }

    return isValid;
}
   
document
        .getElementById("contactnumber")
        .addEventListener("input", function () {
          const contact = this.value;
          const validationMessage =
            document.getElementById("validationcontactMessage");

          if (contact.length > 10) {
            validationMessage.textContent = "Invalid Contact Number";
          } 
          if (contact.length < 10) {
            validationMessage.textContent = "Contact Number less than (10 digits)";
          }
          
          else if (!/^[1-9]\d{0,9}$/.test(contact)) {
            validationMessage.textContent = "Invalid Contact Number";
          } else {
            validationMessage.textContent = "";
          }
        });

      document
        .getElementById("Email")
        .addEventListener("input", function () {
          const email = this.value;
          const validationMessage = document.getElementById(
            "emailValidationMessage"
          );

          // Basic email pattern to check the format
          const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

          if (!emailPattern.test(email)) {
            validationMessage.textContent = "Invalid email address.";
          } else {
            validationMessage.textContent = "";
          }
        });
    
    </script> 

</body>
</html>