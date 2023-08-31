<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-7">
			<hr>
			<h3>Atualizar cliente</h3>
			<hr>
			<form action="ClienteUpdate" method="POST">
			<input name="id" value="${cliente.id}">
				<div class="form-floating mb-3">
					<input value="${cliente.nome}" name="nome" type="text" class="form-control" id="floating"> 
					<label>Nome completo</label>
				</div>
				<div class="form-floating mb-3">
					<input value="${cliente.cpf}" name="cpf" type="text" class="form-control">
					<label>CPF (apenas números)</label>
				</div>
				<div class="form-floating mb-3">
					<input name="nascimento" type="date" class="form-control" placeholder="Nascimento">
					<label>Nascimento</label>
				</div>
				<select name="situacao" class="form-select mb-3" aria-label="Default select example">
					<option selected>-- Situação</option>
					<option value="Ativo">Ativo</option>
					<option value="Inativo">Inativo</option>
				</select> 
				<button class="btn btn-success" type="submit">Atualizar cliente</button>
				<button class="btn btn-secondary" type="reset">Limpar formulário</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>