<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
		<table class="table table-striped">
	<caption><b>${name}'s Todo's</b></caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clock}" var="clock">
				<tr>
					<td>${clock.getClockIn}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>
<br>
<div> <a class="button" href="/todo">Add a Todo</a></div>
</div>
<%@include file="common/footer.jspf" %>