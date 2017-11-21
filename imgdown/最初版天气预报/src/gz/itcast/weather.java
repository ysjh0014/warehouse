package gz.itcast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JLabel;


//@WebServlet("/query")//和前端页面联系起来
public class weather extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		  Map map=new HashMap();
    	map.put("北京", 101010100);map.put("南阳", 101180701);map.put("杭州", 101210101);map.put("郑州",101180101);
    	map.put("朝阳", 101010300);map.put("顺义", 101010400);map.put("怀柔", 101010500);map.put("通州",101010600);
    	map.put("昌平", 101010700);map.put("延庆", 101010800);map.put("丰台", 101010900);map.put("平顶山",101180501);
    	
    	
    	map.put("洛阳", 101180901);map.put("开封", 101180801);map.put("商丘", 101181001);map.put("安阳",101180201);
    	map.put("新乡", 101180301);map.put("许昌", 101180401);map.put("鹤壁",101181201);map.put("焦作",101181101);
    	map.put("濮阳", 101181301);map.put("三门峡", 101181701);map.put("漯河", 101181501);map.put("周口",101181401);
    	map.put("驻马店", 101181601);map.put("信阳", 101180601);map.put("", 101010900);map.put("",101180501);
    	
    	int i=0;
		String cityname= req.getParameter("city");
		
		getKey srr=new getKey();
		i=srr.getKeyByValue(map, cityname);
		
		resp.setCharacterEncoding("gbk");
		//resp.getWriter().print(getResult(i));
		 //Matcher m =Pattern.compile("\"(.*?)\":\"(.*?)\"").matcher(getResult(i));
		Matcher m1 =Pattern.compile("\"city\":\"(.*?)\",\"cityid\"").matcher(getResult(i)); //利用正则表达式解析出想要的数据
	        while(m1.find()){
	   resp.getWriter().print("城市"+":"+m1.group(1)+"\n");
	        }
	    	Matcher m2 =Pattern.compile("\"date_y\":\"(.*?)\",\"fchh\"").matcher(getResult(i)); 
	        while(m2.find()){
	   resp.getWriter().print("日期"+":"+m2.group(1)+"\n");
	        }
	    	Matcher m3 =Pattern.compile("\"week\":\"(.*?)\",\"date_y\"").matcher(getResult(i)); 
	        while(m3.find()){
	   resp.getWriter().print("星期"+":"+m3.group(1)+"\n");
	        } 
	        Matcher m4 =Pattern.compile("\"weather1\":\"(.*?)\",\"weather2\"").matcher(getResult(i)); 
	        while(m4.find()){
	   resp.getWriter().print("天气"+":"+m4.group(1)+"\n");
	        }   
	    	Matcher m5 =Pattern.compile("\"temp1\":\"(.*?)\",\"tempF1\"").matcher(getResult(i)); 
	        while(m5.find()){
	   resp.getWriter().print("温度"+":"+m5.group(1)+"\n");
	        }
	        Matcher m6 =Pattern.compile("\"wind1\":\"(.*?)\",\"wind2\"").matcher(getResult(i)); 
	        while(m6.find()){
	   resp.getWriter().print("风速"+":"+m6.group(1)+"\n");
	        } 
	  
	}
	
	
	/*public static String openUrl(String path,String args,String methed){	
		StringBuilder sb=new StringBuilder();
		BufferedReader br=null;
		if("".equals(path)||path==null){
			sb.append("请求地址不能为空");
		}else{
			if("POST".equals(methed.toUpperCase())){
			
				try {
				URL	url = new URL(path+args+".html");
				HttpURLConnection connection=(HttpURLConnection) url.openConnection();
				//设置请求方法
				connection.setRequestMethod("POST");
				//设置是否运行数据写入
				connection.setDoInput(true);
				//设置是否运行数据读取
				connection.setDoOutput(true);
				//设置网络请求时间
				connection.setConnectTimeout(15000);
				connection.setReadTimeout(10000);
				OutputStreamWriter out=new OutputStreamWriter(connection.getOutputStream());
				//写入参数
				
				out.write(args);
				out.flush();
				
				br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String temp=" ";
				while ((temp = br.readLine()) != null) {
					sb.append(temp);
				}
			}
				 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
			try {
				
				URL url=new URL(path+args+".html");
				URLConnection connection=url.openConnection();
				br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String temp=" ";
				while ((temp = br.readLine()) != null) {
					sb.append(temp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
		
	
		}
		
		
		
	
		return sb.toString();
}*/
	
	
	
	
	
	public static String  getResult(int cityy) {
		// String
		// path1="http://apis.haoservice.com/weather?cityname="+city+"&key="+key+"";
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			//通过URL伪装一个浏览器进行网页访问
			URL url = new URL("http://weather.123.duba.net/static/weather_info/"+cityy+".html");
			//相当于回车
			URLConnection connection = url.openConnection();

			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String temp = "";
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
