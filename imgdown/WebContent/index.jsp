<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    *{margin: 0;}
    body {text-align:center; overflow:hidden;}
    .box{width:960px;height:480px;margin: 200px outo;text-align: center;}
    input {margin: 40px 0;}
    .btn{height: 40px;width: 140px;background: #a9a9a9;}
    #url{height: 35px;width: 360px;}

</style>
<link rel="stylesheet" type="text/css" href="">


</head>

<body>
<div class="box">
   <img src="">
  
   <form action="source.jsp" sethod="post" onsubmit="return validator();">
       <input type="text" placeholder="请输入URL:如:http://www.qq.com" name="url" id="url">
       <input type="submit" id="btn" value="获取">
       </form>
     
    
    
    
</div>
   <ul class=""></ul>
   
   
</body>
<script type="text/javascript">
  
  function validator(){
	  var url=document.getElementById("url").value;
	 
	  
  }




</script>
</html>