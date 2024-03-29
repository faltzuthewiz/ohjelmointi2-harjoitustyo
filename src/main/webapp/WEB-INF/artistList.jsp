<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Music | Artists</title>
	
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/yegor256/tacit@gh-pages/tacit-css.min.css"/>
	 <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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
				<a href="<c:out value = "/albums?ArtistId=${ artist.getId() }" />" >
				<c:out value="${ artist.getName() }"></c:out>
				</a>
			</li>
		</c:forEach>
	</ol>


</body>
</html>