package com.tz.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/chart")
public class GetImg extends HttpServlet{
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String url =req.getParameter("src");
		 public static void main(String[] args) {
		
		String url= "http://img1.gtimg.com/v/pics/hv1/169/254/2244/145981039.jpg";
		 Matcher m1 =Pattern.compile("/index.sjpg").matcher(url); //利用正则表达式解析出想要的数据
	        while(m1.find()){
	   System.out.println(m1.group(1));
	        }
		 
	       /* byte[] btImg = getImageFromNetByUrl(url);  
	        if(null != btImg && btImg.length > 0){  
	            System.out.println("读取到：" + btImg.length + " 字节");  //http://img1.gtimg.com/v/pics/hv1/169/254/2244/145981039.jpg
	           String fileName = ".gif";  
	            writeImageToDisk(btImg,fileName);  
	        }else{  
	            System.out.println("没有从该连接获得内容");  
	        }*/ 
		 
}/*
	  public static void writeImageToDisk(byte[] img,String fileName){  
	        try {  
	            File file = new File("f:\\"+fileName);  
	            FileOutputStream fops = new FileOutputStream(file);  
	            fops.write(img);  
	            fops.flush();  
	            fops.close();  
	            System.out.println("图片已经写入到f盘");  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    *//** 
	     * 根据地址获得数据的字节流 
	     * @param strUrl 网络连接地址 
	     * @return 
	     *//*  
	    public static byte[] getImageFromNetByUrl(String strUrl){  
	        try {  
	            URL url = new URL(strUrl);  
	            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	            conn.setRequestMethod("GET");  
	            conn.setConnectTimeout(5 * 1000);  
	            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
	            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
	            return btImg;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	    }  
	    *//** 
	     * 从输入流中获取数据 
	     * @param inStream 输入流 
	     * @return 
	     * @throws Exception 
	     *//*  
	    public static byte[] readInputStream(InputStream inStream) throws Exception{  
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	        byte[] buffer = new byte[1024];  
	        int len = 0;  
	        while( (len=inStream.read(buffer)) != -1 ){  
	            outStream.write(buffer, 0, len);  
	        }  
	        inStream.close();  
	        return outStream.toByteArray();  
	    }  */

}
