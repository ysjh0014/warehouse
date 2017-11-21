<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
   *{margin:0;padding:0;}
    body{background:url(img/1.jpg);background-size:1300px 600px ;  background-attachment:fixed;}
    h1{height:80px;background:(0,0,0,0.5);color:#fff;font-weight:100;text-align: center;line-height: 80px;}
    #box{width: 800px;height: 620px;background: rgba(255,255,255,0.5);margin: 100px auto 0; }
    .b_footer{height:60px;background:green;}
    .b_footer .h_img{margin:0 20px;float: left;}
    .b_footer .h_span{color:#fff;line-height: 60px;font-size: 25px;float: left;}
    .b_body{width: 760px;height:440px;padding:20px;overflow:auto;/* 添加滚动条 */}
    .b_head{width:760px;height:60px;padding:0 20px;}
    /* .rotWord{overflow: hidden;}*/  /* 消除浮动 */
   /* .rotWord p{float:left;padding:10px;background:#00ffae;
    margin-left:10px;border-radius:8px;*/   /* 修边角  */   /*word-break:break-all;max-width:220px;  */   /* 到一定高度换行 */
 /*    }  */
    
      .myWord{overflow: hidden;} /* 消除浮动 */
     .myWord span{width:40px;height:40px;float:right;}
    .myWord p{float:right;padding:10px;background:#00ffae;
    margin-right:10px;border-radius:8px;word-break:break-all;max-width:220px;     /* 到一定高度换行 */
     }  
    .myWord span{text-align: center;} 
    
    #input{width:620px;height:60px;background:rgba(0,0,0,0.1);border-radius:8px;text-indent:10px;/* 文本首行缩进 */color:#fff;float:left;font-size:18px;outline:none;overflow:hidden;border:none;}
    #btn{width:100px;height:60px;background:white;border-radius:8px;user-select:none;/* 文字不让选中 */text-align: center;line-height:60px;float:right;font-size:18px;cursor:pointer;/* 变成一个小手 */}
    
    
    .b_body::-webkit-scrollbar{
         width:4px;
    }
    .b_body::-moz-scrollbar{
         width:4px;
    }
     .b_body::-webkit-scrollbar-track{
          background-color:#808080;
          border-radius:2em;
     }
     .b_body::-webkit-scrollbar-thumb{
     background-color: #03a9f4;
        border-radius:2em;
     }
       .b_body::-moz-scrollbar-track{
         background-color:#808080;
           border-radius:2em;
       }
        .b_body::-moz-scrollbar-thumb{
         background-color:#03a9f4;
         border-radius:2em;
        }
</style>
</head>
<body>
<h1>河南市区天气查询器</h1>
<div id="box">
 <div class="b_head">
    <input type="text" id="input"/>
    <input type="button" id="btn" value="查询" />
    </div>
    
       <div class="b_body">
         <div class="rotWord">
         </div>

  </div>
  <!--  <div class="b_footer">
        <img class="h_img" src="img/logo.png" width="80" height="60">
       <span class="h_span">人工智能机器人</span> 
    </div>  -->
</div> 

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script><!-- 这里按住ctrl然后鼠标放上去可以出现下划线 -->
<script type="text/javascript">
    	function action(){
     //获取输入框的内容
     var text=$("#input").val();
     //传递到后台
     if(text==""||text==null){
    	 return ;
     }else{
     $.ajax({
    	 //传递的地址
    	url:"chart",
    	//传递的方式
    	type:"post",
    	//传递的参数
    	data:{"text":text},
    	//返回的结果
    	success:function(result){
    	
    		  var text=$.parseJSON("{"+result+"}").text;
    		$(".b_body").append("<div class='rotWord'><span></span><p>"+text+"</p></div>") 
            
    	}
     });

     }
    	}
   
     $(document).keydown(function(event){
    	 if(event.keyCode==13){
    		 action();
    	 }  
      });  
</script>
</body>
</html>