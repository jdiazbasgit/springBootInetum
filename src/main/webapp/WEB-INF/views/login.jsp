<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>SPRING SECURITY</h1>
	<form action="autenticar" method="post">
		usuario:<input type="text" name="usuario"><br> clave:<input
			name="clave" type="password"><br>
		<button>ENVIAR</button>
		</form>
		<h1>${param.error}</h1>
</body>
</html>