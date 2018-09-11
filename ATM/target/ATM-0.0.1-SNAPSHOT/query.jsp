<%@ page language="java" import="java.util.*" import="com.ccnu.bean.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>查询明细</title>
       <meta name="viewport" charset="utf-8" content="width=device-width, initial-scale=1.0">
<!-- 新 Bootstrap 核心 CSS 文件 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
<!-- 可选的Bootstrap主题文件（一般不用引入） 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入  加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>  
<!-- 最新的 Bootstrap 核心 JavaScript 文件 加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>  
<link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
<script src="js/bootstrap-datetimepicker.js"></script>  

    <style text="text/css">
    #bs-example-navbar-collapse-1{
      margin:auto;
      width:700px;
    }
    #accountInfo{
      margin:auto;
      width:700px;
      margin-top:50px;
       align:center;
    }
    #mytable{
      margin:auto;
      width:auto;
    }
    </style>
    
  </head>
  <body>
  <nav class="navbar navbar-inverse" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">主菜单</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        	<li><a href="input.jsp">存款</a></li>
            <li><a href="output.jsp">取款</a></li>
            <li><a href="transferAccount.jsp">转账</a></li>
            <li class="active"><a href="query.jsp">余额</a></li>
            
            <li><a href="modifyApw.jsp">重置密码</a></li>
             <li><a href="/ATM/list.action">退出</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
	<div id="accountInfo"> 
	<center><strong>余额</strong></center><br>
	
<form name="myform"  method="get" id="mytable" action="/ATM/balance.action">
   <button type="submit" class="btn btn-primary">查询</button><br><hr>
   <br>
 </form>
   
   <div class="bs-example">
    <table class="table table-hover">
      <thead>
        <tr>
          <th>账号</th>
          <th>余额</th>
        </tr>
      </thead> 
      <tbody>
     
			<tr>
				<td>${param.uuid}</td>
				<td>${param.money}</td>
				</tr>
      </tbody>
    </table>
  </div>
       
  </table>
 
  </div>
 
  </body>
</html>
