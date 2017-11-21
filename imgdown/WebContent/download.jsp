<%@page import="com.tz.util.TmDownImgUtil"   import="com.tz.util.getHtml2" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
     
     getHtml2 gcp = new getHtml2(); 
		String ss=gcp.getImageSrc(html);
		gcp.getHtmlPicture(ss);
		
        /*  String sm= getHtml2.getImageSrc(html); */
         
     %>
     
    
<body>
<div id="box" style="width: 1120px;margin: 0 outo;text-align: center;">
        <h1>下载成功</h1>
  </div>

</body>
</html>