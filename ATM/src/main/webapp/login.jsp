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
<style type="text/css">
      body {
        margin: 10px;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #fff;
      }
      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
    </style>
  </head>
  <body> 
 
    <div class="container">
      
   <center>   <h1>银行自助系统</h1>  </center>
 
      <form class="form-signin" action="/ATM/login.action" method="get" >
        <h3 class="form-signin-heading"><strong>登录</strong></h3>
        <div>
        <input type="text" class="input-block-level" name="name" placeholder="用户名" autocomplete="off"/>
        </div>
        <input type="password" class="input-block-level" name="password" placeholder="密码" autocomplete="off"><br>
      <button type="submit" class="btn btn-primary">确定</button>
       <button type="reset" class="btn btn-primary">重置</button>
    </div>
      </form>
     
    </div> 
   
  </body>
</html>