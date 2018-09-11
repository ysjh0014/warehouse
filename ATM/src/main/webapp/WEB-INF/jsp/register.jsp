<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>   
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="viewport" charset="utf-8"  content="width=device-width, initial-scale=1.0">
    <!-- 新 Bootstrap 核心 CSS 文件 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
<!-- 可选的Bootstrap主题文件（一般不用引入） 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入  加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>  
<!-- 最新的 Bootstrap 核心 JavaScript 文件 加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>   
 
<TITLE>注册</TITLE>

<style type="text/css">
 #main{
   margin:auto;
   width:300px;
 };
</style>
</HEAD>
<BODY>
<br>
	<form action="/ATM/register.action" method="get" role="form" id="main">
  <div class="form-group">
  <h2><strong>客户注册</strong></h2>
    <label for="username">用户名：</label>
    <input type="text" class="form-control" name="name" autocomplete="off"><br>
    
    <label for="career">密码：</label>
    <input type="text" class="form-control" name="password" autocomplete="off"><br>
    <button type="submit" class="btn btn-primary">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="reset" class="btn btn-primary">重置</button>
  </div>
	
 
	 
</BODY>
</HTML>