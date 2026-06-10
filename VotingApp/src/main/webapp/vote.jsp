<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    HttpSession sess = request.getSession(false);

    if(sess == null || sess.getAttribute("voterId") == null){
        response.sendRedirect("login.jsp");
        return;
    }

    String name = (String)sess.getAttribute("name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote Here</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color:#f2f2f2;
    margin:40px;
}

.container{
    width:500px;
    margin:auto;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

h2{
    text-align:center;
}

input[type=submit]{
    background:green;
    color:white;
    padding:10px 20px;
    border:none;
    cursor:pointer;
}

.links{
    margin-top:20px;
}

</style>

</head>

<body>

<div class="container">

<h2>Online Voting System</h2>

<h3>Welcome, <%= name %></h3>

<form action="vote" method="post">

<h4>Select Your Candidate</h4>

<input type="radio"
       name="candidate"
       value="1"
       required>
Candidate A
<br><br>

<input type="radio"
       name="candidate"
       value="2">
Candidate B
<br><br>

<input type="radio"
       name="candidate"
       value="3">
Candidate C
<br><br>

<input type="submit"
       value="Cast Vote">

</form>

<div class="links">

<a href="results">
View Results
</a>

<br><br>

<a href="index.jsp">
Logout
</a>

</div>

</div>

</body>
</html>