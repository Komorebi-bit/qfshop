<%--
  Created by IntelliJ IDEA.
  User: Komorebi
  Date: 2023/12/27
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insert Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../../js/bootstrap.min.js"></script>

    <script src="../../../js/jquery.ajaxupload.js"></script>

    <script>
      //$是jQuery工具
        window.onload = function (){
          $.ajaxUploadSettings.name = 'file';
          //获取id=image的
          //ajaxUploadPrompt()会弹出一个上传文件的窗口
          $('#image').ajaxUploadPrompt({//配置参数
            url:'/news_image', //java地址，java去接收这个图
            success:function (data){//图片上传成功
                // alert(data);//java把数据在返回回来
                $('#image').prev().val(data);
                $('#image').next().attr('src',data);
            },
          });

          $('#photo').ajaxUploadPrompt({//配置参数
            url:'/news_image', //java地址，java去接收这个图
            success:function (data){//图片上传成功
              // alert(data);//java把数据在返回回来
              $('#photo').prev().val(data);
              $('#photo').next().attr('src',data);
            },
          });

        }
    </script>

</head>

<body>
<ul class="breadcrumb" style="margin:0;">
    <li><a href="#">新闻管理</a></li>
    <li>
        <c:if test="${empty bean}">添加新闻</c:if>
        <c:if test="${not empty bean}">修改新闻</c:if>
    </li>
</ul>
<form action="/news_add" method="post" class="form-horizontal">

    <c:if test="${not empty bean}">
    <input type="hidden" name="id" value="${bean.id}">
    </c:if>

    <h5 class="page-header alert-info" style="padding:10px;margin:0 0 10px 0;">基本信息</h5>
    <div class="row col-sm-9 form-group">
        <label class="col-sm-3 control-label">新闻标题</label>
        <div class="col-sm-6">
            <input type="text" name="title" class="form-control input-sm" value="${bean.title}"/>
        </div>
    </div>
    <div class="row col-sm-9 form-group">
        <label class="col-sm-3 control-label">新闻内容</label>
        <div class="col-sm-6">
            <input type="text" name="content" class="form-control input-sm" value="${bean.content}"/>
        </div>
    </div>
    <div class="row col-sm-9 form-group">
        <label class="col-sm-3 control-label">图片1</label>
        <div class="col-sm-6">
            <input type="hidden" name="image" class="form-control input-sm" value="${bean.image}"/>
            <input id="image" type="button" class="btn btn-success" value="上传图片"/>
            <img src="${bean.image}" style="display: block; max-width: 200px"/>
        </div>
    </div>
    <div class="row col-sm-9 form-group">
        <label class="col-sm-3 control-label">图片2</label>
        <div class="col-sm-6">
            <input type="hidden" name="photo" class="form-control input-sm" value="${bean.photo}"/>
            <input id="photo" type="button" class="btn btn-success" value="上传图片">
            <img src="${bean.photo}" style="display: block; max-width: 200px;">
        </div>
    </div>
    <div class="row col-sm-9 form-group">
        <label class="col-sm-3 control-label">价格</label>
        <div class="col-sm-6">
            <input type="number" name="price" class="form-control input-sm" value="${bean.price}"/>
        </div>
    </div>
    <div class="row col-sm-9 form-group">
        <label class="col-sm-3 control-label">所属导航</label>
        <div class="col-sm-6">
            <select name="nid" class="form-control input-sm">
                <c:forEach items="${navList}" var="item">
                <option
                        <c:if test="${item.id == bean.nid}">selected</c:if>
                        value="${item.id}">${item.nav}
                </option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="col-sm-3 col-sm-offset-4">
        <input  type="submit" class="btn btn-success" value="保存"/>
        <a class="btn btn-warning" href="javascript:history.back()">返回上一级</a>
    </div>
</form>

</body>
</html>

