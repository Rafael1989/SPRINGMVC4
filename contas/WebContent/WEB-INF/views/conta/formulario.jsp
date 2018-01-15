<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contas</title>
</head>
<body>
	<h3>Adicionar conta</h3>
	
	<form action="adicionaConta" method="post">
		Descrição: <br/>
		<textarea name="descricao" rows="5" cols="100"></textarea><br/>
		<form:errors path="conta.descricao"/><br/>
		Paga?<br/>
		<input type="checkbox" name="paga" /><br/>
		Valor: <br/>
		<input type="text" name="valor"/><br/>
		Data do Pagamento: <br/>
		<input type="text" name="dataPagamento"/><br/>
		Tipo: <br/>
		<select name="tipo">
			<option value="ENTRADA">ENTRADA</option>
			<option value="SAIDA">SAIDA</option>
		</select><br/>
		<input type="submit" value="Adicionar"/>
	</form>
</body>
</html>