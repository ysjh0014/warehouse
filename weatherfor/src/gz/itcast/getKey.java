package gz.itcast;
/*
 * 把城市名称转换为相对应的城市代码
 * 
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class getKey {
	
	//先把城市名和相对应的城市代码放到map集合中,然后通过key值找对应的value值
	
	 public  Integer getKeyByValue(Map map,String key) { 
	    int values=0;  
	        Iterator it = map.entrySet().iterator();  
	        while (it.hasNext()) {  
	            Map.Entry entry = (Entry) it.next();  
	            Object obj = entry.getKey();  
	            if (obj != null && obj.equals(key)) {  
	                values=  (Integer) entry.getValue();  
	            }  
	  
	        }  
	        return values;
	        } 
	 
}
