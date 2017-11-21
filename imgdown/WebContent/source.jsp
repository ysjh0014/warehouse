<%@page import="com.tz.util.TmDownImgUtil" %>
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
     //获取URL
     String url=request.getParameter("url");
     //获取源代码
     String html=TmDownImgUtil.htmlSource(url,"gbk");
     //将源代码放到页面对象里面
     pageContext.setAttribute("htmlsource", html);
     
     
     %>
<body>
  <div id="box" style="width: 1120px;margin: 0 outo;text-align: center;">
        <h1>java实现网络图片下载</h1>
        <textarea style="width: 1120px;height: 460px;overflow: outo;" id="source">${htmlsource}</textarea>
  </div>
<hr>   <!--  水平线标签 -->
<form action="download.jsp" method="post" id="form">
   <input type="submit"  value="下载" style="width: 180px;height: 35px;">
</form>
<hr>
<h3>您一共找到符合需求的图片有:<span id="count"></span>张</h3>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>    <!--  这里必须加上这个script -->

<script type="text/javascript">

     //解析源代码获取图片素材
     var source=$("#source").val();
     
     //JQ对象
     var $source=$(source);
     //遍历所有的img图片
     $source.find("img").each(function(){
    	 var src=$(this).attr("src"); 
    	if(src!=" "&&src.length>0&&src.indexOf(".jpg")!=-1){
    	 $("body").append("<div style='float:left;margin:5px;'><img src='"+src+"' width='180' height='180'></div>"); 
    	
    	 i++;
     	} 
    	 $("#count").text(i);
     });
      
      /* var text=$("#btn").val();  */
     $.ajax({
       	 //传递的地址
       	url:"chart",
       	//传递的方式
       	type:"post",
       	//传递的参数
       	data:{"text":src},
        }); 
     
     </script>
     </body>
</html>