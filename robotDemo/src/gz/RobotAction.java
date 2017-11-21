package gz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.VoiceStatus;

import com.sun.corba.se.pept.transport.Connection;

import sun.print.resources.serviceui_pt_BR;

/*
 * 聊天信息处理类
 * 
 */
@WebServlet("/robot")
public class RobotAction extends HttpServlet {
	public static final String APIKEY="0d0bde5c75104a64aaf83c6c0143dcb8";//这里引号中不能有空格
	public static final String url="http://www.tuling123.com/openapi/api?key=";
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RobotAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求以及响应编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String text=req.getParameter("text");
		String result=getResult(text);
		resp.getWriter().println(result);
	}
	
	public static String getResult(String text){
		String INFO=null;
		StringBuilder sb=new StringBuilder();
		try {
			INFO=URLEncoder.encode(text,"UTF-8");
			String getUrl=url+APIKEY+"&info="+INFO;
			URL queryUrl=new URL(getUrl);
			URLConnection connection=queryUrl.openConnection();
			BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      String temp="";
			while((temp=br.readLine())!=null){
				sb.append(temp);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
}
