package com.tz.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 * 
 * 下载图片工具类
 * 
 * 
 * 种下一棵树最好的时间是十年以前，其次是现在
 * 
 */
import org.eclipse.jdt.internal.compiler.batch.Main;

public class TmDownImgUtil {
	
	private static InputStream inputStream;

	/*
	 * 
	 * 依据网址获取源代码
	 * link:网址
	 * encoding:编码
	 * 
	 * 
	 */
	public static String htmlSource(String link,String encoding){
		
		StringBuilder sb = new StringBuilder();
		//获取网络对象
		try {
			URL url=new URL(link);
			//建立网络链接
		URLConnection uc = url.openConnection();//这里需要把catch里的异常放到最大        ctrl+2  L  可以自动生成变量名
		//伪装(越过防火墙)
		uc.setRequestProperty("User-Agent", "java");
		/*
		 * 下载源代码(下载文件涉及到流)
		 */
		//获取文件输入流
	       InputStream inputStream = uc.getInputStream();
	    //建立io流的缓冲   (建立缓冲区是为了提升效率)
	     InputStreamReader in=new InputStreamReader(inputStream, encoding);
	      //下载源代码的缓冲
	     BufferedReader bufferedReader=new BufferedReader(in);
	     
	     
	     /*
	      * 开始下载源码
	      */
	     
	     //创建一个临时文件
	     String temp = "";
	     //循环
			while ((temp = bufferedReader.readLine()) != null) {
				sb.append(temp+"\n");
			}
			
			//关闭流 (顺序:先进后出，后进先出)
			bufferedReader.close();
			in.close();
			
		} catch (MalformedURLException e) {
			//打印堆栈信息
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
       //在中国2005年以前用的是gbk gb2312   2005年以后是utf-8
		String html=htmlSource("http://www.qq.com", "gbk");
	    System.out.println(html);
	}
	
	
}
