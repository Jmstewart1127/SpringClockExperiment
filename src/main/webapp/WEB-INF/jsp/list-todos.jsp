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
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate value="${todo.targetDate}"/></td>
					<td>${todo.done}</td>
					<td><a type="button" class="btn btn-primary" href="/update-todo?id=${todo.id}">Update</a></td>
					<td><a type="button" class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
</table>
<br>
<div> <a class="button" href="/todo">Add a Todo</a></div>
</div>
<%@include file="common/footer.jspf" %>