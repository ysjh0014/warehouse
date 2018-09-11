<%@ page language="java" import="java.util.*" import="com.ccnu.bean.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>主界面</title>
       <meta name="viewport" charset="utf-8" content="width=device-width, initial-scale=1.0">
<!-- 新 Bootstrap 核心 CSS 文件 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
<!-- 可选的Bootstrap主题文件（一般不用引入） 加到head中 -->  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入  加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>  
<!-- 最新的 Bootstrap 核心 JavaScript 文件 加到body内最后面中 -->  
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>  

    <style text="text/css">
    #bs-example-navbar-collapse-1{
      margin:auto;
      width:700px;
    }
    #accountInfo{
      margin:auto;
      width:700px;
      margin-top:150px;
       align:center;
    }
    #mytable{
      margin:auto;
      width:400px;
    
    }
    </style>
    
  </head>
  <body>
  
	<div id="accountInfo"> 
	  <h2>用户名或密码错误。。。。。</h2>  
        <div id="div1"></div>  
  </div>
 <script type="text/javascript" src="../static/jquery-1.12.4.min.js"></script>
 <script type="text/javascript">
 var start = 5;  
 var step = -1;  
 function count() {  
      document.getElementById("div1").innerHTML = "<h2>页面将在" + start+ "秒后返回登录页面。。。。。</h2>"; 
//      $("#div1").append("<h2>页面将在"+satrt+"秒后返回登录页面。。。。。</h2>");
     start += step;  
     if (start <= 0) {  
         start = 5;  
         //alert(start);  
         window.location = "login.jsp";//重定位  
     }  
     setTimeout("count()", 1000);  
 }  
 window.onload = count;  
 </script>
  </body>
</html>
