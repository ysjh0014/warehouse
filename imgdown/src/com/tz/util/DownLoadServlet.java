package com.tz.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/query")
public class DownLoadServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String text= req.getParameter("img");
		 
			try {
				download(text,"c:\\image\\");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 public static void main(String[] args) {  
		 String url = "http://www.baidu.com/img/baidu_sylogo1.gif";  
	        byte[] btImg = getImageFromNetByUrl(url);  
	        if(null != btImg && btImg.length > 0){  
	            System.out.println("读取到：" + btImg.length + " 字节");  
	       
	            String fileName = "百度.gif";  
	            
	            writeImageToDisk(btImg, fileName);  
	        }else{  
	            System.out.println("没有从该连接获得内容");  
	        } 
		 
}
	/*
	 public static String download(String urlString,String savePath) throws Exception {  
	        // 构造URL  
	        URL url = new URL(urlString);  
	        // 打开连接  
	        URLConnection con = url.openConnection();  
	        //设置请求超时为5s  
	        con.setConnectTimeout(5*1000);  
	        // 输入流  
	        InputStream is = con.getInputStream();  
	      
	        // 1K的数据缓冲  
	        byte[] bs = new byte[1024];  
	        // 读取到的数据长度  
	        int len;  
	        // 输出的文件流  
	       File sf=new File(savePath);  
	       if(!sf.exists()){  
	           sf.mkdirs();  
	       }  
	       OutputStream os = new FileOutputStream(sf.getPath());  
	        // 开始读取  
	        while ((len = is.read(bs)) != -1) {  
	          os.write(bs,0, len);  
	        }  
	        // 完毕，关闭所有链接  
	        os.close();  
	        is.close();  
	    
	    return os.toString();
	}
	*/

	 
	  public static void writeImageToDisk(byte[] img, String fileName){  
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
	    /** 
	     * 根据地址获得数据的字节流 
	     * @param strUrl 网络连接地址 
	     * @return 
	     */  
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
	    /** 
	     * 从输入流中获取数据 
	     * @param inStream 输入流 
	     * @return 
	     * @throws Exception 
	     */  
	    public static byte[] readInputStream(InputStream inStream) throws Exception{  
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	        byte[] buffer = new byte[1024];  
	        int len = 0;  
	        while( (len=inStream.read(buffer)) != -1 ){  
	            outStream.write(buffer, 0, len);  
	        }  
	        inStream.close();  
	        return outStream.toByteArray();  
	    }  

}

