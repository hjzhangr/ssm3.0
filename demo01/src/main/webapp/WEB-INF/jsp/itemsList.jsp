<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询商品列表</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<script type="text/javascript">
		$(function () {
			var form = $("#form");
			$("#add").click(function () {
				window.location = "${pageContext.request.contextPath}/items/addItems.action";
			});
			$("#select").click(function () {
				form.attr("action", "${pageContext.request.contextPath}/items/findByName.action");
				form.submit();
			});
			$("#delete").click(function () {
				form.attr("action", "${pageContext.request.contextPath}/items/deleteItems.action");
				form.submit();
			});
		});
	</script>
</head>
<body>
<form id="form" method="post">
	<div style="margin-top: 20px">
		查询条件:
		<input class="input-sm" type="text" name="name">
		<button id="select" class="btn btn-primary">查询商品</button>
	</div>
	<table width="100%" class="table table-bordered">
		<caption class="text-center" style="font-size: large;font-weight: bold">商品列表</caption>
		<tr>
			<th>选择</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>生产日期</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${itemsList }" var="item">
			<tr>
				<td><input type="checkbox" name="ids" value="${item.id}"></td>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${item.detail }</td>
				<td><a href="${pageContext.request.contextPath }/items/editItem.action?id=${item.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="pull-right">
		<button type="button" class="btn btn-success" id="add">添加商品</button>
	</div>
	<div class="pull-left">
		<button type="button" class="btn btn-danger" id="delete">删除商品</button>
	</div>
</form>
</body>
</html>