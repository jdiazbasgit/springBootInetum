<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>LOGIN</h1>

	<!-- <form action="verLogin" method="POST">
	usuario:<input type="text" name="usuario"><br>
	clave:<input type="password" name="clave"><br>
	<button type="submit">ENVIAR</button>
	</form> -->

	<spring:form method="POST" modelAttribute="login" action="verLoginObjeto">
		usuarioObjeto: <spring:input path="usuario" />
			<br>
		claveLogin: <spring:password path="clave" />
			<br>
		<spring:button>ENVIAR</spring:button>

	</spring:form>

	<h1 style="color: #00ff00">${OK}</h1>
	<h1 style="color: #ff0000">${KO}</h1>


</body>
</html>
