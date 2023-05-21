<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Music | Albums</title>
</head>
<body>
    <h1>Albums by <c:out value="${ artistname.getName() }"></c:out></h1>
    
    <ol>
		<c:forEach items="${ albums }" var="albums">
			<li>
				<c:out value="${ albums.getAlbumTitle() }"></c:out>
			</li>
		</c:forEach>
	</ol>
</body>
</html>