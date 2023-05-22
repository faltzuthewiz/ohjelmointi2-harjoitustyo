<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Music | Albums</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/yegor256/tacit@gh-pages/tacit-css.min.css"/>
	 <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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