<%-- 
    Document   : viewnote
    Created on : 15-Sep-2022, 11:35:08 PM
    Author     : Drew-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%--<%@include file="editnote.jsp"%>--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <br>
        <h2>View Note</h2>
        <br>
        <h3>Title: ${Note.title}<h3>
        <br>
        <h3>Contents: ${Note.contents}</h3>
        <br>  
        <a href="note?edit">Edit</a>
        <div>${edit}</div>
    </body>
</html>
