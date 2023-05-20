<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Music | Artists</title>
</head>
<body>

	<h1>All artists</h1>
	
	<form method="post">
		<label for="name">Add new artist to list: </label><br>
	    <input id="formName" name="name" type="text" required placeholder="type artist here..." autofocus />
	    <input type="submit" value="Add to list" />
	</form>
		
	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li>
				<c:out value="${ artist.getName() }"></c:out>
			</li>
		</c:forEach>
	</ol>


</body>
</html>