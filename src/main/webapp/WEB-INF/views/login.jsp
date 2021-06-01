<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	LOGIN
</h1>

<form action="verLogin" method="POST">
	usuario:<input type="text" name="usuario"><br>
	clave:<input type="password" name="clave"><br>
	<button type="submit">ENVIAR</button>


<h1 style="color: #00ff00">${OK}</h1>
<h1 style="color: #ff0000">${KO}</h1>


</body>
</html>
