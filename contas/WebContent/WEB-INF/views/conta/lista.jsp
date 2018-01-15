<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conta</title>
</head>
<body>
	<h3>Lista de contas</h3>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Paga?</th>
				<th>Valor</th>
				<th>Data do pagamento</th>
				<th>Tipo</th>
				<th colspan="2">Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contas}" var="conta">
				<tr>
					<td>${conta.id}</td>
					<td>${conta.descricao}</td>
					<c:if test="${conta.paga eq 'true'}">
						<td>Paga</td>
					</c:if>
					<c:if test="${conta.paga eq 'false'}">
						<td>Pendente</td>
					</c:if>
					<td>${conta.valor}</td>
					<td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy"/></td>
					<td>${conta.tipo}</td>
					<td><a href="removeConta?id=${conta.id}">Remover</a></td>
					<td><a href="mostraConta?id=${conta.id}">Alterar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>${mensagem}</p>
</body>
</html>