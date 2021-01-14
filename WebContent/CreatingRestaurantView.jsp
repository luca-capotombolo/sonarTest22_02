<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="logic.engineeringclasses.others.SizedStack" %>

<%    	
    	if(request.getParameter("Home SR2")!=null) {
    		//SizedStack.getSizedStack(true).push("HomePageTouristView.jsp");
    		SizedStack.getSizedStack(true).clearStack();
%>
			<jsp:forward page="HomePageOwner.jsp"/>
<%
    	}
    	if(request.getParameter("Sponsor Restaurant SR2")!=null) {
    		SizedStack.getSizedStack(true).push("ItalianCitySponsorView.jsp");
%>
			<jsp:forward page="ItalianCitySponsorView.jsp"/>
<%
    	}
    	if(request.getParameter("Manage Menu SR2")!=null) {
    		SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
%>
			<jsp:forward page="RestaurantMenuview.jsp"/>
<%
    	}
    	if(request.getParameter("Back SR2")!=null) {
    		String pag = SizedStack.getSizedStack(true).read();
    		//SizedStack.getSizedStack(true).push(pag);
    		if(pag=="RestaurantMenuview.jsp") {
%>
				<jsp:forward page="RestaurantMenuview.jsp"/>
<%
    		}
			else if(pag=="ItalianCitySponsorView.jsp") {
%>
				<jsp:forward page="ItalianCitySponsorView.jsp"/>
<%
			}
			else {
%>
				<jsp:forward page="HomePageOwner.jsp"/>
<%
			}
    	}
    	if(request.getParameter("Add Dish")!=null) {
    		//SizedStack.getSizedStack(true).push("SchedulingView.jsp");
%>
<!--			<jsp:forward page="SchedulingView.jsp"/>	-->
<%
    	}
    	if(request.getParameter("Done")!=null) {
    		//SizedStack.getSizedStack(true).push("SchedulingView.jsp");
%>
<!--			<jsp:forward page="SchedulingView.jsp"/>	-->
<%
    	}
%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Restaurant creation</title>
	<link rel="stylesheet" type="text/css" href="CreatingRestaurantCSS.css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
	<form action="CreatingRestaurantView" name="myform" method="get">
		<input id="home" type="submit" name="Home SR2" value="Home">
		<input id="sponsorRestaurant" type="submit" name="Sponsor Restaurant SR2" value="Sponsor Restaurant">
		<input id="manageMenu" type="submit" name="Manage Menu SR2" value="Manage Menu">
		<input id="back" type="submit" name="Back SR2" value="Back">
		<img id="fotoUtente" src="utente.jpg"/>
		<label id="nomeUtente">nomeUtente</label>
		<div class="box-1">
			<p>Please, insert name and address of your restaurant:</p>
		</div>
		<div class="box-2">
			<p>Click here to add a dish into your menu:</p>
		</div>
		<input id="restName" class="textbox" type="text" placeholder="Restaurant name">
		<input id="restAddress" class="textbox" type="text" placeholder="Restaurant address">
		<input id="addDish" class="buttonbelow" type="submit" name="Add Dish" value="Add Dish">
		<input id="done" class="buttonbelow" type="submit" name="Done" value="Done">
	</form>
</div>
</body>
</html>