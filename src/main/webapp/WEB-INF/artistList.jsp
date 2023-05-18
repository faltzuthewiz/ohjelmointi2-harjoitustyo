<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Music | Artists</title>
</head>
<body>

	<h1>All artists</h1>
	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li>
				<c:out value="${ artist.getName() }"></c:out>
			</li>
		</c:forEach>
	</ol>


</body>
</html>