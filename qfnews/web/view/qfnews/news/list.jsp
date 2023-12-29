<%--
  Created by IntelliJ IDEA.
  User: Komorebi
  Date: 2023/12/27
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../../js/bootstrap.min.js"></script>
</head>

<body>
<ul class="breadcrumb" style="margin:0;">
    <li><a href="#">新闻管理</a></li>
    <li>查询新闻</li>
</ul>
<form class="form-inline">
    <div class="row alert alert-info" style="margin: 0; padding: 3px;">
        <a class="btn btn-success" href="/news_add">添加新闻</a>
    </div>

    <table class="table table-condensed table-striped">
        <tr>
            <th>主键</th>
            <th>新闻标题</th>
            <th>新闻内容</th>
            <th>发布时间</th>
            <th>所属导航</th>
            <th>图片一</th>
            <th>图片二</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${retList}" var="bean">
        <tr>
            <td>${bean.id}</td>
            <td>${bean.title}</td>
            <td>${bean.content}</td>
            <td>${bean.datetime}</td>
            <td>${bean.nav}</td>
            <td>
                <a href="${bean.image}"target="_blank">
                    ${bean.image}
                </a>
            </td>
            <td>
                <a href="${bean.photo}"target="_blank">
                        ${bean.photo}
                </a>
            </td>
            <td>${bean.price}元</td>
            <th>
                <a class="btn btn-success btn-xs" href="/news_add?id=${bean.id}">修改</a>
                <a class="btn btn-danger btn-xs" href="/news_del?id=${bean.id}">删除</a>
            </th>
        </tr>
        </c:forEach>
    </table>

</form>
</body>
</html>
