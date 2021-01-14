<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="logic.engineeringclasses.others.SizedStack" %>

<%
	if(request.getParameter("home5")!=null) {
		SizedStack.getSizedStack(true).clearStack();
		%>
		<jsp:forward page="HomePageOwner.jsp"></jsp:forward>
		<%
	}
%>


<%
	if(request.getParameter("sponsorRestaurant5")!=null) {
		SizedStack.getSizedStack(true).push("CreatingRestaurantView.jsp");
		%>
		<jsp:forward page="CreatingRestaurantView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("continue5")!=null) {
		SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		%>
		<jsp:forward page="ConfirmMessage.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("back5")!=null) {		
		%>
		<jsp:forward page="RestaurantMenuview.jsp"></jsp:forward>
		<%		
	}
%>    
   

<%
	if(request.getParameter("delete")!=null) {
		//SizedStack.getSizedStack(true).push("RestaurantMenuview.jsp");
		%>
		<jsp:forward page="DeleteDishView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("add")!=null) {
		//SizedStack.getSizedStack(true).push("Resta.jsp");
		%>
		<jsp:forward page="AddDishView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("modify")!=null) {
		//SizedStack.getSizedStack(true).push("ConfirmMessage.jsp");
		%>
		<jsp:forward page="ModifyDishView.jsp"></jsp:forward>
		<%
	}
%>

<%
	if(request.getParameter("advice")!=null) {		
		%>
		<jsp:forward page="AdviceView.jsp"></jsp:forward>
		<%		
	}
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styleRestaurantMenuView.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<form action="RestaurantMenuview.jsp" method="get">
		
			<input id="home" type="submit" name="home5" value="Home">
			<input id="manageMenu" type="submit" name="manageMenu5" value="Manage Menu">
			<input id="sponsorRestaurant" type="submit" name="sponsorRestaurant5" value="Sponsor Restaurant">
			<input id="back" type="submit" name="back5" value="Back">
			
			
			<img id="fotoUtente" alt="image" src="utente.jpg"/>
			
			<label id="n">NomeUtente</label>
			
			
			
			<div id="informazioni">
				<p>Select the type of change:</p>
			</div>
			
			<div id="sceltaMultipla">
				<div><input id="delete" type="submit" name="delete" value="Delete a Dish"></div>
				<div><input id="add"  type="submit" name="add" value="Add a Dish"></div>
				<div><input id="modify" name="modify" type="submit" value="Modify a Dish"></div>
				<div><input id="advice" name="advice" value="Get Advice" type="submit"></div>
			</div>
			
			
			
			
			
		</form>
	</div>
	

</body>
</html>