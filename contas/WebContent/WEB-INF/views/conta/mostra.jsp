<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contas</title>
</head>
<body>
	<h3>Atualizar conta</h3>
	
	<form action="alteraConta" method="post">
		<input type="hidden" name="id" value="${conta.id}"/>
		Descrição: <br/>
		<textarea name="descricao" rows="5" cols="100">${conta.descricao}</textarea><br/>
		Paga?<br/>
		<input type="checkbox"  name="paga" ${conta.paga?'checked':''}/><br/>
		Valor: <br/>
		<input type="text" name="valor" value="${conta.valor}"/><br/>
		Data do Pagamento: <br/>
		<input type="text" name="dataPagamento" value="<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/>"/><br/>
		Tipo: <br/>
		<select name="tipo">
			<option value="ENTRADA" ${conta.tipo eq 'ENTRADA'?'selected' :'' }>ENTRADA</option>
			<option value="SAIDA" ${conta.tipo eq 'SAIDA'?'selected' :'' }>SAIDA</option>
		</select><br/>
		<input type="submit" value="Alterar"/>
	</form>
</body>
</html>