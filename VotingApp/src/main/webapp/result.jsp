<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voting Results</title>

<style>

body{
    font-family: Arial, sans-serif;
    background-color:#f2f2f2;
}

.container{
    width:600px;
    margin:50px auto;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}

h2{
    text-align:center;
}

table{
    width:100%;
    border-collapse:collapse;
}

th,td{
    border:1px solid black;
    padding:10px;
    text-align:center;
}

th{
    background-color:#dddddd;
}

.links{
    margin-top:20px;
    text-align:center;
}

</style>

</head>

<body>

<div class="container">

<h2>Voting Results</h2>

<table>

<tr>
    <th>Candidate</th>
    <th>Total Votes</th>
</tr>

<%
List<String> results =
(List<String>)request.getAttribute("results");

if(results != null){

    for(String result : results){

        String data[] = result.split(" - ");

        String candidate = data[0];
        String votes = data[1].replace(" Votes","");

%>

<tr>
    <td><%= candidate %></td>
    <td><%= votes %></td>
</tr>

<%
    }
}
else{
%>

<tr>
    <td colspan="2">
        No Results Found
    </td>
</tr>

<%
}
%>

</table>

<div class="links">

<br>

<a href="vote.jsp">
Back To Voting Page
</a>

&nbsp;&nbsp;&nbsp;

<a href="logout">
Logout
</a>

</div>

</div>

</body>
</html>