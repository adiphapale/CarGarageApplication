<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Log in into GoGarage AutoMobs</title>
     <!-- fot website fevicon image -->
     <link
     rel="icon"
     type="image/x-icon"
     href="/Movie_Recommendation/URLToReachResourceFolder/images/website-feviicon.png"
   />
   


<style type="text/css">
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f2f2f2;
}

.login-container {
    background-color: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    height: 360px;
    max-height: 100%;
    max-width: 460px;
    /* border: 1px solid #000; */
}

h1 {
    margin-top: 10px;
    margin-bottom: 20px;
    text-align: center;
    color: #D51C53;
}
.login-container h3{
    margin-top: 13px;
    text-align: center;
    color: #000;
    margin-bottom: 20px;
    font-size: 16px;
}
.login-container h4{
color: #000;
text-align: right;
margin-top: 8px;
font-size: 14px;
}
.login-container h4:hover{
color: #D51C53;
}

.input-group {
    margin-bottom: 15px;
}

.input-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    margin-top: 6px;
}

button {
    width: 100%;
    padding: 10px;
    height: 44px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 20px;
    background-color: #D51C53;;
}
a h4{
   
    font-size: 16px;
    margin-top: 6px;
 font-weight:10;
 text-decoration: none;
}
a:hover{
text-decoration: underline;
color: #D51C53;

}
.more-info-section-2{
    width: 100%;
  margin-top: 10px;
    /* border: 1px solid black; */
  }
  .more-info-section-2 h3{
    font-size:11px;
    margin-top: 10px;
    font-family: "Poppins", sans-serif;
    font-weight: 400;
    text-align: center;
    color: black;
  }

@media (max-width: 480px) {
    .login-container {
        padding: 15px;
    }

    h1 {
        font-size: 24px;
    }
.login-container h3{
font-size: 14px
}
    button {
        font-size: 14px;
    }
}

</style>
</head>
<body>
    <div class="login-container">
     
        <h1>GoGarage AutoMobs</h1>
        <h3>Log in into GoGarage AutoMobs</h3>
        <form:form name="frm" action="saveloginuser" method="Post" modelAttribute="loginuser">
            <div class="input-group">
               
                <input type="text" 
                id="first" 
                name="user_name" 
                placeholder="Username" maxlength="50" required>

            </div>
            <div class="input-group">
            
                <input type="password"
                         id="password" 
                         name="user_password"
                         placeholder="Password" maxlength="50" required>
            </div>
            <button type="submit"
            onclick="solve()">
          Log in
    </button>
</form:form>
<span style="color:red;">${User_Login_msg}</span>   
    </div>

    <div class="more-info-section-2">
        <h3>All material<span>&copy; 2024 GoGarage AutoMobs company Pvt.Ltd.All Rights Reserved 2024</span> </h3>
      </div>
</body>
</html>