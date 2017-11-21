package com.tz.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.GapContent;

public class getHtml2 {
	public void getHtmlPicture(String httpUrl) { 
		URL url; 
		BufferedInputStream in; 
		FileOutputStream file; 
		try { 
		   System.out.println("取网络图片"); 
		   String fileName = httpUrl.substring(httpUrl.lastIndexOf("/"));
		  // String fileName="百度.gif";
		  // System.out.println(fileName);
		   String filePath = "F:\\FocuSimple\\test\\src\\pic\\"; 
		   
		  // String filePath="f:\\";
		   url = new URL(httpUrl); 
		  
		   in = new BufferedInputStream(url.openStream()); 
		  
		   file = new FileOutputStream(new File(filePath+fileName)); 
		   int t; 
		   while ((t = in.read()) != -1) { 
		   file.write(t); 
		   } 
		   file.close(); 
		   in.close(); 
		  System.out.println("图片获取成功"); 
		} catch (MalformedURLException e) { 
		   e.printStackTrace(); 
		} catch (FileNotFoundException e) { 
		  e.printStackTrace(); 
		} catch (IOException e) { 
		   e.printStackTrace(); 
		} 
		} 
		  
		
	public static  String getImageSrc(String htmlCode) {
	 // List  <String> imageSrcList = new ArrayList<String>();
       
		StringBuilder imageSrcList=new StringBuilder();
		
		
      Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);
	    Matcher m = p.matcher(htmlCode);
	    String quote = null;
	    String src = null;
	    while (m.find()) {
	        quote = m.group(1);
	 
	        // src=https://sms.reyo.cn:443/temp/screenshot/zY9Ur-KcyY6-2fVB1-1FSH4.png
	        src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("\\s+")[0] : m.group(2);
	        imageSrcList.append(src);
	 
	    }
	    return imageSrcList.toString();
	}
	
	
		public static void main(String[] args) throws IOException { 
		String url=TmDownImgUtil.htmlSource("http:\\www.qq.com", "gbk");
		getHtml2 gcp = new getHtml2(); 
	
		String ss=gcp.getImageSrc(url);
		gcp.getHtmlPicture(ss);
		
	
		} 
}
