<%@page import="com.pms_clone.model.TicketsDao"%>
<%@page import="com.pms_clone.model.Tickets"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Magament System</title>

<!-- dataTable min  -->
<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet" />
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<!-- dataTable min  -->

<script type="text/javascript">
	$(document).ready(function() {
	$('#example').DataTable();
	});
</script>

</head>
<body bgcolor="#EAEDED"
	style="font-family: Verdana, Arial, Helvetica, sans-serif">

	<div style="float: center; background-color: #628DB6; padding: 2px">
		<center>
			<h2 style="color: white;">
				<u>PMS Dashboard</u>
			</h2>
		</center>
	</div>
		<div>
		<%
			List<Tickets> ticketList = null;
			ticketList = TicketsDao.getAllTickets();
			for (Tickets ticket : ticketList) {
				System.out.println("project id = " + ticket.getId());

			}
			request.setAttribute("ticket_List", ticketList);
		%>
		<table id="example" class="display" cellspacing="0" width="100%"
				border="1">
				<thead bgcolor="#C0C0C0">

					<tr>
						<th>#</th>
						<th>Tracker</th>
						<th>Status</th>
						<th>Priority</th>
						<th>Subject</th>
						<th>Start Date</th>
						<th>Due Date</th>
						<th>Target Version</th>
						<th>Owner</th>
						<th>Estimated Time</th>
						<th>Spent Time</th>
						<th>Resolution</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ticket" items="${ticket_List}">
						<tr>
							<td>${ticket.id}</td>
							<td>${ticket.tracker}</td>
							<td>${ticket.status}</td>
							<td>${ticket.priority}</td>
							<td>${ticket.subject}</td>
							<td>${ticket.startDate}</td>
							<td>${ticket.duedate}</td>
							<td>${ticket.targetVersion}</td>
							<td>${ticket.owner}</td>
							<td>${ticket.estimatedTime}</td>
							<td>${ticket.spentTime}</td>
							<td>${ticket.resolution}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>
