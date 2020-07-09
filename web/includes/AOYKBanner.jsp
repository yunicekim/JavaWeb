<%-- 
    Document   : AOYKBanner
    Created on : 31-Jan-2020, 10:46:24 AM
    Author     : Abdel & Yunice
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html>
    <head>
        <meta charset="utf-8">
        <title>AOYK Computer Programming Club</title>
        <link rel="shortcut icon" href="<c:url value='/images/favicon.ico'/>">
        <link rel="stylesheet" href="<c:url value='/styles/myMain.css'/> ">
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    </head>
    <body>
        <header>
            <img src="<c:url value='/images/AOYK-icon.png'/>" alt="Abdel & Yunice image " width="58">
            <h1>AOYK Computer Programming Club </h1>
            <h2> IT@Conestoga </h2>
        </header>        
        <nav id="nav_bar">
            <ul>
                <li><a href="<c:url value='/AOYKIndex.jsp'/>">Home</a></li>
                <li><a href="<c:url value='/AOYKRegister.jsp'/>">Register</a></li>
                <li><a href="<c:url value='/AOYKLoan'/>">eLoan</a></li>
                <li><a href="<c:url value='/AOYKCart'/>">eCart</a></li>
                <li><a href="<c:url value='/AOYKAdmin.jsp'/>">Admin</a></li>
            </ul>
        </nav>
        
    

